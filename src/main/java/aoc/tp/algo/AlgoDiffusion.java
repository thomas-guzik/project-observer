package aoc.tp.algo;

import aoc.tp.capteur.Capteur;

public interface AlgoDiffusion {
	public void configure();

	public void execute();

	public void valueRead();

	public void setCapteur(Capteur c);
}