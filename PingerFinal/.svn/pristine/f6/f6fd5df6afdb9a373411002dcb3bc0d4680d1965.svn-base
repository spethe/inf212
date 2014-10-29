package ee.pinger.database;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class PingerServletContext implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		String username = servletContext.getInitParameter("username");
		String password = servletContext.getInitParameter("password");
		String databaseName = servletContext.getInitParameter("databaseName");
		
		try {
			servletContext.setAttribute("repository", createRepository(username, password, databaseName));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	Repository createRepository(String username,String password, String databaseName) throws ClassNotFoundException, SQLException {
		return new MySqlPingRepository(new MySqlConnector(username, password, databaseName));
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
	}

}
