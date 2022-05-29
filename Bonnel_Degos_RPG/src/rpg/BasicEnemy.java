package rpg;

public class BasicEnemy extends Enemy {

	public BasicEnemy(int turn, int nb) {
		super(turn, nb);
	}
	
	public void print() {
		System.out.println("Simple ennemie : PV - " + this.lifePoints + " & Degats - " + this.strenght);
	}
}
