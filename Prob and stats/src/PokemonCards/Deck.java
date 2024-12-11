package PokemonCards;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Deck<E> extends Stack<E> {
	
	private static final long serialVersionUID = 2244445160966376962L;
	final Random rand = new Random();
	
	
	public Deck() {
		
	}
	
	public Deck<E> shuffle() {
		ArrayList<E> tempDeck = new ArrayList<E>(this);
		while (!empty()) {
			pop();
		}
		while (!tempDeck.isEmpty()) {
			E card = tempDeck.get(rand.nextInt(tempDeck.size()));
			push(card);
			tempDeck.remove(card);
		}
		return this;
	}
	
	public E draw() {
		return pop();
	}
}
