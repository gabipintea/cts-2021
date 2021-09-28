package gabriel.pintea.g1094.prototype;

public class FTPServer extends Server {

	public FTPServer(String ipAddress, int port, int maxConnections) {
		super(ipAddress, port, maxConnections);
	}
	
	@Override
	public boolean connect() {
		if(this.currentConnections < this.maxConnections) {
			System.out.println("FTP connected");
			this.currentConnections++;
			return true;
		}
		return false;
	}

	@Override
	public boolean disconnect() {
		if(this.currentConnections > 0) {
			System.out.println("FTP disconnected");
			this.currentConnections--;
			return true;
		}
		return false;
	}
}
