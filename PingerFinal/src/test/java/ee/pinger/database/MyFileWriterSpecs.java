/**
 * 
 */
package ee.pinger.database;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.BufferedWriter;
import java.io.IOException;

import org.junit.Test;

public class MyFileWriterSpecs {
	
	@Test
	public void itWritesAFile() throws IOException {
		// Given
		BufferedWriter writer = mock(BufferedWriter.class);
		MyCustomFileWriter myWriter = new MyCustomFileWriter(writer);

		// When
		myWriter.writeLine("This is statement 1");

		// Then
		verify(writer, atLeastOnce()).write(anyString());
	}

}
