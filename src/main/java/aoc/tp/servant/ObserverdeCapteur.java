package aoc.tp.servant;
import aoc.tp.observer.Observer;

public interface ObserverdeCapteur extends Observer<Capteur> {
	
	public void update(Capteur subject);
}
