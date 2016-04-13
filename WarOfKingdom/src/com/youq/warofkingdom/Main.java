package com.youq.warofkingdom;

public class Main {
	public static void main(String[] argv){
		
		//Characters
		Character king = new King();
		Character queen = new Queen();
		Character troll = new Troll();
		
		//Weapons
		WeaponBehavior knife = new KnifeBehavior();
		WeaponBehavior sword = new SwordBehavior();
		WeaponBehavior bow_arrow = new BowAndArrowBehavior();
		
		//fight round 1
		king.joinFight();
		troll.joinFight();
		queen.joinFight();
		
		//set weapon
		king.setWeapon(sword);
		queen.setWeapon(bow_arrow);
		troll.setWeapon(knife);
		
		//fight round 2
		king.joinFight();
		troll.joinFight();
		queen.joinFight();
		
	}

}
