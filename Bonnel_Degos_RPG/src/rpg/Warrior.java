package rpg;

import java.util.ArrayList;

public class Warrior extends Hero {
	public Warrior() {
		this.name = "Guerrier";
		this.lifePoints = 5;
		this.armor = 5;
		this.weaponDamage = 2;
		this.potions = new ArrayList<Potion>();
		this.lembas = new ArrayList<Food>();
	}
	
	public void print() {
		System.out.println("Guerrier -> PV : " + this.lifePoints + ", Armure : " + this.armor + ", Degat de l'arme : " + this.weaponDamage
				+ ", Potion : " + potions.size() + ", Lembas : " + lembas.size());
	}
}
