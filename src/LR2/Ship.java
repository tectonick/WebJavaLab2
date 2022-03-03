package LR2;

import java.util.*;


/**
 * Класс корабля
 * 
 * @author      Киселев Николай <korn9509@gmail.com>
 * @version     1.0                 
 * @since       1.0          
 */
public class Ship {
	/**
	 * Имя корабля
	 */
	private String name;
	/**
	 * Очередь грузов корабля
	 */
	private Deque<Cargo> cargo=new LinkedList<Cargo>();
	/**
	 * Требования корабля доку.
	 * 
	 * <p>Отрицательное значение обозначает, что корабль хочет выгрузить столько грузов, положительное - загрузить</p>
	 */
	private int request;
	
	
	/**
	 * Конструктор корабля
	 * 
	 * <p>В данном случае для модели грузы создаются в заданном количестве со случайными весами</p>
	 * @param name Имя корабля
	 * @param cargoCount Количество грузов на корабле
	 * @param request Требования корабля к доку
	 */
	public Ship(String name, int cargoCount, int request) {
		this.setName(name);
		Random rand=new Random();
		for(int i=0;i<cargoCount;i++) {
			Cargo newCargo=new Cargo(rand.nextInt(),rand.nextInt(3, 8));
			cargo.add(newCargo);
		}
		this.setRequest(request);
	}
	
	/**
	 * Метод погрузки груза на корабль с учетом веса. Чем больше вес - тем дольше погрузка
	 * @param cargoUnit
	 */
	public void loadCargo(Cargo cargoUnit) throws InterruptedException {
		if (cargoUnit!=null) {
			Thread.sleep(cargoUnit.getWeight()*1000);
			cargo.addLast(cargoUnit);
		}
	}
	
	/**
	 * Метод выгрузки груза с корабля с учетом веса. Чем больше вес - тем дольше выгрузка
	 * @return Cargo
	 */
	public Cargo unloadCargo() throws InterruptedException {
		if (!cargo.isEmpty()) {
			Cargo cargoUnit=cargo.pollFirst();
			Thread.sleep(cargoUnit.getWeight()*1000);
			return cargoUnit;
		} else {
			return null;
		}
	}
	
	/**
	 * Метод вывода количества грузов на корабле
	 * @return int
	 */
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
