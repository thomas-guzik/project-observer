package aoc.tp.proxy;

import aoc.tp.concreteclient.Afficheur;
import aoc.tp.observer.Observer;
import aoc.tp.servant.Capteur;
import aoc.tp.servant.ObserverdeCapteur;

public class Canal implements Capteur, ObserverdeCapteur {

	private Capteur capteur;
	private Afficheur afficheur;
	
	public void update(Capteur subject) {
		// TODO Auto-generated method stub
		
	}

	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public void attach(Observer o) {
		// TODO Auto-generated method stub
		
	}

	public void detach(Observer o) {
		// TODO Auto-generated method stub
		
	}

}
