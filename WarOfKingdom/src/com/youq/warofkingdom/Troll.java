package com.youq.warofkingdom;

public class Troll extends Character{

	public Troll() {	//name the character
		super("Troll");
	}

	@Override
	public void fight() {
		weaponBehavior.useWeapon();
	}

	@Override
	public void showCharacter() {
		System.out.println("I'm a " + characterTitle);		
	}

}
