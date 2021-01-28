package aoc.tp.capteur;

import aoc.tp.observer.Subject;

public interface Capteur extends Subject {
	public int getValue();
	public void tick();
	public void lock();
	public void unlock();
	public void block();
	public void unblock();
	public CapteurState getState();
	public void setState(CapteurState state);
}
