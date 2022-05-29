package rpg;

public class Enemy {
	protected int lifePoints;
	protected int strenght;
	
	public Enemy(int turn, int nb) {
		this.lifePoints = turn + nb;
		this.strenght = turn;
	}
	
	public int getLifePoints() {
		return this.lifePoints;
	}
	
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	
	public int getStrenght() {
		return this.strenght;
	}
	
	public void print() {
		System.out.println("Ennemi : PV - " + this.lifePoints + " & Degats - " + this.strenght);
	}
}
