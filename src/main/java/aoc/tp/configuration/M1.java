package aoc.tp.configuration;

import aoc.tp.afficheur.Afficheur;
import aoc.tp.afficheur.ObserverDeCapteur;
import aoc.tp.capteur.Capteur;
import aoc.tp.capteur.CapteurImpl;
import aoc.tp.observer.Observer;

public class M1 implements Configuration {

	private static Capteur capteur = new CapteurImpl();
	private static Afficheur afficheur = new Afficheur();
	
	static {
    	capteur.attach((Observer) afficheur);
	}
	
	public static Capteur getCapteur() {
		return capteur;
	}

	public static Afficheur getAfficheur() {
		return afficheur;
	}
}
