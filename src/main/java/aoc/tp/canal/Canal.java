package aoc.tp.canal;

import aoc.tp.observer.Observer;
import aoc.tp.afficheur.ObserverDeCapteur;
import aoc.tp.capteur.Capteur;
import aoc.tp.capteur.CapteurAsync;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Canal 
// implements CapteurAsync, ObserverdeCapteur {
{

	private Capteur capteur;
	private ObserverDeCapteur afficheur;
	private ExecutorService scheduler;
	
	public Canal(Capteur capteur, ObserverDeCapteur afficheur) {
		this.capteur = capteur;
		this.afficheur = afficheur;
		this.scheduler = Executors.newCachedThreadPool();
	}
//	
//	public void update(Capteur subject) {
//		scheduler.submit(() -> { afficheur.update(subject); });
//	}
//
//	public Future<Integer> getValue() {
//		return scheduler.submit(() -> { return capteur.getValue(); });
//	}
//
//	public void tick() {
//		scheduler.submit(() -> { capteur.tick(); });
//	}
//
//	public void attach(Observer o) {
//		capteur.attach(o);
//	}
//
//	public void detach(Observer o) {
//		capteur.detach(o);
//	}

}
