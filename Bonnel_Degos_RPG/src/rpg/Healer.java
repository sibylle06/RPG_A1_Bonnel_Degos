package rpg;

import java.util.ArrayList;

public class Healer extends SpellCaster {
	public Healer() {
		this.name = "Healer";
		this.lifePoints = 5;
		this.armor = 2;
		this.manaPoints = 100;
		this.manaCostSpell = 10;
		this.weaponDamage = 2;
		this.potions = new ArrayList<Potion>();
		this.lembas = new ArrayList<Food>();
	}
	
	public void print() {
		System.out.println("Healer -> PV : " + this.lifePoints + ", Mana : " + this.manaPoints + ", Armure : " + this.armor + ", Soin de l'arme : " + this.weaponDamage
				+ ", Potion : " + potions.size() + ", Lembas : " + lembas.size());
	}
}
