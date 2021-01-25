package aoc.tp.capteur;

import java.util.List;
import java.util.ArrayList;

import aoc.tp.algo.AlgoDiffusion;
import aoc.tp.observer.Observer;
import aoc.tp.observer.AbstractSubject;

public class CapteurImpl extends AbstractSubject implements Capteur {

	private int v;
	
	public CapteurImpl() {
		v = 0;
	}

	public int getValue() {
		return v;
	}

	public void tick() {
		v++;
		notifyObservers();
	}

}
