import java.util.ArrayList;

public class Player {
	
	// Creates an array list for the players hand
	
	private ArrayList<Card> deck;
	private ArrayList<Card> discardPile = new ArrayList<Card>(108);
	
	// Player arrayList for each players hand
	private ArrayList<Card> playerNum_1 = new ArrayList<Card>(30);
	private ArrayList<Card> playerNum_2 = new ArrayList<Card>(30);
	private ArrayList<Card> playerNum_3 = new ArrayList<Card>(30);
	private ArrayList<Card> playerNum_4 = new ArrayList<Card>(30);	
	


	// Arguements dealHand(ArrayList<Card> deck)
	public void dealHand(int playerNumber, ArrayList<Card> deck)
	{
		int NUM_PLAYERS = playerNumber;
		int FIRST_DEAL = 7;
		int DECK_SIZE = 108;
		
		// Deals cards to players from playerNumber
		if (NUM_PLAYERS == 2)
		{
			int topCard = DECK_SIZE-1;
			

			for (int i = 0; i < FIRST_DEAL; i++)
			{

				Card transferCard = deck.get(topCard);
				topCard = topCard -1;
				playerNum_1.add(transferCard);
				

				Card transferCard2 = deck.get(topCard);
				topCard = topCard -1;
				playerNum_2.add(transferCard2);
				


			}

		}
		else if (NUM_PLAYERS == 3)
		{
			for (int i = 0; i < FIRST_DEAL; i++)
			{
				//playerNum_1.add("Player # 1 Hand");
				//playerNum_2.add("Player # 2 Hand");
				//playerNum_3.add("Player # 4 Hand");
			}
		}
		else if (NUM_PLAYERS == 4)
		{
			for (int i = 0; i < FIRST_DEAL; i++)
			{
				//playerNum_1.add("Player # 1 Hand");
				//playerNum_2.add("Player # 2 Hand");
				//playerNum_3.add("Player # 3 Hand");
				//playerNum_4.add("Player # 4 Hand");
			}
		}
		else
			System.out.println("Player Count Exception");

		
		
	}
	
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
	


	
	public void getPlayerHand(int playerNum)
	{
		if (playerNum == 2)
		{
			for(Card playerHand1 : playerNum_1)
				System.out.println(playerHand1);
			for(Card playerHand2 : playerNum_2)
				System.out.println(playerHand2);
		}
		else if (playerNum == 3)
		{
			for(Card playerHand1 : playerNum_1)
				System.out.println(playerHand1);
			for(Card playerHand2 : playerNum_2)
				System.out.println(playerHand2);
			for(Card playerHand3 : playerNum_3)
				System.out.println(playerHand3);
		}
		else if (playerNum == 4)
		{
			for(Card playerHand1 : playerNum_1)
				System.out.println(playerHand1);
			for(Card playerHand2 : playerNum_2)
				System.out.println(playerHand2);
			for(Card playerHand3 : playerNum_3)
				System.out.println(playerHand3);
			for(Card playerHand4 : playerNum_4)
				System.out.println(playerHand4);
		}
	}
	public void gameRunning(int playerNum)
	{
		// Start
		// Get total players
		// First Player goes first...duhhh
		int firstPlayer = 1;
		
		//Creates Objects of Player and Board to interact for game play
		Player game = new Player();
		Board cards = new Board();
		
		// Need to connect to GUI
		int totalPlayers = playerNum;
		
		cards.generateStandardDeck();
		
		game.dealHand(totalPlayers, cards.getDeck());
		System.out.println("\nThis is where the game starts\n ");
		game.getPlayerHand(totalPlayers);
		
		
		
		
		
	}

}
