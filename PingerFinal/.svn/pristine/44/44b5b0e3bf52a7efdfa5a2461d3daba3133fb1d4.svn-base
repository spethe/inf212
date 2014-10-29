/**
 * 
 */
package ee.pinger.database;

import java.io.*;

public class MyCustomFileWriter{
	

	private BufferedWriter myWriter;
	private static final String NEW_LINE = System.getProperty("line.separator");

	public MyCustomFileWriter(BufferedWriter writer) {
		this.myWriter = writer;
	}

	public void writeLine(String line) {
		try {
			myWriter.write(line);
			myWriter.write(NEW_LINE);
			myWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
