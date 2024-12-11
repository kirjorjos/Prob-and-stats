package PokemonCards;

import PokemonCards.pokemon.Pikachu;
import PokemonCards.pokemon.Raichu;

public class BattleField {
	public static void main(String args[]) {
		Pikachu pikachu = new Pikachu();
		Raichu raichu = new Raichu();
		while ((pikachu.getHp() > 0) && (raichu.getHp() > 0)) {
			pikachu.attack(raichu);
			raichu.attack(pikachu);
		}
	}
}