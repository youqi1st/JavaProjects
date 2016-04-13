package com.youq.warofkingdom;

public class King extends Character{

	public King() {	//name the character
		super("king");
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
