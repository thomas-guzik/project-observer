package aoc.tp.capteur;

import java.util.logging.Logger;

import aoc.tp.algo.AlgoDiffusion;
import aoc.tp.algo.DiffusionAtomique;
import aoc.tp.algo.DiffusionSequentielle;
import aoc.tp.observer.AbstractSubject;

public class CapteurImpl extends AbstractSubject implements Capteur {

	private int v_write = 0;
	private int v_read = v_write;
	private boolean locked = false;
    private boolean blocked = false;
	private AlgoDiffusion algo = new DiffusionAtomique(this);
	private CapteurState state = CapteurState.WRITE;

	public CapteurImpl() {
	}

	public int getValue() {
		algo.valueRead();
		return v_read;
	}

	public void lock() {
		locked = true;
	}

	public void unlock() {
		locked = false;
	}

    public void block() {
        Logger.getLogger("Error").info("blocked");
        blocked = true;
    }

    public void unblock() {
        Logger.getLogger("Error").info("unblocked");
        blocked = false;
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
		
		if(state == CapteurState.WRITE) {
			v_write++;
			v_read = v_write;
		}
		else if(state == CapteurState.READ_ATOMIQUE) {
			
		}
	}

	public void setAlgorithm(AlgoDiffusion a) {
		algo = a;
	}

	@Override
	public CapteurState getState() {
		return state;
	}

	@Override
	public void setState(CapteurState state) {
		this.state = state; 
	}
}
