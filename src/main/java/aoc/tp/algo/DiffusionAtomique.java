package aoc.tp.algo;

import java.util.logging.Logger;

import aoc.tp.capteur.Capteur;
import aoc.tp.capteur.CapteurState;

public class DiffusionAtomique implements AlgoDiffusion {

	Capteur capteur;
	int nb_sended_update = 0;
	int await_ticks = 0;

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
		Logger.getLogger("Error").info("valueRead(): nb_sended_update = " + nb_sended_update);
		if (nb_sended_update == 0) {
			Logger.getLogger("Error").info("Error this case should be impossible");
		}
		nb_sended_update--;
		if (nb_sended_update == 0) {
			capteur.setState(CapteurState.WRITE);
		}
	}
}
