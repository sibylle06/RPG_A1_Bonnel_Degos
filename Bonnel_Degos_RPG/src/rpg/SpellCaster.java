package rpg;

public class SpellCaster extends Hero {
	protected int manaPoints;
	protected int manaCostSpell;
	
	public int getManaCostSpell() {
		return this.manaCostSpell;
	}
	
	public void setManaCostSpell(int manaCostSpell) {
		this.manaCostSpell = manaCostSpell;
	}
	
	public int getManaPoints() {
		return this.manaPoints;
	}
	
	public void setManaPoints(int manaPoints) {
		this.manaPoints = manaPoints;
	}
}
