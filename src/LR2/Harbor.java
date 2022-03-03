package LR2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Vector;


/**
 * Класс гавани
 * 
 * @author      Киселев Николай <korn9509@gmail.com>
 * @version     1.0                 
 * @since       1.0          
 */
public class Harbor {
	/**
	 * Имя гавани
	 */
	private String name;
	/**
	 * Список доков
	 */
	private Vector<Dock> docks=new Vector<Dock>();
	/**
	 * Склад гавани
	 */
	private Warehouse warehouse;
	/**
	 * Файловый и консольный логгер
	 */
	private Logger logger;
	/**
	 * Список потоков для работы отдельных доков
	 */
	private LinkedList<Thread> threads=new LinkedList<Thread>() ;
	
	
	/**
	 * Конструктор гавани
	 * 
	 * <p>Создает заданное количество доков и запускает процессы их деятельности в отдельных потоках</p>
	 * @param name Имя гавани
	 * @param countDocks Количество доков в гавани
	 * @param logger Файловый и консольный логгер
	 */
	public Harbor(String name,int countDocks, Logger logger) {
		this.setName(name);
		for(int i=0;i<countDocks;i++) {
			Dock newDock=new Dock(i, this);
			docks.add(newDock);
			Runnable runDock=()->{try {
				newDock.operate();
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}};
			Thread newThread=new Thread(runDock);
			newThread.start();
			threads.add(newThread);
		}
		this.warehouse=new Warehouse();
		this.setLogger(logger);
	}
	
	/**
	 * Метод вывода полной статистики о гавани в файл
	 */
	private void stats() throws IOException {
		logger.fileLog("Текущее состояния гавани "+name);
		for (Dock dock:docks) {
			logger.fileLog(dock.stats());
		}
		logger.fileLog("Текущее состояне склада "+warehouse.stats());
	}
	
	
	/**
	 * Метод запуска вывода полной статистики о гавани каждые пять секунд 
	 */
	public void Observe() throws Exception {
		while (true) {
			stats();
			Thread.sleep(5000);
		}
	}
	
	/**
	 * Метод принятия корабля в самый разгруженный из доков
	 * @param ship
	 */
	public void acceptShip(Ship ship) {
		int minLoading=docks.get(0).getLoading();
		int minDockId=0;
		for (Dock dock:docks) {
			int currentLoading=dock.getLoading();
			if (currentLoading<minLoading) {
				minLoading=currentLoading;
				minDockId=dock.getId();
			}
		}
		Dock freeDock=docks.get(minDockId);
		freeDock.acceptShip(ship);		
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

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
}
