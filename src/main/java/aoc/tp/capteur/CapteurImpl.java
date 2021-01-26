package aoc.tp.capteur;

import java.util.List;
import java.util.ArrayList;

import aoc.tp.algo.AlgoDiffusion;
import aoc.tp.algo.DiffusionAtomique;
import aoc.tp.observer.Observer;
import aoc.tp.observer.AbstractSubject;

public class CapteurImpl extends AbstractSubject implements Capteur {

	private int v_write = 0;
	private int v_read = v_write;
	private boolean open = true;
	private AlgoDiffusion algo = new DiffusionAtomique(this);
	
	public CapteurImpl() {}
	
	public int getValue() {
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
//		v_write++;
//		notifyObservers();
	}

}
