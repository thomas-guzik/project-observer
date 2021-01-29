package aoc.tp.afficheur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import aoc.tp.capteur.Capteur;
import aoc.tp.capteur.CapteurAsync;
import aoc.tp.capteur.StampedValue;

public class Afficheur implements ObserverDeCapteur {

	List<Integer> traces = new ArrayList<>();
	long last_timestamp = 0;

	@Override
	public List<Integer> getTraces() {
		return traces;
	}

	@Override
	public void update(Capteur subject) {
		Integer v = subject.getValue().getValue();
		Logger.getGlobal().info(String.valueOf(v));
		traces.add(v);
	}

	@Override
	public void update(CapteurAsync canal) {
		Future<StampedValue> f = canal.getValue();
		StampedValue v = null;
		try {
			v = f.get();
			long timestamp = v.getTimestamp();
			if (timestamp > last_timestamp) {
				last_timestamp = timestamp;

				int value = v.getValue();
				Logger.getGlobal().info("***************************************************** "
						+ String.valueOf(this.hashCode()) + " " + String.valueOf(value));

				traces.add(value);
			} else {
				Logger.getGlobal().info("INCOHERENCE");
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
