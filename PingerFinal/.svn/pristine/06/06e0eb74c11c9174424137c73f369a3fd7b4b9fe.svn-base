package ee.pinger.database;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class PingTrendGenerator {

	public static void main(String[] args) {
		try {
		MySqlConnector mySqlConnector = new MySqlConnector("root", "root", "pingerinfo");
		MySqlPingRepository mySqlPingRepository = new MySqlPingRepository(mySqlConnector );
		BufferedWriter writer = new BufferedWriter(new FileWriter(args[1], true));
		MyCustomFileWriter myWriter = new MyCustomFileWriter(writer);
		FilePingRepository filePingRepository= new FilePingRepository(myWriter);
		
		PingerTrend pingerTrend = new PingerTrend(mySqlPingRepository,filePingRepository);
			pingerTrend.generate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
