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
	private AlgoDiffusion algo = new DiffusionSequentielle(this);
	private CapteurState state = CapteurState.WRITE;

	public CapteurImpl() {
	}

	public int getValue() {
		algo.valueRead();
		if(state == CapteurState.WRITE) {
			v_read = v_write;
		}
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

        // wait when in an atomic read
        Logger.getLogger("Error").info("begin wait");
        while(getState() == CapteurState.READ_ATOMIQUE) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Logger.getLogger("Error").info("end wait");

        if (getState() == CapteurState.READ_SEQUENTIAL || getState() == CapteurState.WRITE) {
            v_write++;
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
        if (getState() == CapteurState.WRITE && state == CapteurState.READ_SEQUENTIAL) {
            v_read = v_write;
        }
		this.state = state; 
	}
}
