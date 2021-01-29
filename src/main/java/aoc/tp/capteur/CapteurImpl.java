package aoc.tp.capteur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import aoc.tp.algo.AlgoDiffusion;
import aoc.tp.algo.DiffusionAtomique;
import aoc.tp.observer.AbstractSubject;

public class CapteurImpl extends AbstractSubject implements Capteur {

	private int v_write = 0;
	private StampedValue v_read = new StampedValue(v_write);
	private AlgoDiffusion algo = new DiffusionAtomique(this);
	private CapteurState state = CapteurState.WRITE;

	List<Integer> traces_read = new ArrayList<>();

	Lock lock = new ReentrantLock();

	public CapteurImpl() {
	}

	@Override
	public StampedValue getValue() {
		algo.valueRead();
		return v_read;
	}

	@Override
	public void tick() {
		if (state == CapteurState.READ_SEQUENTIAL) {
			v_write++;
		} else {
			boolean waiting = true;
			while (waiting) {
				lock.lock();
				if (state == CapteurState.WRITE) {
					v_write++;
					updateRead();
					waiting = false;
					algo.execute();
				}
				lock.unlock();
				if (state == CapteurState.READ_ATOMIQUE) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	public void setAlgorithm(AlgoDiffusion a) {
		algo = a;
		a.setCapteur(this);
	}

	@Override
	public CapteurState getState() {
		return state;
	}

	@Override
	public void setState(CapteurState state) {
		this.state = state;
	}

	@Override
	public void updateRead() {
		v_read = new StampedValue(v_write);
		traces_read.add(v_write);
	}
}
