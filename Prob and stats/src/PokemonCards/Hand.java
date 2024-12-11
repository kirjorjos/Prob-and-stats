package PokemonCards;

import java.util.ArrayList;

import PokemonCards.pokemon.Pokemon;

public class Hand<E> extends ArrayList<E> {

	private static final long serialVersionUID = 9085119598608001114L;

	public boolean hasPokemon() {
		for (E card : this) {
			if (card instanceof Pokemon) {
				return true;
			}
		}
		return false;
	}
	
	
}
