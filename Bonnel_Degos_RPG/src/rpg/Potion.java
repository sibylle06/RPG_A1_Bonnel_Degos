package rpg;

public class Potion implements Consumable {
	private int efficacity;
	
	public Potion() {
		this.efficacity = 3;
	}
	
	public int getEfficacity() {
		return this.efficacity;
	}
	
	public void setEfficacity(int efficacity) {
		this.efficacity = efficacity;
	}
}
