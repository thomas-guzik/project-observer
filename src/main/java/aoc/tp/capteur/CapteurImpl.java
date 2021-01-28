package aoc.tp.capteur;

import aoc.tp.algo.AlgoDiffusion;
import aoc.tp.algo.DiffusionAtomique;
import aoc.tp.observer.AbstractSubject;

public class CapteurImpl extends AbstractSubject implements Capteur {

	private int v_write = 0;
	private int v_read = v_write;
	private boolean open = true;
	private AlgoDiffusion algo = new DiffusionAtomique(this);

	public CapteurImpl() {
	}

	public int getValue() {
		algo.valueRead();
		return v_read;
	}

	public void lock() {
		open = false;
	}

	public void unlock() {
		open = true;
	}

	public void tick() {
		algo.execute();
		// TODO Améliorer cette partie
		while (!open) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (open) {
			v_write++;
		}
		v_read = v_write;
	}

	public void setAlgorithm(AlgoDiffusion a) {
		algo = a;
	}
}
