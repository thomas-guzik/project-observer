package aoc.tp.servant;

import aoc.tp.observer.Subject;

public interface Capteur extends Subject {
	public int getValue();
	public void tick();
}
