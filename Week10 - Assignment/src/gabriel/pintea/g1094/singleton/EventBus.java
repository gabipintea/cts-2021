package gabriel.pintea.g1094.singleton;

public class EventBus {
	
	Boolean status;
	String container;
	
	public static final EventBus bus = new EventBus();
	
	static {
		bus.status = true;
		bus.container = "127.0.0.1:65823";
		System.out.println("EventBus ready!");
	}
	
	private EventBus() {
		this.status = true;
		this.container = "127.0.0.1:65823";
		System.out.println("EventBus created");
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	public String getContainer() {
		return this.container;
	}
	
	public void fireEvent(EventType type, String data, String timeFired) {
		switch(type) {
		case STATE_CHANGED:
			System.out.println(String.format("%s changed state at %s", data, timeFired));
			break;
		case TIME_CHANGED:
			System.out.println(String.format("Time changed to %s", timeFired));
			break;
		case CALL_SERVICE:
			System.out.println(String.format("The service %s is called at %s", data, timeFired));
			break;
		case SERVICE_EXECUTED:
			System.out.println(String.format("The service %s executed successfully at %s", data, timeFired));
			break;
		case COMPONENT_LOADED:
			System.out.println(String.format("%data loaded at %s", data, timeFired));
			break;
		default:
			throw new UnsupportedOperationException();		
		}
		System.out.println("Event recorded to database...");
	}
	
	public void listen(EventType type) {
		System.out.println(String.format("Listening to %s", type));
	}
	
	

}
