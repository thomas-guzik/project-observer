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

	public DiffusionAtomique() {
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
		capteur.setState(CapteurState.READ_ATOMIQUE);
		nb_sended_update = capteur.getNbObservers();
		capteur.notifyObservers();
	}

	@Override
	public void valueRead() {
		if (nb_sended_update == 0) {
			try {				
				throw new Exception("Get an unexpected ValueRead");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		nb_sended_update--;
		if (nb_sended_update == 0) {
			capteur.setState(CapteurState.WRITE);
		}
	}
}
