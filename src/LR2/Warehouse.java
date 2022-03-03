package LR2;

import java.util.*;
import java.util.concurrent.Semaphore;


/**
 * Класс склада в гавани
 * 
 * @author      Киселев Николай <korn9509@gmail.com>
 * @version     1.0                 
 * @since       1.0          
 */
public class Warehouse {
	/**
	 * Средство синхронизации доступа к списку грузов
	 */
	private Semaphore semaphore = new Semaphore(1);
	
	/**
	 * Очередь грузов склада
	 */
	private Deque<Cargo> cargo=new LinkedList<Cargo>();
	
	/**
	 * Метод вывода статистики о количестве грузов на складе в строку
	 * @return String
	 */
	public String stats() {
		int fullWeight=0;
		for (Cargo cargoUnit:cargo) {
			fullWeight+=cargoUnit.getWeight();
		}
		return "На складе "+cargo.size()+" грузов общим весом "+fullWeight+" килограмм";
	}
	
	
	/**
	 * Метод погрузки груза на склад
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
	 * Метод выгрузки груза со склада
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
