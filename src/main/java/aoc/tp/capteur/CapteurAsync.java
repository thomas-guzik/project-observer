package aoc.tp.capteur;

import aoc.tp.observer.Subject;

import java.util.concurrent.Future;

public interface CapteurAsync extends Subject {
	public Future<StampedValue> getValue();

	public void tick();
}
