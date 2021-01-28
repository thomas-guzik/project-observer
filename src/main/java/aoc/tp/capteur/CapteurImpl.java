package aoc.tp.capteur;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import aoc.tp.algo.AlgoDiffusion;
import aoc.tp.algo.DiffusionAtomique;
import aoc.tp.algo.DiffusionIncoherence;
import aoc.tp.algo.DiffusionSequentielle;
import aoc.tp.observer.AbstractSubject;

public class CapteurImpl extends AbstractSubject implements Capteur {

	private int v_write = 0;
	private StampedValue v_read = new StampedValue(v_write);
	private AlgoDiffusion algo = new DiffusionIncoherence(this);
	private CapteurState state = CapteurState.WRITE;
	
	List<Integer> traces_read = new ArrayList<>();
	
	public CapteurImpl() {
	}

	public StampedValue getValue() {
		algo.valueRead();
		return v_read;
	}

    // 1 - tick(), state = WRITE
    // 2 - algo.execute(), notify() state = READ_ATOMIQ
    // 3 - tick(), state = READ_ATOMIQ
    // 4 - algo.execute(), block()
    // 5 - state = WRITE
    // 6 - v++
    // 7 - notify(), state = READ_ATOMIQ
    // 8 - state = WRITE
    // 9 - v++
    
	public void tick() {
		algo.execute();

        v_write++;
        if (getState() == CapteurState.WRITE) {
        	updateRead();
        }
	}

	public void setAlgorithm(AlgoDiffusion a) {
		algo = a;
		a.setCapteur(this);
	}

	@Override
	public CapteurState getState() {
		return state;
	}

	@Override
	public void setState(CapteurState state) {
        if (getState() == CapteurState.WRITE && state == CapteurState.READ_SEQUENTIAL) {
        	updateRead();
        }
		this.state = state; 
	}
	
	public void updateRead() {
		v_read = new StampedValue(v_write);
		traces_read.add(v_write);
		
	}

}


