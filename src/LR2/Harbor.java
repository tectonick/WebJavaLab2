package LR2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Vector;


/**
 * ����� ������
 * 
 * @author      ������� ������� <korn9509@gmail.com>
 * @version     1.0                 
 * @since       1.0          
 */
public class Harbor {
	/**
	 * ��� ������
	 */
	private String name;
	/**
	 * ������ �����
	 */
	private Vector<Dock> docks=new Vector<Dock>();
	/**
	 * ����� ������
	 */
	private Warehouse warehouse;
	/**
	 * �������� � ���������� ������
	 */
	private Logger logger;
	/**
	 * ������ ������� ��� ������ ��������� �����
	 */
	private LinkedList<Thread> threads=new LinkedList<Thread>() ;
	
	
	/**
	 * ����������� ������
	 * 
	 * <p>������� �������� ���������� ����� � ��������� �������� �� ������������ � ��������� �������</p>
	 * @param name ��� ������
	 * @param countDocks ���������� ����� � ������
	 * @param logger �������� � ���������� ������
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
	 * ����� ������ ������ ���������� � ������ � ����
	 */
	private void stats() throws IOException {
		logger.fileLog("������� ��������� ������ "+name);
		for (Dock dock:docks) {
			logger.fileLog(dock.stats());
		}
		logger.fileLog("������� �������� ������ "+warehouse.stats());
	}
	
	
	/**
	 * ����� ������� ������ ������ ���������� � ������ ������ ���� ������ 
	 */
	public void Observe() throws Exception {
		while (true) {
			stats();
			Thread.sleep(5000);
		}
	}
	
	/**
	 * ����� �������� ������� � ����� ������������ �� �����
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
