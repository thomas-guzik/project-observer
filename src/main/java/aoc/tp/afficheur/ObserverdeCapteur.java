package aoc.tp.servant;
import aoc.tp.observer.Observer;
import aoc.tp.capteur.Capteur;

public interface ObserverdeCapteur extends Observer<Capteur> {
	
	public void update(Capteur subject);
}
