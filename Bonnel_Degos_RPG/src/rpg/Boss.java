package rpg;

public class Boss extends Enemy {

	public Boss(int turn, int nb) {
		super(turn, nb);
	}

	public void print() {
		System.out.println("Boss : PV - " + this.lifePoints + " & Degats - " + this.strenght);
	}
}
