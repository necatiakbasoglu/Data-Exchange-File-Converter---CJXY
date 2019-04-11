package log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {
	private static Log instance = new Log();
	private String logFile ;
	private Log() {
		logFile = "LOG.txt";
	};
	
	public static Log getInstance() {
		return instance;
	}
	
	public void write(String time,String operation, String result) {
		PrintWriter out;
		try {
			out = new PrintWriter (new BufferedWriter(new FileWriter(logFile,true)));
			String data = "["+time+"]"+"["+operation+"]"+"["+result+"]\n";
	        out.write(data);
	        out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
