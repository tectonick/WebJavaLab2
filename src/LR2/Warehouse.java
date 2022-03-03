package LR2;

import java.util.*;
import java.util.concurrent.Semaphore;


/**
 * ����� ������ � ������
 * 
 * @author      ������� ������� <korn9509@gmail.com>
 * @version     1.0                 
 * @since       1.0          
 */
public class Warehouse {
	/**
	 * �������� ������������� ������� � ������ ������
	 */
	private Semaphore semaphore = new Semaphore(1);
	
	/**
	 * ������� ������ ������
	 */
	private Deque<Cargo> cargo=new LinkedList<Cargo>();
	
	/**
	 * ����� ������ ���������� � ���������� ������ �� ������ � ������
	 * @return String
	 */
	public String stats() {
		int fullWeight=0;
		for (Cargo cargoUnit:cargo) {
			fullWeight+=cargoUnit.getWeight();
		}
		return "�� ������ "+cargo.size()+" ������ ����� ����� "+fullWeight+" ���������";
	}
	
	
	/**
	 * ����� �������� ����� �� �����
	 * @param cargoUnit
	 */
	public void loadCargo(Cargo cargoUnit) throws InterruptedException {		
	    if (semaphore.tryAcquire()) {
	        try {
	    		if (cargoUnit!=null) {
	    			cargo.addLast(cargoUnit);
	    		}
	        }
	        finally {
	            semaphore.release();
	        }
	    }
	}
	
	/**
	 * ����� �������� ����� �� ������
	 * @return Cargo
	 */
	public synchronized Cargo unloadCargo() throws InterruptedException {
		if (!cargo.isEmpty()) {
			Cargo cargoUnit=cargo.pollFirst();
			return cargoUnit;
		} else {
			return null;
		}
	}
	

}
