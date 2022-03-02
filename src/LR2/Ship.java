package LR2;

import java.util.*;

public class Ship {
	private String name;
	private Vector<Cargo> cargo;
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
