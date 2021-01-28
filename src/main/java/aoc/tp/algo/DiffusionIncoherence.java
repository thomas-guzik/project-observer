package aoc.tp.algo;

import aoc.tp.capteur.Capteur;

public class DiffusionIncoherence implements AlgoDiffusion {

	private Capteur capteur;

	public DiffusionIncoherence(Capteur capteur) {
		this.capteur = capteur;
	}

	public DiffusionIncoherence() {
	}

	@Override
	public void setCapteur(Capteur c) {
		this.capteur = c;
	}

	@Override
	public void configure() {
	}

	@Override
	public void execute() {
		capteur.notifyObservers();
	}

	@Override
	public void valueRead() {
	}

}
