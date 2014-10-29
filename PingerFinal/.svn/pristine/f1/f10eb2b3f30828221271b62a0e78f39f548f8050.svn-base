package ee.pinger.database;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PingTrendSpecs {

	@Test
	public void itVerifiesIfDataIsWrittenToFile() throws IOException, SQLException, ClassNotFoundException {
		// Given
		Repository mySqlPingRepository = mock(MySqlPingRepository.class);
		Repository filePingRepository = mock(FilePingRepository.class);
		PingerTrend pingerTrend = new PingerTrend(mySqlPingRepository, filePingRepository);
		Ping ping = mock(Ping.class);
		List<Ping> pings = new ArrayList<Ping>();
		pings.add(ping);
		given(mySqlPingRepository.readAll()).willReturn(pings);
		
		// When
		pingerTrend.generate();

		// Then
		verify(filePingRepository, atLeastOnce()).write(ping);
	}

}
