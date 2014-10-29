package ee.pinger.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySqlPingRepository implements Repository {

	private PreparedStatement ptmt;
	private Statement statement;
	private final String INSERT_SQL = "insert into pingerlog(servletname, pingTime, processingTime) values (?,?,?)";
	private final String SELECT_SQL = "SELECT * FROM pingerlog";
	private final MySqlConnector mySqlConnector;

	public MySqlPingRepository(MySqlConnector mySqlConnector)
			throws ClassNotFoundException, SQLException {
		this.mySqlConnector = mySqlConnector;
		this.ptmt = mySqlConnector.getConnection().prepareStatement(INSERT_SQL);
		this.statement = mySqlConnector.getConnection().createStatement();
	}
	
	@Override
	public void destroy() {
		try {
			ptmt.close();
			mySqlConnector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void write(Ping ping) {

		String servletname = ping.getServletName();
		String pingTime = ping.getPingTime();
		long processingTime = ping.getProcessingTime();

		try {
			ptmt.setString(1, servletname);
			ptmt.setString(2, pingTime);
			ptmt.setLong(3, processingTime);
			ptmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Ping> readAll() {
		List<Ping> pingerLog = new ArrayList<Ping>();
		ResultSet resultSet = null;
		try {
			if (statement.execute(SELECT_SQL)) {
				resultSet = statement.getResultSet();
			} else {
				System.err.println("select failed");
			}
			while (resultSet.next()) {
				pingerLog.add(new Ping(resultSet.getString(1), resultSet
						.getString(2), resultSet.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pingerLog;		
	}

}
