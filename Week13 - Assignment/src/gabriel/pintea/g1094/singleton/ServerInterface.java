package gabriel.pintea.g1094.singleton;

public interface ServerInterface {
	
	public String getIpAddress();
    public int getPort();
    public int getMaxConnections();

    public boolean connect();
    public boolean disconnect();

}
