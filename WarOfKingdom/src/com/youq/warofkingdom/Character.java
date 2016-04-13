package com.youq.warofkingdom;

public abstract class Character {
	WeaponBehavior weaponBehavior;
	String characterTitle;
	
	public abstract void fight();
	public abstract void showCharacter();
	
	public  Character(String ct){
		characterTitle = ct;
	}
	
	//set weapon for character
	public void setWeapon(WeaponBehavior newWeapon){
		weaponBehavior = newWeapon;
		System.out.println(characterTitle + " got a new Weapon!");
	}
	
	//join fight
	public void joinFight(){
		showCharacter();
		
		//fight 
		if(weaponBehavior == null){
			System.out.println(characterTitle + " got no Weapon!");
		}
		else{
			fight();
		}
	}

}
