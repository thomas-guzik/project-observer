package aoc.tp.afficheur;

import aoc.tp.capteur.Capteur;
import aoc.tp.observer.Observer;

public interface ObserverDeCapteur extends Observer<Capteur> {

	public void update(Capteur subject);
}
