package aoc.tp.capteur;

import java.util.logging.Logger;

import aoc.tp.algo.AlgoDiffusion;
import aoc.tp.algo.DiffusionAtomique;
import aoc.tp.algo.DiffusionSequentielle;
import aoc.tp.observer.AbstractSubject;

public class CapteurImpl extends AbstractSubject implements Capteur {

	private int v_write = 0;
	private int v_read = v_write;
	private boolean locked = false;
    private boolean blocked = false;
	private AlgoDiffusion algo = new DiffusionSequentielle(this);

	public CapteurImpl() {
	}

	public int getValue() {
		algo.valueRead();
		return v_read;
	}

	public void lock() {
		locked = true;
	}

	public void unlock() {
		locked = false;
	}

    public void block() {
        Logger.getLogger("Error").info("blocked");
        blocked = true;
    }

    public void unblock() {
        Logger.getLogger("Error").info("unblocked");
        blocked = false;
    }

	public void tick() {
		algo.execute();
		// TODO Améliorer cette partie
		while (locked) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (!locked) {
			v_write++;
		}
        if (!blocked) {
            v_read = v_write;
        }
	}

	public void setAlgorithm(AlgoDiffusion a) {
		algo = a;
	}
}
