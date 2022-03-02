package LR2;

import java.util.*;

public class Ship {
	private String name;
	private Deque<Cargo> cargo=new LinkedList<Cargo>();
	private int request;
	
	public Ship(String name, int cargoCount, int request) {
		this.setName(name);
		Random rand=new Random();
		for(int i=0;i<cargoCount;i++) {
			Cargo newCargo=new Cargo(rand.nextInt(),rand.nextInt(3, 8));
			cargo.add(newCargo);
		}
		this.setRequest(request);
	}
	
	public void loadCargo(Cargo cargoUnit) throws InterruptedException {
		if (cargoUnit!=null) {
			Thread.sleep(cargoUnit.getWeight()*1000);
			cargo.addLast(cargoUnit);
		}
	}
	public Cargo unloadCargo() throws InterruptedException {
		if (!cargo.isEmpty()) {
			Cargo cargoUnit=cargo.pollFirst();
			Thread.sleep(cargoUnit.getWeight()*1000);
			return cargoUnit;
		} else {
			return null;
		}
	}
	
	public int shipLoading() {
		return cargo.size();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRequest() {
		return request;
	}

	public void setRequest(int request) {
		this.request = request;
	}	
}
