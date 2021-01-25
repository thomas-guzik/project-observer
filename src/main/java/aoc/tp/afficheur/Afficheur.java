package aoc.tp.concreteclient;
import java.util.logging.Logger;

import aoc.tp.proxy.Canal;
import aoc.tp.capteur.Capteur;
import aoc.tp.servant.ObserverdeCapteur;

public class Afficheur implements ObserverdeCapteur {

	public void update(Capteur subject) {
		Logger.getGlobal().info(subject.getValue());
	}

}
