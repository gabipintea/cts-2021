package gabriel.pintea.g1094.prototype;

public class Light extends Entity<LightState> {
	
	private Light() {
		this.type = EntityType.LIGHT;		
	}
	
	public Light(String name, String icon, String area) {
		this.friendlyName = name;
		this.icon = icon;
		this.area = area;
		
		String[] splitName = name.split(" ");
		this.setEntityId("light." + String.join("_", splitName));
		this.type = EntityType.LIGHT;
	}
	
	public void setArea(String area) {
		this.area = area;
	}


	@Override
	public void setState(LightState state) {
		switch(state) {
		case ON:
			this.state = "on";
			break;
		case OFF:
			this.state = "off";
			break;
		case DIM:
			this.state = "dim";
			break;
		case BRIGHT:
			this.state = "bright";
			break;
		case EFFECT:
			this.state = "effect";
			break;
		default:
			throw new UnsupportedOperationException("Not a defined light state");
		}
		
	}

	@Override
	public Object clone() {
		Light copy = new Light();
		copy.friendlyName = this.friendlyName;
		copy.setEntityId(this.getEntityId() + "_copy");
		copy.area = this.area;
		copy.icon = this.icon;
		return copy;
	}
	
	
	
	

}
