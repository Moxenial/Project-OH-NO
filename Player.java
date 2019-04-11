import java.util.ArrayList;
public class Player {
	private ArrayList<Card> hand;
	private int playerNumber;
	private String name;
	
	public void addCard(Card card) {
		this.hand.add(card);
	}
}
