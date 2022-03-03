package LR2;

import java.io.*;
import java.util.Date;


/**
 * Файловый и консольный логгер
 * 
 * @author      Киселев Николай <korn9509@gmail.com>
 * @version     1.0                 
 * @since       1.0          
 */
public class Logger {
	/**
	 * Путь к файлу лога
	 */
	private String filepath;
	/**
	 * Поток вывода для файла лога
	 */
    private FileWriter out = null;
    
    
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * Метод вывода сообщения на консоль
	 * @param message
	 */
	public synchronized void consoleLog(String message) {
		System.out.println((new Date()).toString()+ ":"+message);
	}
	
	/**
	 * Метод вывода сообщения в файл
	 * @param message
	 */
	public synchronized void fileLog(String message) throws IOException {
	         String log=new Date().toString()+":"+message;
	         out.write(log+"\n");
	         out.flush();
	}
	
	/**
	 * Метод вывода сообщения на консоль и в файл
	 * @param message
	 */
	public synchronized void log(String message) throws IOException {
		consoleLog(message);
		fileLog(message);
	}
	
	/**
	 * Конструктор логгера
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
