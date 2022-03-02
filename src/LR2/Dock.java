package LR2;

import java.io.IOException;
import java.util.*;

public class Dock {
	private int id;
	private Deque<Ship> ships=new LinkedList<Ship>();
	private Harbor harbor;
	
	
	
	public Dock(int id,Harbor harbor) {
		this.setId(id);
		this.harbor=harbor;
	}
	
	public String stats() {
		if (!ships.isEmpty()){
			int shipLoading=ships.peekFirst().shipLoading();
			return "В доке №"+id+" "+ships.size()+" кораблей. На обслуживаемом корбале сейчас "+shipLoading+" грузов";
		}
		return "В доке №"+id +" нет кораблей";
	}
	
	
	public void operate() throws IOException, InterruptedException {
		Thread.sleep(1000);
		harbor.getLogger().log("Док №"+id+ " начал свою работу");
		while(true) {
			if (ships.isEmpty()) {
				Thread.sleep(1000);
				continue;
			}
			Ship currentShip=ships.peekFirst();
			harbor.getLogger().log("В доке №"+id+ " корабль "+currentShip.getName()+" принят к обслуживанию.");
			String loadWord=(currentShip.getRequest()<0)?("выгружено"):("загружено");
			int absRequest=Math.abs(currentShip.getRequest());
			if (currentShip.getRequest()<0) {
				for (int i=0;i<absRequest;i++) {
					Cargo cargoUnit=currentShip.unloadCargo();
					if (cargoUnit==null) break;
					harbor.getWarehouse().loadCargo(cargoUnit);
				}
			} else {
				for (int i=0;i<absRequest;i++) {
					Cargo cargoUnit=harbor.getWarehouse().unloadCargo();
					if (cargoUnit==null) break;
					currentShip.loadCargo(cargoUnit);
				}
			}
			harbor.getLogger().log("В доке №"+id+ " корабль "+currentShip.getName()+" обслужен, "+loadWord+" "+absRequest+" грузов.");
			ships.pollFirst();
		}
	}
	
	public  void acceptShip(Ship ship) {
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
