package aoc.tp.test;

import static org.junit.jupiter.api.Assertions.*;

import aoc.tp.algo.DiffusionAtomique;
import aoc.tp.main.DiffusionApplication;


class Test {

	@org.junit.jupiter.api.Test
	void conherenceAtomique() {
		DiffusionApplication app = new DiffusionApplication();
		app.initialize(new DiffusionAtomique(),4);
		app.run(100);
	}

}
