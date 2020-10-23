package aoc.tp.configuration;

import aoc.tp.concreteclient.Afficheur;
import aoc.tp.proxy.Canal;
import aoc.tp.servant.Capteur;
import aoc.tp.servant.CapteurImpl;

public class BaseConfiguration {

	private Capteur capteur;
	private Canal[] canals;
	private Afficheur[] afficheurs;
	
	public BaseConfiguration() {
		capteur = new CapteurImpl();
		
		canals = new Canal[4];
		for(int i = 0; i < canals.length; i++) {
			canals[i] = new Canal();
			canals[i].update(capteur);
		}
		
		
		afficheurs = new Afficheur[4];
		for(int i = 0; i < afficheurs.length; i++) {
			afficheurs[i] = new Afficheur();
		}
	}
}
