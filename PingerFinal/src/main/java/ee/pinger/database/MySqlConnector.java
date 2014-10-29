package ee.pinger.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector {

	
	private final String username;
	private final String password;
	private final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost:3306/";
	private Connection con;
	private final String databaseName;
	
	public MySqlConnector(String username, String password, String databaseName) {
		this.username = username;
		this.password = password;
		this.databaseName = databaseName;
	}

	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName(DRIVER_CLASS);
		String dburl = DB_URL + this.databaseName;
		con = DriverManager.getConnection(dburl, username, password);
		return con;
	}

	public void close() throws SQLException {
		con.close();
	}

}
