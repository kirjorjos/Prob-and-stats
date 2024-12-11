package PokemonCards;

public class Trainer extends Card {
	
	private int health;
	
	public Trainer() {
		health = 100;
	}
	
	public Trainer(int health) {
		this.health = health;
	}


	public int getHealth() {
		return health;
	}



	public void setHealth(int health) {
		this.health = health;
	}
}
