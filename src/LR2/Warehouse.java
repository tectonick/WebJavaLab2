package LR2;

import java.util.*;

public class Warehouse {
	private Deque<Cargo> cargo=new LinkedList<Cargo>();
	
	public String stats() {
		int fullWeight=0;
		for (Cargo cargoUnit:cargo) {
			fullWeight+=cargoUnit.getWeight();
		}
		return "На складе "+cargo.size()+" грузов общим весом "+fullWeight+" килограмм";
	}
	
	public synchronized void loadCargo(Cargo cargoUnit) throws InterruptedException {
		if (cargoUnit!=null) {
			cargo.addLast(cargoUnit);
		}
	}
	public synchronized Cargo unloadCargo() throws InterruptedException {
		if (!cargo.isEmpty()) {
			Cargo cargoUnit=cargo.pollFirst();
			return cargoUnit;
		} else {
			return null;
		}
	}
	

}
