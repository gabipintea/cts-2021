package ro.ase.csie.cts.g1094.dp.test;

import ro.ase.csie.cts.g1094.dp.builder.Pistol;
import ro.ase.csie.cts.g1094.dp.builder.SuperHero;
import ro.ase.csie.cts.g1094.dp.builder.SuperHero.SuperHeroBuilder;

public class TestBuilder {

	public static void main(String[] args) {
		
//		//1. create the object
//		SuperHero superHero = new SuperHero();
//		//2. init the object
//		//TO DO: don't forget
//		superHero.name = "Superman";
//		superHero.lifePoints = 100;
//		superHero.superPower = "fly";
//		superHero.superPower = "laser";
		
//		SuperHero superHero = 
//				new SuperHero("Superman", 100, false, false, null, new Pistol(), "laser", null);
		
		SuperHero superman = new SuperHero.SuperHeroBuilder("Superman", 100)
				.addSuperPower("fly")
				.addLeftWeapon(new Pistol())
				.build();
//		superman.superPower = "fly";
		
		SuperHero joker = new SuperHero.SuperHeroBuilder("Joker", 200)
				.isVillain()
				.addLeftWeapon(new Pistol())
				.addRightWeapon(new Pistol())
				.build();
		

	}

}
