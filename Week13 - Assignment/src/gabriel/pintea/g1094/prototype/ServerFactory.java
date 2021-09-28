package gabriel.pintea.g1094.prototype;

import java.util.HashMap;

public class ServerFactory {
	
	private static HashMap<Integer, Server> servers = new HashMap<>();
	
	static {
		DNSServer dnsSrv = new DNSServer("192.168.0.1", 53, 1000);
		servers.put(dnsSrv.getPort(), dnsSrv);
		
		FTPServer ftpSrv = new FTPServer("192.168.0.100", 21, 25);
		servers.put(ftpSrv.getPort(), ftpSrv);
	}
	
	public static Server getServer(int port) {
		Server protoSrv = null;
		Server prototype = servers.get(port);
		if(prototype!=null) {
			protoSrv = (Server) prototype.clone();
		}
		
		return protoSrv;
	}

}
