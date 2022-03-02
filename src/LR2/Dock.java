package LR2;

import java.util.Vector;

public class Dock {
	private int id;
	private Vector<Ship> ships;
	private Harbor harbor;

	public Dock(int id,Harbor harbor) {
		this.setId(id);
		this.harbor=harbor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
