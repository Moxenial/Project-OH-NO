import java.util.ArrayList;

public class Player implements DefaultRules {
	
	// Creates an array list for the players hand
	private int playerNumber;
	
	private ArrayList<Card> hand = new ArrayList<Card>(STARTINGHAND);
	//private ArrayList<Card> deck;
	//private ArrayList<Card> discardPile = new ArrayList<Card>(DECKSIZE);

	// Player arrayList for each players hand
	
	/*private ArrayList<Card> playerNum_1 = new ArrayList<Card>(30);
	private ArrayList<Card> playerNum_2 = new ArrayList<Card>(30);
	private ArrayList<Card> playerNum_3 = new ArrayList<Card>(30);
	private ArrayList<Card> playerNum_4 = new ArrayList<Card>(30);	*/
	
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
		this.playerNumber = playerNumber; //this tells the player object which order it's supposed to go in.
		
		// After deck is created once here, it is then only used from the player class
		// because the player class contains all of the moves for now.
		// Basically the player class and the OhNoGUI need to constantly intereact
		// and update each others decks.
		
		Board cardsBoard = new Board();
		cardsBoard.generateStandardDeck();
		//deck = cardsBoard.getDeck();
		//dealHand(numPlayers, deck);
	
	

		


	}

	// if reverse is played set boolean isPlayOrder Clockwise to flase
	public void advanceTurn() {
		
		if(isPlayOrderClockwise) {
			if(currentPlayer > numPlayers)
				currentPlayer = 1;
			else
				currentPlayer++;
		}
		else{
			if(currentPlayer == 0)
				currentPlayer = numPlayers;
			else
				currentPlayer--;
		}
		
	}
	
	
	
	
	
	
	// Arguements dealHand(ArrayList<Card> deck)
	public void dealHand(int playerNumber, ArrayList<Card> deck)
	{
		int NUM_PLAYERS = numPlayers;
		int FIRST_DEAL = 7;
		int DECK_SIZE = 108;
		// Elements start at 0
		int topCard = DECK_SIZE-1;
		
		// Deals cards to players from playerNumber
		if (NUM_PLAYERS == 2)
		{

			for (int i = 0; i < FIRST_DEAL; i++)
			{
				playerNum_1.add(deck.get(topCard));
				deck.remove(topCard);
				topCard = topCard -1;
				
				playerNum_2.add(deck.get(topCard));
				deck.remove(topCard);
				topCard = topCard -1;

			}

		}
		else if (NUM_PLAYERS == 3)
		{
			for (int i = 0; i < FIRST_DEAL; i++)
			{
				playerNum_1.add(deck.get(topCard));
				deck.remove(topCard);
				topCard = topCard -1;
				
				playerNum_2.add(deck.get(topCard));
				deck.remove(topCard);
				topCard = topCard -1;
				
				playerNum_3.add(deck.get(topCard));
				deck.remove(topCard);
				topCard = topCard -1;
				

			}
		}
		else if (NUM_PLAYERS == 4)
		{
			for (int i = 0; i < FIRST_DEAL; i++)
			{
				playerNum_1.add(deck.get(topCard));
				deck.remove(topCard);
				topCard = topCard -1;
				
				playerNum_2.add(deck.get(topCard));
				deck.remove(topCard);
				topCard = topCard -1;
				
				playerNum_3.add(deck.get(topCard));
				deck.remove(topCard);
				topCard = topCard -1;
				
				playerNum_4.add(deck.get(topCard));
				deck.remove(topCard);
				topCard = topCard -1;
			}
		}
		else
			System.out.println("Player Count Exception");

		
		
	}
	
	// Takes card from deck and moves it to the players hand then removes it from the deck ArrayList
	public void addCard(Card card)
	{
		this.hand.add(card);
		//int drawPile = deck.size();
		/*if (playerTurnNum ==1)
		{
			Card transfer = deck.get(drawPile);
			playerNum_1.add(0, transfer);
			deck.remove(0);
			
		}
		else if (playerTurnNum == 2)
		{
			Card transfer = deck.get(drawPile);
			playerNum_2.add(0, transfer);
			deck.remove(0);
		}
		else if (playerTurnNum ==3)
		{
			Card transfer = deck.get(drawPile);
			playerNum_3.add(0, transfer);
			deck.remove(0);
		}
		else if (playerTurnNum == 4)
		{
			Card transfer = deck.get(drawPile);
			playerNum_4.add(0, transfer);
			deck.remove(0);
		}*/
	}

	
	// Takes the card from the player and compares it against the discard pile, if it cant be played it will have to ask the user to play another
	// Unfinished
	public void playCard(Card playedCard)
	{
		
		// If else statements to check is card is playable
		if (playedCard == discardPile.get(0))
		{
			System.out.println("Try another card");
		}
		else
			System.out.println("User Played card");
		
		

	}
	
	// Checks player hand for Oh-No, currently prints to console but will need to allow Oh-No button to be clicked in GUI
	public void ohnoCheck(int playerTurnNum)
	{

		
		if ( playerTurnNum == 1)
		{
			int ohnoCheck = playerNum_1.size();
			if (ohnoCheck == 1) 
			{
				System.out.println("Uno!");
			}
			else if (ohnoCheck != 1)
				System.out.println("Not uno yet");
		}
		else if ( playerTurnNum == 2)
		{
			int ohnoCheck = playerNum_2.size();
			if (ohnoCheck == 1) 
			{
				System.out.println("Uno!");
			}
			else if (ohnoCheck != 1)
				System.out.println("Not uno yet");
		}
		else if ( playerTurnNum == 3)
		{
			int ohnoCheck = playerNum_3.size();
			if (ohnoCheck == 1) 
			{
				System.out.println("Uno!");
			}
			else if (ohnoCheck != 1)
				System.out.println("Not uno yet");
		}
		else if ( playerTurnNum == 4)
		{
			int ohnoCheck = playerNum_4.size();
			if (ohnoCheck == 1) 
			{
				System.out.println("Uno!");
			}
			else if (ohnoCheck != 1)
				System.out.println("Not uno yet");
		}
	}

	


}
