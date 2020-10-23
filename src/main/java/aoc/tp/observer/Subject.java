package aoc.tp.observer;

import java.util.List;

public interface Subject {
	
	public void attach(Observer o);
	public void detach(Observer o);
}
