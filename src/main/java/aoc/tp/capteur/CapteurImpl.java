package aoc.tp.capteur;

import aoc.tp.algo.AlgoDiffusion;
import aoc.tp.observer.Observer;

public class CapteurImpl implements Capteur {

	private int v;
	private AlgoDiffusion algo;
	private boolean lock;
	
	public CapteurImpl(AlgoDiffusion algo) {
		this.algo = algo;
		v = 0;
		lock = false;
	}

	public void attach(Observer o) {
		// TODO Auto-generated method stub
		
	}

	public void detach(Observer o) {
		// TODO Auto-generated method stub
		
	}

	public int getValue() {
		return v;
	}

	public void tick() {
		v++;
		//algo .
		algo.execute();

	}

}
