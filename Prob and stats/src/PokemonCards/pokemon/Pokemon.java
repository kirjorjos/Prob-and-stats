package PokemonCards.pokemon;

import PokemonCards.Card;

public class Pokemon extends Card {
	private int hp;
	private int attack;
	private int defense;
	private int special;
	private int speed;

	public Pokemon() {

	}

	public Pokemon(int hp, int attack, int defense, int special, int speed) {
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.special = special;
		this.speed = speed;
	}

	public int getHp() {
		return hp;
	}

	public void attack(Pokemon p) {
		p.takeDamage(attack);
	}

	public void takeDamage(int damage) {
		hp -= damage;
	}

	public int getDefense() {
		return defense;
	}

	public int getSpecial() {
		return special;
	}

	public int getSpeed() {
		return speed;
	}

}
