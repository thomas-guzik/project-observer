package aoc.tp.capteur;

import aoc.tp.algo.AlgoDiffusion;
import aoc.tp.observer.Subject;

public interface Capteur extends Subject {
	public StampedValue getValue();
	public void tick();
	public CapteurState getState();
	public void setState(CapteurState state);
	public void setAlgorithm(AlgoDiffusion a);
}
