import java.util.ArrayList;

public class Player {
	
	// Creates an array list for the players hand
	private int numPlayers;
	private ArrayList<Card> deck;
	private ArrayList<Card> discardPile = new ArrayList<Card>(108);
	
	// Player arrayList for each players hand
	private ArrayList<Card> playerNum_1 = new ArrayList<Card>(30);
	private ArrayList<Card> playerNum_2 = new ArrayList<Card>(30);
	private ArrayList<Card> playerNum_3 = new ArrayList<Card>(30);
	private ArrayList<Card> playerNum_4 = new ArrayList<Card>(30);	
	
	public Player(ArrayList<Card> GUIDeck, int GUInumPlayers)
	{
		numPlayers = GUInumPlayers;
		deck = GUIDeck;
		dealHand(GUInumPlayers, GUIDeck);
	}
	
	
	public ArrayList<Card> getDeck()
	{
		return deck;
	}
	public ArrayList<Card> getPlayer1Hand()
	{
		return playerNum_1;
	}
	public ArrayList<Card> getPlayer2Hand()
	{
		return playerNum_2;
	}
	public ArrayList<Card> getPlayer3Hand()
	{
		return playerNum_3;
	}
	public ArrayList<Card> getPlayer4Hand()
	{
		return playerNum_4;
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
	public void deckToHand(int playerTurnNum)
	{
		int drawPile = deck.size();
		if (playerTurnNum ==1)
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
		}

		// Print to console for testing
		System.out.println(playerNum_1);
		System.out.println(deck);
	}
	
	// Alternate to deckToHand() Takes card drawn from pile and the current players number and adds card to players hand
	public void drawCard(Card drawnCard, int playerTurnNum)
	{

		if (playerTurnNum ==1)
		{
			playerNum_1.add(drawnCard);
		}
		else if (playerTurnNum == 2)
		{
			playerNum_2.add(drawnCard);
		}
		else if (playerTurnNum ==3)
		{
			playerNum_3.add(drawnCard);
		}
		else if (playerTurnNum == 4)
		{
			playerNum_4.add(drawnCard);
		}

		// Print to console for testing
		System.out.println(playerNum_1);
		System.out.println(deck);
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
	


	// Displays the players hands for checking cards
	public void getPlayerHand(int playerNum)
	{
		if (playerNum == 2)
		{
			System.out.println(playerNum_1);
			System.out.println(playerNum_2);
		}
		else if (playerNum == 3)
		{
			System.out.println(playerNum_1);
			System.out.println(playerNum_2);
			System.out.println(playerNum_3);
		}
		else if (playerNum == 4)
		{
			System.out.println(playerNum_1);
			System.out.println(playerNum_2);
			System.out.println(playerNum_3);
			System.out.println(playerNum_4);
		}
	}
	

	// Runs the game, will need structure for game operation
	public void gameRunning(int playerNum)
	{
		// temp number of players
		int numOfPlayers = 2;
		
		//Creates Objects of Player and Board to interact for game play
		//Player player = new Player();
		//player.setDeck(deck);
		//System.out.println(deck);
		

		
		
		
		//player.dealHand(numOfPlayers, cards.getDeck());
		//System.out.println("\nThis is where the game starts\n ");
		//player.getPlayerHand(numOfPlayers);
		
		
	}

}
