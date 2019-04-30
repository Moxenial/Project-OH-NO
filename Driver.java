public class Driver {


	private int currentPlayer;
	private int numberOfPlayers;
	private boolean isPlayOrderClockwise;
	


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

	
	
	
	
	public static void main(String[] args){
		
		// Sets the GUI as active
		OhNoGUI game = new OhNoGUI();
		game.setVisible(true);
		


		
		
		
	}
}
