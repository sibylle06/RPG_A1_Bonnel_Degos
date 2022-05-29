package rpg;

import java.util.ArrayList;

public class Hunter extends Hero {
	private int arrows;
	
	public Hunter() {
		this.name = "Hunter";
		this.lifePoints = 5;
		this.armor = 2;
		this.arrows = 10;
		this.weaponDamage = 5;
		this.potions = new ArrayList<Potion>();
		this.lembas = new ArrayList<Food>();
	}
	
	public int getArrows() {
		return this.arrows;
	}
	
	public void setArrows(int arrows) {
		this.arrows = arrows;
	}
	
	public void print() {
		System.out.println("Chasseur -> PV : " + this.lifePoints + ", Fleches : " + this.arrows + ", Armure : " + this.armor + ", Degat de l'arme : " + this.weaponDamage
				+ ", Potion : " + potions.size() + ", Lembas : " + lembas.size());
	}
}
