package gabriel.pintea.g1094.flyweight;

import java.util.HashMap;
import java.util.Map;

import gabriel.pintea.g1094.prototype.EntityType;
import gabriel.pintea.g1094.prototype.Light;
import gabriel.pintea.g1094.simplefactory.EntityFactory;

public class LightFactory {
	private Map<String, Light> lights = new HashMap<String, Light>();
	
	public Light getLight(String entityId) {
		Light light = lights.get(entityId);
		if(light == null) {
			light = (Light) new EntityFactory().getEntity(EntityType.LIGHT);
			light.setEntityId(entityId);
			lights.put(entityId, light);
		}
		return light;
	}
	
	public int getNoLights() {
		return lights.size();
	}

}
