package aoc.tp.observer;

import java.util.List;
import java.util.ArrayList;

public abstract class AbstractSubject implements Subject {

	private List<Observer> observers = new ArrayList<>();
    
    public void attach(Observer o) {
		observers.add(o);
	}

	public void detach(Observer o) {
		observers.remove(o);
    }
    
    public void notifyObservers() {
        for (Observer observer : observers) {
			observer.update(this);
		}
    }
}
