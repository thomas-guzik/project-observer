package aoc.tp.algo;

import java.util.logging.Logger;

import aoc.tp.capteur.Capteur;
import aoc.tp.capteur.CapteurState;

public class DiffusionSequentielle implements AlgoDiffusion {

	Capteur capteur;
	int nb_sent_updates = 0;

	public DiffusionSequentielle(Capteur c) {
		capteur = c;
	}

	public DiffusionSequentielle() {
	}

	@Override
	public void setCapteur(Capteur c) {
		this.capteur = c;
	}

	@Override
	public void configure() {
	}

	@Override
	public void execute() {
		Logger.getLogger("Error").info("execute(): state is " + capteur.getState());
		// only notify observers if we are not already in READ_SEQUENTIAL mode
		if (capteur.getState() == CapteurState.WRITE) {
			capteur.setState(CapteurState.READ_SEQUENTIAL);
			nb_sent_updates = capteur.getNbObservers();
			capteur.notifyObservers();
		}
	}

	@Override
	public void valueRead() {
		Logger.getLogger("Error").info("valueRead(): nb_sent_updates = " + nb_sent_updates);
		if (nb_sent_updates == 0) {
			Logger.getLogger("Error").info("Error this case should be impossible");
		}
		nb_sent_updates--;
		if (nb_sent_updates == 0) {
			capteur.setState(CapteurState.WRITE);
		}
	}
}
