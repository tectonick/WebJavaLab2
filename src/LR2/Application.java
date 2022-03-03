package LR2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 * �������� ����� ����������
 * 
 * @author      ������� ������� <korn9509@gmail.com>
 * @version     1.0                 
 * @since       1.0          
 */
public class Application {

	static final String LOGPATH = "log.txt";
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	
	/**
	 * �������� ����� ����������, ��������� ������� ������ � ��������.
	 *          
	 */
	public static void main(String[] args) {
		try {
			Logger logger=new Logger(LOGPATH);
			Harbor harbor=new Harbor("My harbor", 2, logger);
			Runnable harborRun =
			        () -> { try {
						harbor.Observe();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} };
			Thread harborThread=new Thread(harborRun);
			harborThread.start();
			Thread.sleep(1000);
			System.out.println("��������� �������.");
			harbor.acceptShip(new Ship("Ship 1", 3, -3));
			Thread.sleep(1000);
			harbor.acceptShip(new Ship("Ship 2", 0, 2));
			harbor.acceptShip(new Ship("Ship 3", 2, -2));
			System.out.println("������� ���������.\n");
			System.out.println("������� enter ��� ������.");
			reader.read();
			
			harborThread.stop();
			System.out.println("������ ���������. ��������� ������� ���������.");
			System.exit(0);
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
