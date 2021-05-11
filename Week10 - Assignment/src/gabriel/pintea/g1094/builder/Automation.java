package gabriel.pintea.g1094.builder;

import java.util.ArrayList;

import gabriel.pintea.g1094.prototype.Entity;
import gabriel.pintea.g1094.prototype.EntityType;

public class Automation extends Entity<AutomationState> {
	String mode;
	ArrayList<String> triggers = new ArrayList<>();
	ArrayList<String> conditions = new ArrayList<>();
	ArrayList<String> actions = new ArrayList<>();
	
	private Automation() {
		
	}
	
	public void trigger() {
		System.out.println(String.format("%s is triggered", this.friendlyName));
		this.setState(AutomationState.TRIGGERED);
		this.startAutomation();
	}
	
	public void startAutomation() {
		for(String action : actions) {
			System.out.println(String.format("Executing %s", action));
		}
		this.setState(AutomationState.RELOADED);
	}
	
	@Override
	public void setState(AutomationState state) {
		this.state = String.valueOf(state.toString());
	}
	
	public static class AutomationBuilder {
		private Automation automation = null;
		
		public AutomationBuilder() {
			automation = new Automation();
		}
		
		public AutomationBuilder setName(String name) {
			automation.friendlyName = name;
			
			String[] splitName = name.split(" ");
			automation.setEntityId("automation." + String.join("_", splitName));
			automation.type = EntityType.AUTOMATION;
			automation.setState(AutomationState.WAITING);
			return this;
		}
		
		public AutomationBuilder addTrigger(String trigger) {
			automation.triggers.add(trigger);
			return this;
		}
		
		public AutomationBuilder addCondition(String condition) {
			automation.conditions.add(condition);
			return this;
		}
		
		public AutomationBuilder addAction(String action) {
			automation.actions.add(action);
			return this;
		}
		
		public AutomationBuilder setIcon(String icon) {
			automation.icon = icon;
			return this;
		}
		
		public AutomationBuilder setArea(String area) {
			automation.area = area;
			return this;
		}
		
		public Automation build() {
			return this.automation;
		}
		
	}
	
}