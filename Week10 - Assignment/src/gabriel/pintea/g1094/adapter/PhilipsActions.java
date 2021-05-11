package gabriel.pintea.g1094.adapter;

public interface PhilipsActions {
	public String getDeviceName();
	public String getEndpoint();
	
	public void turnOn();
	public void turnOff();
	public void chgBrightness(Double value);
	@Override
	String toString();
	
}
