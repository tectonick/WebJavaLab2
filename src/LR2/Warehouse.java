package LR2;

import java.util.Vector;

public class Warehouse {
	private Vector<Cargo> cargo;
	
	public String stats() {
		int fullWeight=0;
		for (Cargo cargoUnit:cargo) {
			fullWeight+=cargoUnit.getWeight();
		}
		return "На складе "+cargo.size()+" грузов общим весом "+fullWeight+" килограмм";
		
	}

}
