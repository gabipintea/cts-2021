package gabriel.pintea.g1094.composite;

public class Server extends AbstractNode {

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
	public void addNewNode(AbstractNode node) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void deleteNode(AbstractNode node) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public AbstractNode getNode(int index) {
		throw new UnsupportedOperationException();
	}

}
