package aoc.tp.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;

import aoc.tp.afficheur.Afficheur;
import aoc.tp.afficheur.ObserverDeCapteur;
import aoc.tp.algo.AlgoDiffusion;
import aoc.tp.algo.DiffusionSequentielle;
import aoc.tp.canal.Canal;
import aoc.tp.capteur.Capteur;
import aoc.tp.capteur.CapteurImpl;
import aoc.tp.observer.Observer;

public class DiffusionApplication {

	Capteur capteur = new CapteurImpl();
	private List<Canal> canals = new ArrayList<Canal>();
	private List<ObserverDeCapteur> afficheurs = new ArrayList<ObserverDeCapteur>();
	ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(50);

	public Capteur getCapteur() {
		return capteur;
	}

	public List<ObserverDeCapteur> getAfficheurs() {
		return afficheurs;
	}

	public void initialize(AlgoDiffusion algo, int nb_afficheur) {
		capteur.setAlgorithm(algo);

		scheduler = Executors.newScheduledThreadPool(nb_afficheur * 10);

		for (int i = 0; i < nb_afficheur; i++) {
			afficheurs.add(new Afficheur());
		}

		for (int i = 0; i < nb_afficheur; i++) {
			Canal c = new Canal(capteur, afficheurs.get(i), scheduler);
			canals.add(c);
			capteur.attach((Observer) c);
		}
	}

	public void run(int ticks) {
		if (ticks >= 0) {
			for (int i = 0; i < ticks; i++) {
				sendTick();
			}
		} else {
			while (true) {
				sendTick();
			}
		}
	}

	private void sendTick() {
		scheduler.execute(() -> {
			capteur.tick();
		});
		Logger.getGlobal().info("************************************* TICK");
		try {
			Thread.sleep(75);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DiffusionApplication app = new DiffusionApplication();
		app.initialize(new DiffusionSequentielle(), 4);
		app.run(50);
	}

}
