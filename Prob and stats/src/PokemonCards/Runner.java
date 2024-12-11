package PokemonCards;

public class Runner {
	
	private static Game game = new Game();
	
	public static void run() {
		boolean gameOver = false;
		Player player1 = new Player();
		Player player2 = new Player();
		
		setup(player1, player2);
		while (!gameOver) {
			player1.takeTurn(game);
			player2.takeTurn(game);
		}
	}
	
	
	private static void setup(Player player1, Player player2) {
		int player1BonusCards = 0;
		int player2BonusCards = 0;
		player1 .drawHand();
		while (!player1.getHand().hasPokemon()) {
			player1.shuffleDeck();
			player1.drawHand();
			player2BonusCards++;
		}
		player2.drawHand();
		while (!player2.getHand().hasPokemon()) {
			player2.shuffleDeck();
			player2.drawHand();
			player1BonusCards++;
		}
		player1.draw(player1BonusCards);
		player2.draw(player2BonusCards);
		player1.generatePrizes();
		player2.generatePrizes();
	}
}
