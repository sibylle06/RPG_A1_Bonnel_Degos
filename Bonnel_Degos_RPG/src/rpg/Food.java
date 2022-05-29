package rpg;

public class Food implements Consumable {
	private int efficacity;
	
	public Food() {
		this.efficacity = 2;
	}
	
	public int getEfficacity() {
		return this.efficacity;
	}
	
	public void setEfficacity(int efficacity) {
		this.efficacity = efficacity;
	}
}
