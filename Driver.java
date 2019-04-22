import java.util.ArrayList;

public class Driver {


	private ArrayList<Player> players; //make this an array initialized at gameStart conditions?
	private Player playerInfo = new Player();
	private int currentPlayer;
	private int numberOfPlayers;
	private boolean isPlayOrderClockwise;
	
	//might delete later depending on program structure
	private boolean winner;
	private boolean unoDeclared;
	
	
	
	
	public void checkCard() {
		//if(currentCard.getColor == 0) //wild card
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
		
		// Sets the GUI as active
		OhNoGUI game = new OhNoGUI();
		game.setVisible(true);
		

		// Starts a game between two people
		int numOfPlayers = 2;
		Player playerInfo = new Player();

		playerInfo.gameRunning(numOfPlayers);
		
		
		
	}
}
