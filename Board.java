import java.util.ArrayList;
//package cards.functions;
public class Board implements DefaultRules{
	
	private ArrayList<Card> deck;
	private ArrayList<Card> discardPile;
	private Card currentPlayedCard;

	//accessors
	public ArrayList<Card> getDeck() {
		return this.deck;
	}
	
	public void shuffle() {
		Card placeholder = new Card();
		int a = 0;
		int b = 0;
		for(int i = 0; i < DECKSIZE; ++i)
		{
			a = (int) (Math.random() * DECKSIZE);
			do {
				b = (int) (Math.random() * DECKSIZE);
			} while(b == a);
			placeholder = this.deck.get(a); //copy a to placeholder
			this.deck.set(a, this.deck.get(b)); //copy b to a
			this.deck.set(b, placeholder); //copy placeholder to b
		}
	}
	
	public void generateStandardDeck() {
		this.deck.clear();
		//colorless
		this.deck.add(new Card(0,0));
		this.deck.add(new Card(0,0));
		this.deck.add(new Card(0,0));
		this.deck.add(new Card(0,0));
		this.deck.add(new Card(0,1));
		this.deck.add(new Card(0,1));
		this.deck.add(new Card(0,1));
		this.deck.add(new Card(0,1));
		//red
		this.deck.add(new Card(1,0));
		this.deck.add(new Card(1,1));
		this.deck.add(new Card(1,1));
		this.deck.add(new Card(1,2));
		this.deck.add(new Card(1,2));
		this.deck.add(new Card(1,3));
		this.deck.add(new Card(1,3));
		this.deck.add(new Card(1,4));
		this.deck.add(new Card(1,4));
		this.deck.add(new Card(1,5));
		this.deck.add(new Card(1,5));
		this.deck.add(new Card(1,6));
		this.deck.add(new Card(1,6));
		this.deck.add(new Card(1,7));
		this.deck.add(new Card(1,7));
		this.deck.add(new Card(1,8));
		this.deck.add(new Card(1,8));
		this.deck.add(new Card(1,9));
		this.deck.add(new Card(1,9));
		this.deck.add(new Card(1,10));
		this.deck.add(new Card(1,10));
		this.deck.add(new Card(1,11));
		this.deck.add(new Card(1,11));
		this.deck.add(new Card(1,12));
		this.deck.add(new Card(1,12));
		//yellow
		this.deck.add(new Card(2,0));
		this.deck.add(new Card(2,1));
		this.deck.add(new Card(2,1));
		this.deck.add(new Card(2,2));
		this.deck.add(new Card(2,2));
		this.deck.add(new Card(2,3));
		this.deck.add(new Card(2,3));
		this.deck.add(new Card(2,4));
		this.deck.add(new Card(2,4));
		this.deck.add(new Card(2,5));
		this.deck.add(new Card(2,5));
		this.deck.add(new Card(2,6));
		this.deck.add(new Card(2,6));
		this.deck.add(new Card(2,7));
		this.deck.add(new Card(2,7));
		this.deck.add(new Card(2,8));
		this.deck.add(new Card(2,8));
		this.deck.add(new Card(2,9));
		this.deck.add(new Card(2,9));
		this.deck.add(new Card(2,10));
		this.deck.add(new Card(2,10));
		this.deck.add(new Card(2,11));
		this.deck.add(new Card(2,11));
		this.deck.add(new Card(2,12));
		this.deck.add(new Card(2,12));
		//green
		this.deck.add(new Card(3,0));
		this.deck.add(new Card(3,1));
		this.deck.add(new Card(3,1));
		this.deck.add(new Card(3,2));
		this.deck.add(new Card(3,2));
		this.deck.add(new Card(3,3));
		this.deck.add(new Card(3,3));
		this.deck.add(new Card(3,4));
		this.deck.add(new Card(3,4));
		this.deck.add(new Card(3,5));
		this.deck.add(new Card(3,5));
		this.deck.add(new Card(3,6));
		this.deck.add(new Card(3,6));
		this.deck.add(new Card(3,7));
		this.deck.add(new Card(3,7));
		this.deck.add(new Card(3,8));
		this.deck.add(new Card(3,8));
		this.deck.add(new Card(3,9));
		this.deck.add(new Card(3,9));
		this.deck.add(new Card(3,10));
		this.deck.add(new Card(3,10));
		this.deck.add(new Card(3,11));
		this.deck.add(new Card(3,11));
		this.deck.add(new Card(3,12));
		this.deck.add(new Card(3,12));
		//blue
		this.deck.add(new Card(4,0));
		this.deck.add(new Card(4,1));
		this.deck.add(new Card(4,1));
		this.deck.add(new Card(4,2));
		this.deck.add(new Card(4,2));
		this.deck.add(new Card(4,3));
		this.deck.add(new Card(4,3));
		this.deck.add(new Card(4,4));
		this.deck.add(new Card(4,4));
		this.deck.add(new Card(4,5));
		this.deck.add(new Card(4,5));
		this.deck.add(new Card(4,6));
		this.deck.add(new Card(4,6));
		this.deck.add(new Card(4,7)); 
		this.deck.add(new Card(4,7));
		this.deck.add(new Card(4,8));
		this.deck.add(new Card(4,8));
		this.deck.add(new Card(4,9));
		this.deck.add(new Card(4,9));
		this.deck.add(new Card(4,10));
		this.deck.add(new Card(4,10));
		this.deck.add(new Card(4,11));
		this.deck.add(new Card(4,11));
		this.deck.add(new Card(4,12));
		this.deck.add(new Card(4,12));
		shuffle();
	}
	
	public void generateRandomDeck() {
		this.deck.clear();
		int color;
		int value;
		for(int i = 0; i < DECKSIZE; ++i)
		{
			color = (int) (Math.random() * 5);
			if(color == 0) //colorless
			{
				value = (int) (Math.random() * 2);
			}
			else
			{
				value = (int) (Math.random() * 13);
			}
			this.deck.add(new Card(color, value));
		}
		shuffle();
	}

	
	//default contructor
	public Board() {
		this.deck = new ArrayList<Card>();
		this.discardPile = new ArrayList<Card>();
		this.currentPlayedCard = new Card(1, 1);

	}
	
}
