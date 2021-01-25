package aoc.tp.configuration;

import aoc.tp.concreteclient.Afficheur;
import aoc.tp.proxy.Canal;
import aoc.tp.algo.DiffusionAtomique;
import aoc.tp.capteur.Capteur;
import aoc.tp.capteur.CapteurImpl;

public class BaseConfiguration implements Configuration {

	private static Capteur capteur = new CapteurImpl();
	private static Canal[] canals = new Canal[4];
	private static Afficheur[] afficheurs =  new Afficheur[4];
	
	static {
		for(int i = 0; i < afficheurs.length; i++) {
			afficheurs[i] = new Afficheur();
		}
		for(int i = 0; i < canals.length; i++) {
			canals[i] = new Canal(capteur, afficheurs[i]);
			capteur.attach(canals[i]);
		}
	}

	public BaseConfiguration() {
	}

	public static Capteur getCapteur() {
		return capteur;
	}


	public static Canal[] getCanals() {
		return canals;
	}

	public static Afficheur[] getAfficheurs() {
		return afficheurs;
	}

}
