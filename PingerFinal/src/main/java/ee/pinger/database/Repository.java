/**
 * 
 */
package ee.pinger.database;

import java.util.List;

public interface Repository {

	void write(Ping ping);
	List<Ping> readAll();
	void destroy();

}
