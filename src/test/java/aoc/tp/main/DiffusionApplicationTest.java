package aoc.tp.main;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import aoc.tp.afficheur.ObserverDeCapteur;
import aoc.tp.algo.DiffusionAtomique;
import aoc.tp.algo.DiffusionIncoherence;
import aoc.tp.algo.DiffusionSequentielle;

class DiffusionApplicationTest {

	void lastValueIsNotGreaterThanTick(List<ObserverDeCapteur> afficheurs, int nb_tick) {
		for(ObserverDeCapteur afficheur : afficheurs) {
			int last = afficheur.getTraces().size() - 1;
			if(nb_tick < afficheur.getTraces().get(last)) {				
				Assertions.fail("Le nombre affiché est plus grand que le nombre de tick");
			}
		}
	}
	
	@Test
	void coherenceAtomiqueCroissantePar1() {
		int nb_tick = 50;
		DiffusionApplication app = new DiffusionApplication();
		app.initialize(new DiffusionAtomique(), 4);
		app.run(nb_tick);
		
		for(ObserverDeCapteur afficheur : app.getAfficheurs()) {
			int previous_v = 0;
			for(int v : afficheur.getTraces()) {
				Assertions.assertEquals(previous_v+1, v);
				previous_v++;
			}
		}
		lastValueIsNotGreaterThanTick(app.getAfficheurs(), nb_tick);
	}
	
	@Test
	void coherenceSequentielle() {
		int nb_tick = 50;
		DiffusionApplication app = new DiffusionApplication();
		app.initialize(new DiffusionSequentielle(), 4);
		app.run(nb_tick);
		
		List<ObserverDeCapteur> afficheurs = app.getAfficheurs();
		
		int min_size = Integer.MAX_VALUE;
		
		for(ObserverDeCapteur afficheur : afficheurs) {
			if(min_size > afficheur.getTraces().size()) {
				min_size = afficheur.getTraces().size();
			}
		}
		
		for(int i = 0; i < min_size; i++) {
			int v = afficheurs.get(0).getTraces().get(i);
			for(ObserverDeCapteur afficheur : afficheurs) {
				Assertions.assertEquals(afficheur.getTraces().get(i), v);
			}
		}
		
		lastValueIsNotGreaterThanTick(app.getAfficheurs(), nb_tick);
	}
	
	@Test
	void incoherence() {
		int nb_tick = 50;
		DiffusionApplication app = new DiffusionApplication();
		app.initialize(new DiffusionIncoherence(), 4);
		app.run(nb_tick);
		
		for(ObserverDeCapteur afficheur : app.getAfficheurs()) {
			int previous_v = 0;
			for(int v : afficheur.getTraces()) {
				if(v < previous_v) {
					Assertions.fail("Les valeurs ne sont pas croissantes");
				}
				previous_v = v;
			}
		}
		
		lastValueIsNotGreaterThanTick(app.getAfficheurs(), nb_tick);

	}

}
