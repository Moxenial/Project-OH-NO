import java.util.ArrayList;

public class Player implements DefaultRules {
	
	// Creates an array list for the players hand
	private int playerNumber;
	
	private ArrayList<Card> hand = new ArrayList<Card>(STARTINGHAND);
	
	private int currentPlayer;
	private boolean isPlayOrderClockwise = true;
	
	public ArrayList<Card> getHand() {
		return this.hand;
	}
	
	public void setHand(ArrayList<Card> hand) {
		this.hand.clear();
		this.hand = hand;
	}
	
	public Player(int playerNumber)
	{
		this.playerNumber = playerNumber;
	}
	
	public void addCard(Card card)
	{
		this.hand.add(card);
		System.out.println("Player: " + hand.size());
	}

	public void ohnoCheck(int playerTurnNum)
	{
	}

	


}
