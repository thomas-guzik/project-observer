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
			capteur.setState(CapteurState.READ_SEQUENTIAL);
			nb_sent_updates = capteur.getNbObservers();
			capteur.notifyObservers();
	}

	@Override
	public void valueRead() {
		if (nb_sent_updates == 0) {
			try {				
				throw new Exception("Get an unexpected ValueRead");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		nb_sent_updates--;
		if (nb_sent_updates == 0) {
			capteur.setState(CapteurState.WRITE);
		}
	}
}
