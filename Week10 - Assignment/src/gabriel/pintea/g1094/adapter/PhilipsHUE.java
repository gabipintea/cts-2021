package gabriel.pintea.g1094.adapter;

public class PhilipsHUE implements PhilipsActions {
	
	public final String name = "Philips Bulb";
	public String address = "192.168.0.110";

	@Override
	public String getDeviceName() {
		return name;
	}

	@Override
	public String getEndpoint() {
		return address;
	}

	@Override
	public void turnOn() {
		System.out.println("{ service: light.turn_on }");
		
	}

	@Override
	public void turnOff() {
		System.out.println("{ service: light.turn_off }");
		
	}

	@Override
	public void chgBrightness(Double value) {
		System.out.println("{ service: light.turn_on, data: {brightness:" + value.toString() + "}");
		
	}

	@Override
	public String toString() {
		return "{ device: Philips Bulb, state: IDLE }";
	}
	
	

}
