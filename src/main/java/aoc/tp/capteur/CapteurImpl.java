package aoc.tp.capteur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

import aoc.tp.algo.AlgoDiffusion;
import aoc.tp.algo.DiffusionAtomique;
import aoc.tp.algo.DiffusionIncoherence;
import aoc.tp.algo.DiffusionSequentielle;
import aoc.tp.observer.AbstractSubject;

public class CapteurImpl extends AbstractSubject implements Capteur {

	private int v_write = 0;
	private StampedValue v_read = new StampedValue(v_write);
	private AlgoDiffusion algo = new DiffusionIncoherence(this);
	private CapteurState state = CapteurState.WRITE;

	List<Integer> traces_read = new ArrayList<>();

	Lock lock = new ReentrantLock();
	Condition waitWrite = lock.newCondition();

	int waitTicks = 0;

	public CapteurImpl() {
	}

	public StampedValue getValue() {
		algo.valueRead();
		return v_read;
	}

	// 1 - tick(), state = WRITE
	// 2 - algo.execute(), notify() state = READ_ATOMIQ
	// 3 - tick(), state = READ_ATOMIQ
	// 4 - algo.execute(), block()
	// 5 - state = WRITE
	// 6 - v++
	// 7 - notify(), state = READ_ATOMIQ
	// 8 - state = WRITE
	// 9 - v++

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

	public void updateRead() {
		v_read = new StampedValue(v_write);
		traces_read.add(v_write);

	}

}
