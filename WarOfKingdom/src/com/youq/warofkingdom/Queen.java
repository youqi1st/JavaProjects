package com.youq.warofkingdom;

public class Queen extends Character{

	public Queen() {
		super("Queen");
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
