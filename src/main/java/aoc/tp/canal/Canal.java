package aoc.tp.canal;

import aoc.tp.observer.AbstractSubject;
import aoc.tp.afficheur.ObserverDeCapteur;
import aoc.tp.afficheur.ObserverDeCapteurAsync;
import aoc.tp.capteur.Capteur;
import aoc.tp.capteur.CapteurAsync;
import aoc.tp.capteur.StampedValue;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Canal extends AbstractSubject implements CapteurAsync, ObserverDeCapteurAsync {

	private Capteur capteur;
	private ObserverDeCapteur afficheur;
	private ScheduledExecutorService scheduler;

	public Canal(Capteur capteur, ObserverDeCapteur afficheur, ScheduledExecutorService scheduler) {
		this.capteur = capteur;
		this.afficheur = afficheur;
		this.scheduler = scheduler;
	}

	@Override
	public void update(Capteur subject) {
		scheduler.schedule(() -> {
			afficheur.update(this);
		}, ThreadLocalRandom.current().nextInt(0, 100), TimeUnit.MILLISECONDS);
	}

	@Override
	public Future<StampedValue> getValue() {
		return scheduler.schedule(() -> {
			return capteur.getValue();
		}, ThreadLocalRandom.current().nextInt(0, 100), TimeUnit.MILLISECONDS);
	}

	@Override
	public void tick() {
	}
}
