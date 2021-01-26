package aoc.tp.observer;

public interface Subject {

	public void attach(Observer<?> o);

	public void detach(Observer<?> o);

	public void notifyObservers();
	
	public int getNbObservers();
}
