/**
 * 
 */
package ee.pinger.database;

public class Ping {

	private final String servletName;
	private final String pingTime;
	private final int processingTime;

	public Ping(String servletName, String pingTime, int processingTime) {
		this.servletName = servletName;
		this.pingTime = pingTime;
		this.processingTime = processingTime;
	}

	public String getServletName() {
		return servletName;
	}

	public String getPingTime() {
		return pingTime;
	}

	public int getProcessingTime() {
		return processingTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((pingTime == null) ? 0 : pingTime.hashCode());
		result = prime * result + processingTime;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ping other = (Ping) obj;
		if (pingTime == null) {
			if (other.pingTime != null)
				return false;
		} else if (!pingTime.equals(other.pingTime))
			return false;
		if (processingTime != other.processingTime)
			return false;
		return true;
	}
	
	

}
