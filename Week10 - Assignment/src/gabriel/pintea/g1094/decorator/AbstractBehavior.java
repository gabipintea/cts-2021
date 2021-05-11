package gabriel.pintea.g1094.decorator;

import gabriel.pintea.g1094.prototype.Light;
import gabriel.pintea.g1094.prototype.LightState;

public class AbstractBehavior extends Light {
	Light light = null;
	
	public AbstractBehavior(Light light) {
		super(light.getFriendlyName(), light.getIcon(), light.getArea());
		this.light = light;
	}

	@Override
	public void setState(LightState state) {
		this.light.setState(state);
	}
	
	

}
