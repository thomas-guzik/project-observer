package aoc.tp.capteur;

public class StampedValue {
	
	int v;
	long timestamp;
	
	public StampedValue(int v) {
		this.v = v;
		this.timestamp = System.currentTimeMillis();
	}
	
	public int getValue() {
		return v;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
}
