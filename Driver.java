import java.util.ArrayList;

public class Driver {

	private ArrayList<Player> players; //make this an array initialized at gameStart conditions?
	private int currentPlayer;
	private int numberOfPlayers;
	private boolean isPlayOrderClockwise;
	
	//might delete later depending on program structure
	private boolean winner;
	private boolean unoDeclared;
	
	public void drawCard(Player player) {
		
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
		
		OhNoGUI game = new OhNoGUI();
		game.setVisible(true);
		
		Board board = new Board();
		board.generateStandardDeck();
		
		System.out.println("STANDARD DECK SIZE: " + board.getDeck().size());
		for(int i = 0; i < board.getDeck().size(); ++i) {
			System.out.println(board.getDeck().get(i).toString());
		}
		
		board.generateRandomDeck();
		
		System.out.println("RANDOM DECK SIZE: " + board.getDeck().size());
		for(int i = 0; i < board.getDeck().size(); ++i) {
			System.out.println(board.getDeck().get(i).toString());
		}
	}
}
