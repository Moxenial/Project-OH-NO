package ohno.core;
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
	
	public void addCard(Card card)
	{
		this.hand.add(card);
	}
	public void removeCard(int index)
	{
		this.hand.remove(index);
	}
	
	public Player(int playerNumber)
	{
		this.playerNumber = playerNumber;
	}

}
