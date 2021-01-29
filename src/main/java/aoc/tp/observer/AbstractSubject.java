package aoc.tp.observer;

import java.util.List;
import java.util.ArrayList;

public abstract class AbstractSubject implements Subject {

	private List<Observer<Subject>> observers = new ArrayList<>();
    
	@Override
    public void attach(Observer<Subject> o) {
		observers.add(o);
	}

	@Override
	public void detach(Observer<Subject> o) {
		observers.remove(o);
    }
    
	@Override
    public void notifyObservers() {
        for (Observer<Subject> observer : observers) {
			observer.update(this);
		}
    }
    
	@Override
    public int getNbObservers() {
		return observers.size();
    	
    }
}
