import java.util.ArrayList;
/**
 * 
 * @author Moxenial
 *
 */
public class Driver {

	private static ArrayList<Card> deck;
	private Card currentCard;
	private ArrayList<Player> players;
	private static Board board;
	private int currentPlayer;
	private int numberOfPlayers;
	private boolean isPlayOrderClockwise;
	
	//might delete later depending on program structure
	private boolean winner;
	private boolean unoDeclared;
	
	public void drawCard(Player player) {
		player.addCard(deck.get(0));
		deck.remove(0);
	}
	public void checkCard() {
		//if(currentCard.getColor == 0) //wild card
	}
	public void playCard() {
		
	}
	public void checkHandSize() {
		if(!unoDeclared) {
			drawCard(players.get(currentPlayer));
			drawCard(players.get(currentPlayer));
			advanceTurn();
		}
		else {}
	}
	public void advanceTurn() {
		if(isPlayOrderClockwise) {
			if(currentPlayer > numberOfPlayers)
				currentPlayer = 1;
			else
				currentPlayer++;
		}
		else{
			if(currentPlayer == 0)
				currentPlayer = numberOfPlayers;
			else
				currentPlayer--;
		}
	}
	public void winCondition() {
		winner = true;
	}
	
	public static void main(String[] args){
		deck = board.generateRandomDeck();
	}
}
