package gabriel.pintea.g1094.decorator;

import gabriel.pintea.g1094.prototype.Light;
import gabriel.pintea.g1094.prototype.LightState;

public class PermissionDecorator extends AbstractBehavior {

	public PermissionDecorator(Light light) {
		super(light);
		this.state = "Hidden";
	}

	@Override
	public void setState(LightState state) {
		System.out.println("This light is hidden");
	}
	
	

}
