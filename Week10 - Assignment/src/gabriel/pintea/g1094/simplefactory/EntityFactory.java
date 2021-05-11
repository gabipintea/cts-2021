package gabriel.pintea.g1094.simplefactory;

import gabriel.pintea.g1094.prototype.Entity;
import gabriel.pintea.g1094.prototype.EntityType;
import gabriel.pintea.g1094.prototype.Light;

public class EntityFactory {
	public static Entity getEntity(EntityType type) {
		Entity entity = null;
		switch(type) {
		case LIGHT: 
			entity = new Light("UnknownLight", "mdi:lightbulb", "No area");
			break;
		default:
			throw new UnsupportedOperationException("No implementation yet");
		}
		
		return entity;
	}

}
