package aoc.tp.algo;

import java.util.logging.Logger;

import aoc.tp.capteur.Capteur;
import aoc.tp.capteur.CapteurState;

public class DiffusionSequentielle implements AlgoDiffusion {

    Capteur capteur;
    int nb_sent_updates = 0;
   // Set<ObserverDeCapteurAsync> 

    public DiffusionSequentielle(Capteur c) {
        capteur = c;
    }

	@Override
	public void configure() {
		// TODO Auto-generated method stub
		
	}

	// 1 - Il dit à capteur de ok pour v_write++ mais pas v_read reste la même
	// 1 - A chaque fois ? oui

	
	@Override
	public void execute() {
		CapteurState state = capteur.getState();
        if(state == CapteurState.READ_SEQUENTIAL) {
        	capteur.block();
            nb_sent_updates = capteur.getNbObservers();
            capteur.notifyObservers();
        }
	}

	// 1 - Il faut pas que ce soit le même afficheur
	@Override
	public void valueRead() {
		if(nb_sent_updates == 0) {
			Logger.getLogger("Error").info("Error this case should be impossible");
		}
		nb_sent_updates--;
		if(nb_sent_updates == 0) {
			capteur.unblock();
		}
		
	}

}
