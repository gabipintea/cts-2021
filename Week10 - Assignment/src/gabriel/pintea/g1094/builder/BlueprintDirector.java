package gabriel.pintea.g1094.builder;

public class BlueprintDirector {
	Automation.AutomationBuilder builder;
	
	public BlueprintDirector(Automation.AutomationBuilder builder) {
		this.builder = builder;
	}
	
	public Automation buildSunsetAutomation() {
		return builder
				.setName("Sunset Blueprint Automation")
				.setIcon("mdi:half-sun")
				.setArea("Living")
				.addTrigger("Sunset")
				.addCondition("person.admin.state = home")
				.addAction("Turn On Living Lamp")
				.addAction("Say 'Living Lamp turned on'")
				.build();
	}
	
	public Automation buildSprinklerAutomation() {
		return builder
				.setName("Sprinkler Blueprint Automation")
				.setIcon("mdi:water")
				.setArea("Garden")
				.addTrigger("07:00am")
				.addCondition("sensor.outdoor_temp.state < 27")
				.addAction("Turn On Sprinklers")
				.addAction("Say 'Sprinklers turned on'")
				.build();
	}

}
