package aoc.tp.algo;

import java.util.logging.Logger;

import aoc.tp.afficheur.ObserverDeCapteur;
import aoc.tp.capteur.Capteur;

public class DiffusionAtomique implements AlgoDiffusion {

	Capteur capteur;
	int nb_sended_update = 0;
	

	public DiffusionAtomique(Capteur c) {
		capteur = c;
	}
	
	@Override
	public void configure() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		capteur.lock();
		nb_sended_update = capteur.getNbObservers();
		capteur.notifyObservers();
	}

	@Override
	public void valueRead(ObserverDeCapteur o) {
		if(nb_sended_update == 0) {
			Logger.getLogger("Error").info("Error this case should be impossible");
		}
		nb_sended_update--;
		if(nb_sended_update == 0) {
			capteur.unlock();
		}
	}

}
