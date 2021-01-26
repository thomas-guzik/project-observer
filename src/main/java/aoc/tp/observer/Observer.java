package aoc.tp.observer;

public interface Observer<T extends Subject> {

	public void update(T subject);
}
