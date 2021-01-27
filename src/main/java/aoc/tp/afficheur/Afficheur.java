package aoc.tp.afficheur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import aoc.tp.capteur.Capteur;
import aoc.tp.capteur.CapteurAsync;

public class Afficheur implements ObserverDeCapteur {

	List<Integer> traces = new ArrayList<>();
	
	public void update(Capteur subject) {
		Integer v = subject.getValue();
		Logger.getGlobal().info(String.valueOf(v));
		traces.add(v);
	}

	public void update(CapteurAsync canal) {
		Future<Integer> f = canal.getValue();
		Integer v = -1;
		try {
			v = f.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		Logger.getGlobal().info(String.valueOf(v));
		traces.add(v);
	}
}
