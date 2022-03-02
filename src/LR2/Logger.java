package LR2;

import java.io.*;
import java.util.Date;

public class Logger {
	private String filepath;
    private FileWriter out = null;
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	public void consoleLog(String message) {
		System.out.println((new Date()).toString()+ ":"+message);
	}
	
	public void fileLog(String message) throws IOException {
	         String log=new Date().toString()+":"+message;
	         out.write(log);
	}
	
	public Logger(String filepath) throws IOException {
		this.setFilepath(filepath);
		out = new FileWriter(filepath);
		
	}
	
	  @Override
	  public void finalize() throws IOException {
		  out.close();
	  }
}
