package gabriel.pintea.g1094.proxy;

import java.util.HashMap;
import java.util.Map;

public class ProxyAPIConnection implements APIConnection {
	private APIConnection connection = new RealAPIConnection();
	private static Map<String, String> LLToken;
	
	static {
		LLToken = new HashMap<String, String>();
		LLToken.put("MobileApp", "j1bs7a02jaoidf7");
		LLToken.put("WallPanel", "ssh1ka710sjalos");
	}

	@Override
	public void connect(String address, String APIToken) throws UnsupportedOperationException {
		if(LLToken.containsValue(APIToken)) {
			connection.connect(address, APIToken);
		} else {
			throw new UnsupportedOperationException("403 Forbidden. Wrong Long-Lived-Token");
		}
		
	}

}
