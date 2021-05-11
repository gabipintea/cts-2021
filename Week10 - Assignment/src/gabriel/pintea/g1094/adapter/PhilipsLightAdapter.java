package gabriel.pintea.g1094.adapter;

import gabriel.pintea.g1094.prototype.Light;
import gabriel.pintea.g1094.prototype.LightState;

public class PhilipsLightAdapter extends Light {
	PhilipsActions lightBulb = null;
	
	public PhilipsLightAdapter(PhilipsActions bulb) {
		super(bulb.getDeviceName(), "mdi:lightbulb", "No room");
		this.lightBulb = bulb;		
	}

	@Override
	public void setState(LightState state) {
		switch(state) {
		case ON:
			this.lightBulb.turnOn();
			break;
		case OFF:
			this.lightBulb.turnOff();
			break;
		case DIM:
			this.lightBulb.chgBrightness(10.0);
			break;
		case BRIGHT:
			this.lightBulb.chgBrightness(90.0);
			break;
		case EFFECT:
			this.lightBulb.chgBrightness(0.0);
			this.lightBulb.chgBrightness(75.0);
			this.lightBulb.chgBrightness(0.0);
			this.lightBulb.chgBrightness(100.0);
			break;
		default:
			throw new UnsupportedOperationException("Invalid state");			
		}
	}
	
	

}
