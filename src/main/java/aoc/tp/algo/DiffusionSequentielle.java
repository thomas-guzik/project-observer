package aoc.tp.algo;

import java.util.logging.Logger;

import aoc.tp.capteur.Capteur;

public class DiffusionSequentielle implements AlgoDiffusion {

    Capteur capteur;
    int nb_sent_updates = 0;

    public DiffusionSequentielle(Capteur c) {
        capteur = c;
    }

	@Override
	public void configure() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
        capteur.block();
        nb_sent_updates = capteur.getNbObservers();
        capteur.notifyObservers();
	}

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
