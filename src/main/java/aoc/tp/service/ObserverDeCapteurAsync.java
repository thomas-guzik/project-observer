package aoc.tp.service;

import java.util.concurrent.Future;

import aoc.tp.capteur.Capteur;

public interface ObserverDeCapteurAsync {

	public Future update(Capteur s);
}
