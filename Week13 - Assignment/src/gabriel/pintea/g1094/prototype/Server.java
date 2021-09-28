package gabriel.pintea.g1094.prototype;

import gabriel.pintea.g1094.singleton.ServerInterface;

public abstract class Server implements ServerInterface, Cloneable {
	String ipAddress;
	int port;
	int maxConnections;
	int currentConnections;
	
	
	public Server() {
		
	}	
	
	public Server(String ipAddress, int port, int maxConnections) {
		this.ipAddress = ipAddress;
		this.port = port;
		this.maxConnections = maxConnections;
	}

	@Override
	public String getIpAddress() {
		return this.ipAddress;
	}

	@Override
	public int getPort() {
		return this.port;
	}

	@Override
	public int getMaxConnections() {		
		return this.maxConnections;
	}

	@Override
	public boolean connect() {
		if(this.currentConnections < this.maxConnections) {
			this.currentConnections++;
			return true;
		}
		return false;
	}

	@Override
	public boolean disconnect() {
		if(this.currentConnections > 0) {
			this.currentConnections--;
			return true;
		}
		return false;
	}

	@Override
	public Object clone() {
		Object clone = null;

		try {
			clone = super.clone();

		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}

		return clone;
	}
	
	

}
