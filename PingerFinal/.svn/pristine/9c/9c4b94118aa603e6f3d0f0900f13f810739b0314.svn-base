/**
 * 
 */
package ee.pinger.database;

import java.util.List;

public class FilePingRepository implements Repository {

	private MyCustomFileWriter myCustomWriter;

	public FilePingRepository(MyCustomFileWriter myCustomWriter) {
		this.myCustomWriter = myCustomWriter;
	}

	@Override
	public void write(Ping ping) {
		String line = ping.getServletName() + "," + ping.getPingTime() + ","
				+ ping.getProcessingTime();
		myCustomWriter.writeLine(line);
	}

	@Override
	public List<Ping> readAll() {
		return null;
	}

	@Override
	public void destroy() {
	}

}
