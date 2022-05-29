package rpg;

import java.util.ArrayList;
import java.util.List;

public class Hero {
	protected String name;
	protected int lifePoints;
	protected int armor;
	protected int weaponDamage;
	protected List<Potion> potions;
	protected List<Food> lembas;
	
	public Hero() {
		this.name = "heros";
		this.lifePoints = 5;
		this.armor = 1;
		this.weaponDamage = 1;
		this.potions = new ArrayList<Potion>();
		this.lembas = new ArrayList<Food>();
	}
	
	public void betterEfficiencyPotion() {
		for (int i = 0 ; i < potions.size() ; i++) {
			potions.get(i).setEfficacity(potions.get(i).getEfficacity() + 1);
		}
	}
	
	public void betterEfficiencyLembas() {
		for (int i = 0 ; i < lembas.size() ; i++) {
			lembas.get(i).setEfficacity(lembas.get(i).getEfficacity() + 1);
		}
	}
	
	public int attack() {
		return this.weaponDamage;
	}
	
	public int defend() {
		return this.armor;
	}
	
	public void useConsumable(Consumable consumable) {
		;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void print() {
		System.out.println("Hero -> PV : " + this.lifePoints + ", Armure : " + this.armor + ", Degat de l'arme : " + this.weaponDamage
				+ ", Potion : " + potions.size() + ", Lembas : " + lembas.size());
	}
	
	public int getArmor() {
		return this.armor;
	}
	
	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	public int getWeaponDamage() {
		return this.weaponDamage;
	}
	
	public void setWeaponDamage(int weaponDamage) {
		this.weaponDamage = weaponDamage;
	}
	
	
	public int getNbPotions() {
		return this.potions.size();
	}
	
	public int getNbLembas() {
		return this.lembas.size();
	}
	
	public void removePotion() {
		this.potions.remove(0);
	}
	
	public void removeLembas() {
		this.lembas.remove(0);
	}
	
	public int getPotionHealingPoint() {
		return this.potions.get(0).getEfficacity();
	}
	
	public int getLembasHealingPoint() {
		return this.lembas.get(0).getEfficacity();
	}
	
	public int getLifePoints() {
		return this.lifePoints;
	}
	
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	
	public void addPotion() {
		this.potions.add(new Potion());
	}
	
	public void addLambas() {
		this.lembas.add(new Food());
	}
}
