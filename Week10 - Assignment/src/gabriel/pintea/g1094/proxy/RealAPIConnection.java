package gabriel.pintea.g1094.proxy;

public class RealAPIConnection implements APIConnection {

	@Override
	public void connect(String address, String APIToken) throws UnsupportedOperationException {
		System.out.println("Connected to " + address + " with key: " + APIToken);		
	}

}
