/**
 * 
 */
package ee.pinger.database;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MySqlPingRepositorySpecs {

	static final MySqlConnector myConnector = new MySqlConnector("root", "root", "pingerTestInfo");
	static Connection connection;

	@BeforeClass
	public static void setupDatabase() throws ClassNotFoundException,
			SQLException {

		connection = myConnector.getConnection();
		Statement statement = connection.createStatement();
		statement.executeUpdate("create database if not exists pingerTestInfo");
		statement.execute("use pingerTestInfo;");
		statement.execute("drop table if exists pingerlog;");
		statement.executeUpdate("create table pingerlog(servletName VARCHAR(100), pingTime VARCHAR(40), processingTime long)");
	}

	@AfterClass
	public static void tearDownDatabase() throws SQLException {
		Statement statement = connection.createStatement();
		statement.execute("DELETE FROM pingerlog;");
		connection.close();
	}

	@Test
	public void itShouldWriteToMySQLRepo() throws SQLException,
			ClassNotFoundException {
		// Given
		MySqlConnector mockMySqlConnector = mock(MySqlConnector.class);
		Connection mockConnection = mock(Connection.class);
		Ping ping = new Ping("WebResourceServlet", "11 th October", 5000);
		PreparedStatement mockPrepareStatement = mock(PreparedStatement.class);
		String sql = "insert into pingerlog(servletname, pingTime, processingTime) values (?,?,?)";

		given(mockMySqlConnector.getConnection()).willReturn(mockConnection);
		given(mockConnection.prepareStatement(sql)).willReturn(
				mockPrepareStatement);

		MySqlPingRepository mySqlPingRepository = new MySqlPingRepository(
				mockMySqlConnector);

		// When
		mySqlPingRepository.write(ping);

		// Then
		verify(mockPrepareStatement).executeUpdate();
	}

	@Test
	public void itVerifiesTheDataWrittenInDatabase()
			throws ClassNotFoundException, SQLException {
		// Given
		Ping ping = new Ping("WRS", "15 th October", 4000);
		populateDatabase(ping);

		// When
		Ping pingReceived = getPingFromDB();

		// Then
		Assert.assertEquals(ping, pingReceived);

	}

	@Test
	public void itReadsFromRepository() throws ClassNotFoundException,
			SQLException {
		// given
		Ping ping = new Ping("WRS", "15 th October", 4000);
		populateDatabase(ping);
		MySqlPingRepository mySqlPingRepository = new MySqlPingRepository(myConnector);

		// when
		List<Ping> pingerLog = mySqlPingRepository.readAll();

		// then
		Assert.assertTrue(pingerLog.contains(ping));
	}

	
	
	
	private void populateDatabase(Ping ping) throws ClassNotFoundException,	SQLException {
		String INSERT_SQL = "insert into pingerlog(servletname, pingTime, processingTime) values (?,?,?)";
		PreparedStatement ptmt = connection.prepareStatement(INSERT_SQL);
		ptmt.setString(1, ping.getServletName());
		ptmt.setString(2, ping.getPingTime());
		ptmt.setLong(3, ping.getProcessingTime());
		ptmt.executeUpdate();
	}

	private Ping getPingFromDB() {
		ResultSet rs = null;
		Ping pingReceived = null;
		try {
			Statement statement = connection.createStatement();
			if (statement.execute("SELECT * FROM pingerlog")) {
				rs = statement.getResultSet();
			} else {
				System.err.println("select failed");
			}
			rs.last();
			pingReceived = new Ping(rs.getString(1), rs.getString(2), rs.getInt(3));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pingReceived;
	}

}
