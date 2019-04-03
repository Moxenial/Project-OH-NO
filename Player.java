import java.util.ArrayList;
public class Player extends Card{
	
	super(int color,int value);
	private ArrayList<Card> hand;
	private int playerNumber;
	private String name;
	
	public void addCard(Card card) {
		this.hand.add(card);
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	@Override
	public String toString() {
		return ("Player hand : " + hand + "\nPlayer name " + name + "\nplayer number " + playerNumber +
				"\nCard color:" color + "\nCard value: " card.value);
	}


}

