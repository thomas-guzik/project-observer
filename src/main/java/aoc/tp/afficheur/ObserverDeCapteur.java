package aoc.tp.afficheur;

import java.util.List;

import aoc.tp.capteur.Capteur;
import aoc.tp.capteur.CapteurAsync;
import aoc.tp.observer.Observer;

public interface ObserverDeCapteur extends Observer<Capteur> {

	public void update(Capteur subject);

	public void update(CapteurAsync canal);

	public List<Integer> getTraces();
}
