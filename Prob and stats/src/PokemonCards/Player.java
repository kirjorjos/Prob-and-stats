package PokemonCards;

import java.util.ArrayList;
import java.util.Random;
import PokemonCards.pokemon.*;

public class Player {
	private Hand<Card> hand = new Hand<Card>();
	private Deck<Card> deck = new Deck<Card>();
	private ArrayList<Card> prizes = new ArrayList<Card>();
	private Random rand = new Random();
	
	public Player() {
		
	}
	
	private Pokemon genRandomPokemon() {
		int index = rand.nextInt(2);
		if (index == 0) {
			return new Pikachu();
		} else {
			return new Raichu();
		}
	}
	
	public void fillDeck(int pokemonCount) {
		for (int i = 0; i < pokemonCount; i++) {
			deck.add(genRandomPokemon());
		}
	}
	
	public Hand<Card> drawHand() {
		for (int i = 0; i < 7; i++) {
			hand.add(deck.draw());
		}
		return hand;
	}
	
	public Hand<Card> getHand() {
		return hand;
	}
	
	public Deck<Card> shuffleDeck() {
		return deck.shuffle();
	}
	
	public Hand<Card> draw(int toDraw) {
		for (int i = 0; i < toDraw; i++) {
			hand.add(deck.draw());
		}
		return hand;
	}
	
	public void generatePrizes() {
		for (int i = 0; i < 6; i++) {
			prizes.add(deck.draw());
		}
	}

	public void takeTurn(Game game) {
		
	}
}