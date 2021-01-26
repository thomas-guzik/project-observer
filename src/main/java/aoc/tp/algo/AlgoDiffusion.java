package aoc.tp.algo;

import aoc.tp.afficheur.ObserverDeCapteur;

public interface AlgoDiffusion {
	public void configure();
	public void execute();
	public void valueRead();
}