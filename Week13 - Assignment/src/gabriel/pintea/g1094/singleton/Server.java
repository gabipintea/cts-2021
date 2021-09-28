package gabriel.pintea.g1094.singleton;

public class Server implements ServerInterface {
	private static Server srv = null;
	
	String ipAddress = null;
	int port = 0;
	int maxConnections = 0;
	int currentConnections = 0;
	
	
	private Server() {
		this.ipAddress="127.0.0.1";
		this.port=80;
		this.maxConnections=3;
	}
	
	public static Server getServer() {
		if(Server.srv == null) {
			srv = new Server();
		}
		return Server.srv;
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

}
