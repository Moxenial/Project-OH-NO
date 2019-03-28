import java.util.ArrayList;
//package cards.functions;
public class Board {
	
	public static final int DECKSIZE = 108;
	
	public ArrayList<Card> generateStandardDeck() {
		//PLACEHOLDER
		return new ArrayList<Card>();
	}
	public ArrayList<Card> generateRandomDeck() {
		int color;
		int value;
		ArrayList<Card> deck = new ArrayList<Card>();
		for(int i = 0; i < DECKSIZE; ++i)
		{
			color = (int) (Math.random() * 2);
			if(color == 0) //colorless
			{
				value = (int) (Math.random() * 2);
			}
			else
			{
				value = (int) (Math.random() * 13);
			}
			deck.add(new Card(color, value));
		}
		return deck;
	}
}
