package aoc.tp.observer;

public interface Observer<T> {
	public void update(T subject);
}