package LR2;

import java.util.Vector;

public class Harbor {
	private String name;
	private Vector<Dock> docks;
	private Warehouse warehouse;
	
	public Harbor(String name,int countDocks) {
		this.setName(name);
		for(int i=0;i<countDocks;i++) {
			Dock newDock=new Dock(i, this);
			docks.add(newDock);
		}
		this.warehouse=new Warehouse();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
}
