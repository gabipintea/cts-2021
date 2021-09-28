package gabriel.pintea.g1094.prototype;

public class DNSServer extends Server {
	
	public DNSServer(String ipAddress, int port, int maxConnections) {
		super(ipAddress, port, maxConnections);
	}
	
	@Override
	public boolean connect() {
		if(this.currentConnections < this.maxConnections) {
			System.out.println("DNS connected");
			this.currentConnections++;
			return true;
		}
		return false;
	}

	@Override
	public boolean disconnect() {
		if(this.currentConnections > 0) {
			System.out.println("DNS disconnected");
			this.currentConnections--;
			return true;
		}
		return false;
	}

}
