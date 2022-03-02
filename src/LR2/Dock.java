package LR2;

import java.util.*;

public class Dock {
	private int id;
	private Deque<Ship> ships;
	private Harbor harbor;
	
	
	
	public Dock(int id,Harbor harbor) {
		this.setId(id);
		this.harbor=harbor;
	}
	
	public String stats() {
		
		return null;
		
	}
	
	public void acceptShip(Ship ship) {
		ships.addLast(ship);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getLoading() {
		return ships.size();
	}
}
