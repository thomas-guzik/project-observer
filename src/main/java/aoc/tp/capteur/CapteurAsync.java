package aoc.tp.capteur;

import aoc.tp.observer.Subject;

import java.util.concurrent.Future;

public interface CapteurAsync extends Subject {
	public Future<Integer> getValue();
	public void tick();
}
