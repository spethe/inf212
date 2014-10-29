/**
 * 
 */
package ee.pinger.database;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

public class WebResourceServletSpecs {

	@Test
	public void itShouldWriteToRepository() throws ServletException, IOException {
		// Given
		Repository repository = mock(Repository.class);
		WebResourceServlet servlet = new WebResourceServlet();
		
		HttpServletRequest ignoreRequest = mock(HttpServletRequest.class);
		HttpServletResponse ignoreResponse = mock(HttpServletResponse.class);
		
		ServletConfig mockConfig = mock(ServletConfig.class);
		ServletContext mockContext = mock(ServletContext.class);
		PrintWriter writer = mock(PrintWriter.class);
		
		given(mockConfig.getServletContext()).willReturn(mockContext);
		given(mockContext.getAttribute("repository")).willReturn(repository);
		given(ignoreRequest.getParameter("simulateProcessingTime")).willReturn("4000");
		given(ignoreResponse.getWriter()).willReturn(writer);
		servlet.init(mockConfig);
		
		// When
		servlet.doGet(ignoreRequest, ignoreResponse);
		
		// Then
		verify(repository).write(any(Ping.class));
	}

}
