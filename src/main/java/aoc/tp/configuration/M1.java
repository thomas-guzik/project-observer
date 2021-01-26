package aoc.tp.configuration;

import aoc.tp.afficheur.Afficheur;
import aoc.tp.capteur.Capteur;
import aoc.tp.capteur.CapteurImpl;

public class M1 implements Configuration {

	private static Capteur capteur = new CapteurImpl();
	private static Afficheur afficheur = new Afficheur();
	
}
