package aoc.tp.algo;

import java.util.logging.Logger;

import aoc.tp.capteur.Capteur;
import aoc.tp.capteur.CapteurState;

public class DiffusionAtomique implements AlgoDiffusion {

	Capteur capteur;
	int nb_sended_update = 0;

	public DiffusionAtomique(Capteur c) {
		capteur = c;
	}
	
	@Override
	public void configure() {}

	@Override
	public void execute() {
		CapteurState state = capteur.getState();
		if(state == CapteurState.READ_ATOMIQUE) {
			while(state == CapteurState.READ_ATOMIQUE) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		capteur.setState(CapteurState.READ_ATOMIQUE);
		nb_sended_update = capteur.getNbObservers();
		capteur.notifyObservers();
	}

	@Override
	public void valueRead() {
		if(nb_sended_update == 0) {
			Logger.getLogger("Error").info("Error this case should be impossible");
		}
		nb_sended_update--;
		if(nb_sended_update == 0) {
			capteur.setState(CapteurState.WRITE);
		}
	}

}
