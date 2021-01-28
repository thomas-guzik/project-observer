package aoc.tp.main;

import java.util.ArrayList;
import java.util.List;

import aoc.tp.afficheur.Afficheur;
import aoc.tp.afficheur.ObserverDeCapteur;
import aoc.tp.algo.AlgoDiffusion;
import aoc.tp.algo.DiffusionAtomique;
import aoc.tp.canal.Canal;
import aoc.tp.capteur.Capteur;
import aoc.tp.capteur.CapteurAsync;
import aoc.tp.capteur.CapteurImpl;
import aoc.tp.observer.Observer;
import aoc.tp.observer.Subject;

public class DiffusionApplication {

	Capteur capteur = new CapteurImpl();
	private List<Canal> canals = new ArrayList<Canal>();
	private List<ObserverDeCapteur> afficheurs =  new ArrayList<ObserverDeCapteur>();
	
	public Capteur getCapteur() {
		return capteur;
	}

	public void run(int ticks) {
		if(ticks >= 0) {
			int n_tick = 0;
			while(n_tick < ticks) {
				capteur.tick();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				n_tick++;
			}
		} else {
			while(true) {
				capteur.tick();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void initialize(AlgoDiffusion algo, int nb_afficheur) {
		capteur.setAlgorithm(algo);
		
		for(int i = 0; i < nb_afficheur; i++) {
			afficheurs.add(new Afficheur());
		}
		
		for(int i = 0; i < nb_afficheur; i++) {
			Canal c = new Canal(capteur, afficheurs.get(i));
			canals.add(c);
			capteur.attach((Observer) c);
		}
	}

    public static void main(String[] args) {
    	DiffusionApplication app = new DiffusionApplication();
    	app.initialize(new DiffusionAtomique(),4);
    	app.run(100);
        System.out.println("main(): end");
    }
    
}
