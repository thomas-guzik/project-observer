package aoc.tp.afficheur;

import java.util.logging.Logger;

import aoc.tp.capteur.Capteur;
import aoc.tp.observer.Subject;

public class Afficheur implements ObserverDeCapteur {

	public void update(Capteur subject) {
		Logger.getGlobal().info(String.valueOf(subject.getValue()));
	}

	@Override
	public void update(Subject subject) {
		Logger.getGlobal().info("Erreur");
	}


}
