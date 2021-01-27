package aoc.tp.main;

import aoc.tp.afficheur.Afficheur;
import aoc.tp.afficheur.ObserverDeCapteur;
import aoc.tp.canal.Canal;
import aoc.tp.capteur.Capteur;
import aoc.tp.capteur.CapteurImpl;
import aoc.tp.observer.Observer;

public class DiffusionApplication {

	public void run(Capteur capteur, int ticks) {
		if(ticks >= 0) {
			int n_tick = 0;
			while(n_tick < ticks) {
				capteur.tick();
				n_tick++;
			}
		} else {
			while(true) {
				capteur.tick();
			}
		}
	}
	
	public Capteur initialize() {
		Capteur capteur = new CapteurImpl();
		
		
		
    	ObserverDeCapteur afficheur1 = new Afficheur();
    	ObserverDeCapteur afficheur2 = new Afficheur();
    	ObserverDeCapteur afficheur3 = new Afficheur();
    	ObserverDeCapteur afficheur4 = new Afficheur();
    	
    	Canal c1 = new Canal(capteur, afficheur1);
    	Canal c2 = new Canal(capteur, afficheur2);
    	Canal c3 = new Canal(capteur, afficheur3);
    	Canal c4 = new Canal(capteur, afficheur4);
    	
    	capteur.attach((Observer) c1);
    	capteur.attach((Observer) c2);
    	capteur.attach((Observer) c3);
    	capteur.attach((Observer) c4);

    	return capteur;
	}

    public static void main(String[] args) {
    	DiffusionApplication app = new DiffusionApplication();
    	app.run(app.initialize(), 5);
    }
}
