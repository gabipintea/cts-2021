package gabriel.pintea.g1094.prototype;

public abstract class Entity<E extends Enum<E>> implements Cloneable {
	private String entityId;
	
	protected String friendlyName;
	protected String icon;
	protected String area;
	protected EntityType type;
	protected String state = "Unavailable";
	
	protected Entity() {
		
	}
	
	public String getEntityId() {
		return this.entityId;
	}
	
	public void setEntityId(String id) {
		this.entityId = id;
	}
	
	public String getFriendlyName() {
		return friendlyName;
	}

	public String getIcon() {
		return icon;
	}

	public String getArea() {
		return area;
	}

	public String getState() {
		return state;
	}
	public abstract void setState(E state);

	@Override
	public Object clone() {
		Object clone = null;

		try {
			clone = super.clone();

		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}

		return clone;
	}

	@Override
	public String toString() {
		return getEntityId() + " " + getState() + ";";
	}
	
}
