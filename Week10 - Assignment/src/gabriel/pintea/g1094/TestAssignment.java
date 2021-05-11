package gabriel.pintea.g1094;

import java.time.LocalTime;
import java.util.ArrayList;

import gabriel.pintea.g1094.adapter.PhilipsActions;
import gabriel.pintea.g1094.adapter.PhilipsHUE;
import gabriel.pintea.g1094.adapter.PhilipsLightAdapter;
import gabriel.pintea.g1094.builder.Automation;
import gabriel.pintea.g1094.builder.BlueprintDirector;
import gabriel.pintea.g1094.decorator.PermissionDecorator;
import gabriel.pintea.g1094.flyweight.LightFactory;
import gabriel.pintea.g1094.builder.Automation.AutomationBuilder;
import gabriel.pintea.g1094.prototype.Entity;
import gabriel.pintea.g1094.prototype.EntityType;
import gabriel.pintea.g1094.prototype.Light;
import gabriel.pintea.g1094.prototype.LightState;
import gabriel.pintea.g1094.proxy.APIConnection;
import gabriel.pintea.g1094.proxy.ProxyAPIConnection;
import gabriel.pintea.g1094.simplefactory.EntityFactory;
import gabriel.pintea.g1094.singleton.EventBus;
import gabriel.pintea.g1094.singleton.EventType;

public class TestAssignment {
	
	private static Light[] sharedLights = new Light[10];
	private static int noLights = 0;
	
	public static void changeLight(String entityId, LightState state, LightFactory lightFactory){
		sharedLights[noLights] = lightFactory.getLight(entityId);
		sharedLights[noLights].setState(state);
		noLights++;
	}

	public static void main(String[] args) {
		
		//Singleton EventBus
		System.out.println("EventBus Log");
		System.out.println();
		EventBus eventBus = EventBus.bus;
		System.out.println("Event bus status:");
		System.out.println(String.format("Status %s, Address: %s", String.valueOf(eventBus.getStatus()), eventBus.getContainer()));
		System.out.println();
		
		eventBus.fireEvent(EventType.STATE_CHANGED, "Living Lamp", String.valueOf(LocalTime.now()));
		eventBus.listen(EventType.SERVICE_EXECUTED);
		
		//Prototype Entity
		System.out.println("##############################");
		System.out.println("Entities Log");
		System.out.println();
		
		Light livingLamp = new Light("Lamp", "mdi:lamp", "Living");
		Light officeLamp = (Light) livingLamp.clone();
		officeLamp.setArea("Office");
		
		System.out.println(livingLamp.toString());
		System.out.println(officeLamp.toString());
		
		livingLamp.setState(LightState.ON);
		officeLamp.setState(LightState.EFFECT);
		System.out.println(livingLamp.toString());
		System.out.println(officeLamp.toString());
		
		//Builder Automation
		System.out.println("##############################");
		System.out.println("Automations Log");
		System.out.println();
		
		Automation auto = new Automation.AutomationBuilder()
				.setName("Sunset Lamp")
				.setIcon("mdi:half-sun")
				.setArea("Living")
				.addTrigger("Sunset")
				.addTrigger("Time: 11:00pm")
				.addCondition("light.living_lamp.state = off")
				.addAction("Turn On Living Lamp")
				.addAction("Say 'Living Lamp turned on'")
				.build();
		System.out.println(auto.toString());
		System.out.println();
		
		auto.trigger();
		
		BlueprintDirector automationIdeas = new BlueprintDirector(new Automation.AutomationBuilder());
		Automation sprinkAuto = automationIdeas.buildSprinklerAutomation();
		sprinkAuto.trigger();
		
		//Simple Factory Entities
		System.out.println("##############################");
		System.out.println("Defaults for entities");
		System.out.println();
		
		ArrayList<Entity<LightState>> tempEntities = new ArrayList<>();
		tempEntities.add(new EntityFactory().getEntity(EntityType.LIGHT));
		tempEntities.add(new EntityFactory().getEntity(EntityType.LIGHT));
		for(Entity<LightState> e : tempEntities) {
			System.out.println(e.toString());
		}
		
		
		//Decorator Entity Permission
		System.out.println("##############################");
		System.out.println("Permissions log");
		System.out.println();
		
		
		System.out.println(officeLamp.toString());
		
		officeLamp = new PermissionDecorator(officeLamp);
		officeLamp.setState(LightState.BRIGHT);
		
		
		//Adapter Philips HUE Light integration
		System.out.println("##############################");
		System.out.println("Philips Lights log");
		System.out.println();
		
		PhilipsActions philips = new PhilipsHUE();
		philips.toString();
		
		PhilipsLightAdapter philipsAdapter = new PhilipsLightAdapter(philips);
		philipsAdapter.toString();
		philipsAdapter.setArea("Office");
		philipsAdapter.setState(LightState.ON);
		philipsAdapter.setState(LightState.OFF);
		philipsAdapter.setState(LightState.EFFECT);
		
		
		//Flyweight Lights
		System.out.println("##############################");
		System.out.println("Flyweight sharing light instances");
		System.out.println();
		
		officeLamp.setEntityId("light.Office_Lamp");
		livingLamp.setEntityId("light.Living_Lamp");
		
		LightFactory lightFactory = new LightFactory();
		
		changeLight(officeLamp.getEntityId(), LightState.ON, lightFactory);
		changeLight(officeLamp.getEntityId(), LightState.EFFECT, lightFactory);
		changeLight(livingLamp.getEntityId(), LightState.DIM, lightFactory);
		changeLight("light.Office_Leds", LightState.ON, lightFactory);
		changeLight(officeLamp.getEntityId(), LightState.OFF, lightFactory);	
		
		System.out.println(String.format("%d lights changed state", lightFactory.getNoLights()));	
		
		//Proxy API Connection
		System.out.println("##############################");
		System.out.println("Secure connection logs");
		System.out.println();
		
		APIConnection connection = new ProxyAPIConnection();
		try {
			connection.connect("smarthome.ddns.org:8123", "j1bs7a02jaoidf7");
			connection.connect("smarthome.ddns.org:8123", "asdfghj");
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
