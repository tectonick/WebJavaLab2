package LR2;

import java.io.*;
import java.util.Date;


/**
 * �������� � ���������� ������
 * 
 * @author      ������� ������� <korn9509@gmail.com>
 * @version     1.0                 
 * @since       1.0          
 */
public class Logger {
	/**
	 * ���� � ����� ����
	 */
	private String filepath;
	/**
	 * ����� ������ ��� ����� ����
	 */
    private FileWriter out = null;
    
    
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * ����� ������ ��������� �� �������
	 * @param message
	 */
	public synchronized void consoleLog(String message) {
		System.out.println((new Date()).toString()+ ":"+message);
	}
	
	/**
	 * ����� ������ ��������� � ����
	 * @param message
	 */
	public synchronized void fileLog(String message) throws IOException {
	         String log=new Date().toString()+":"+message;
	         out.write(log+"\n");
	         out.flush();
	}
	
	/**
	 * ����� ������ ��������� �� ������� � � ����
	 * @param message
	 */
	public synchronized void log(String message) throws IOException {
		consoleLog(message);
		fileLog(message);
	}
	
	/**
	 * ����������� �������
	 * @param filepath
	 */
	public Logger(String filepath) throws IOException {
		this.setFilepath(filepath);
		out = new FileWriter(filepath);
	}
	
	  @Override
	  public void finalize() throws IOException {
		  out.close();
	  }
}
