/**
 * 
 */
package ee.pinger.database;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;


public class FilePingRepositorySpecs {

	@Test
	public void itWritesToFileRepository(){
		
		//given
		MyCustomFileWriter mockMyCustomFileWriter = mock(MyCustomFileWriter.class);
		FilePingRepository filePingRepository = new FilePingRepository(mockMyCustomFileWriter);
		Ping ping = new Ping("WebResourceServlet", "11 th October", 5000);
		//when
		filePingRepository.write(ping);
		
		//then
		verify(mockMyCustomFileWriter).writeLine(anyString());
	}
}
