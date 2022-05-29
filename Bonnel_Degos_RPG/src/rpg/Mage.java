package rpg;

import java.util.ArrayList;

public class Mage extends SpellCaster {
	public Mage() {
		this.name = "Mage";
		this.lifePoints = 5;
		this.armor = 2;
		this.manaPoints = 100;
		this.manaCostSpell = 10;
		this.weaponDamage = 5;
		this.potions = new ArrayList<Potion>();
		this.potions.add(new Potion());
		this.potions.add(new Potion());
		this.lembas = new ArrayList<Food>();
	}
	
	public void print() {
		System.out.println("Mage -> PV : " + this.lifePoints + ", Mana : " + this.manaPoints + ", Armure : " + this.armor + ", Degat de l'arme : " + this.weaponDamage
				+ ", Potion : " + potions.size() + ", Lembas : " + lembas.size());
	}
}
