import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class PlayerHandGUI extends JFrame {

	private static final int WIDTH = 1000;
	private static final int HEIGHT =  800;
	// Testing array list, will use players hand list as an arguement later
	private ArrayList<Card> playersHand;
	//private ArrayList<Card> playerNum_1 = new ArrayList<Card>();
	//private ArrayList<Card> playerNum_2 = new ArrayList<Card>();
	//private ArrayList<Card> playerNum_3 = new ArrayList<Card>();
	//private ArrayList<Card> playerNum_4 = new ArrayList<Card>();
	private ArrayList<Card> deck;
	private ArrayList<Card> compareDeck;
	private ArrayList<Card> discardPile = new ArrayList<Card>();
	

	public void setDeck(ArrayList<Card> deck)
	{
		this.deck = deck;
	}
	public ArrayList<Card> getDeck()
	{
		return deck;
	}
	
	public PlayerHandGUI(ArrayList<Card> playerDeck, ArrayList<Card> playersActiveHand)
	{
		
		super("Player Hand");
		setSize(WIDTH, HEIGHT);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		deck = playerDeck;
		playersHand = playersActiveHand;
		//playerNum_1 = playerNum_1Hand;
		//playerNum_2 = playerNum_2Hand;
		//playerNum_3 = playerNum_3Hand;
		//playerNum_4 = playerNum_4Hand;
		
		// Test functions
		//testList();
		//testPrinter();
		System.out.println(deck);
		System.out.println(playersHand);


		
		
		//System.out.println(playerNum_1);
		//System.out.println(playerNum_2);
		//System.out.println(playerNum_3);
		//System.out.println(playerNum_4);

		// Sort hand later?
		//Collections.sort(playerNum_1);
		
		// Main panels
		JPanel mainPanel = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		JPanel btnBarMain = new JPanel();
		
		// Panels within the main
		JPanel currentCard = new JPanel();
		JPanel otherPlayers = new JPanel();
		JPanel player1 = new JPanel();
		JPanel player2 = new JPanel();
		JPanel player3 = new JPanel();
		JPanel player4 = new JPanel();
		JPanel cardBar1 = new JPanel();
		JPanel cardBtn1 = new JPanel();
		JPanel cardBar2 = new JPanel();
		JPanel cardBtn2 = new JPanel();
		JPanel cardBar3 = new JPanel();
		JPanel cardBtn3 = new JPanel();
		JPanel cardBar4 = new JPanel();
		JPanel cardBtn4 = new JPanel();
		JPanel cardBar5 = new JPanel();
		
		// Main btn bar -- switch to close hand later!!!!
		JButton closeHand = new JButton("QUIT GAME");
		closeHand.addActionListener(new QuitListener());
		// Card buttons
		JPanel playCard1 = new JPanel();
		JPanel playCard2 = new JPanel();
		JPanel playCard3 = new JPanel();
		JPanel playCard4 = new JPanel();
		
		
		// sets background color for main panels
		mainPanel.setBackground(Color.WHITE);
		leftPanel.setBackground(Color.LIGHT_GRAY);
		rightPanel.setBackground(Color.LIGHT_GRAY);
		btnBarMain.setBackground(Color.DARK_GRAY);
		
		// sets layouts of panels
		mainPanel.setLayout(new GridLayout(1,2));
		leftPanel.setLayout(new GridLayout(2,1));
		rightPanel.setLayout(new GridLayout(9,1));
		btnBarMain.setLayout(new FlowLayout());
		
		// temp must get card and display from board
		currentCard.setLayout(new GridLayout(2,2));
		String currentCardPlayed = "C:/Users/sv7424vd/Desktop/cards/x0.png";
		JButton cardSlotPlay = new JButton(new ImageIcon(((new ImageIcon(currentCardPlayed).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		currentCard.setBackground(Color.WHITE);
		JLabel playPile = new JLabel("Play Pile");
		currentCard.add(playPile);
		currentCard.add(cardSlotPlay);
		
		String drawBtnCard = "C:/Users/sv7424vd/Desktop/cards/facedown.png";
		JButton drawBtn = new JButton(new ImageIcon(((new ImageIcon(drawBtnCard).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JLabel drawPile = new JLabel("Draw Pile");
		currentCard.add(drawPile);
		currentCard.add(drawBtn);
		
		// temp must get other players # cards remaining and display
		otherPlayers.setBackground(Color.DARK_GRAY);
		otherPlayers.setLayout(new GridLayout(2,2));
		player1.setBackground(Color.DARK_GRAY);
		player4.setBackground(Color.DARK_GRAY);
		JLabel player1Hand = new JLabel("This will display cards remaining for p1");
		player1Hand.setForeground(Color.WHITE);
		JLabel player2Hand = new JLabel("This will display cards remaining for p2");
		JLabel player3Hand = new JLabel("This will display cards remaining for p3");
		JLabel player4Hand = new JLabel("This will display cards remaining for p4");
		player4Hand.setForeground(Color.WHITE);
		player1.add(player1Hand);
		player2.add(player2Hand);
		player3.add(player3Hand);
		player4.add(player4Hand);
		otherPlayers.add(player1);
		otherPlayers.add(player2);
		otherPlayers.add(player3);
		otherPlayers.add(player4);
		
		
		leftPanel.add(currentCard);
		leftPanel.add(otherPlayers);
		
		
		// Card play buttons
		cardBtn1.add(playCard1);
		cardBtn2.add(playCard2);
		cardBtn3.add(playCard3);
		cardBtn4.add(playCard4);
		
		// Builds the players hand panel
		rightPanel.add(cardBar1);
		rightPanel.add(cardBtn1);
		rightPanel.add(cardBar2);
		rightPanel.add(cardBtn2);
		rightPanel.add(cardBar3);
		rightPanel.add(cardBtn3);
		rightPanel.add(cardBar4);
		rightPanel.add(cardBtn4);
		rightPanel.add(cardBar5);

		
		
		// Imports card images for buttons
		// Blue Cards
		String cardB0 = "C:/Users/Nathan/Desktop/cards/b0.png";
		String cardB1 = "C:/Users/Nathan/Desktop/cards/b1.png";
		String cardB2 = "C:/Users/Nathan/Desktop/cards/b2.png";
		String cardB3 = "C:/Users/Nathan/Desktop/cards/b3.png";
		String cardB4 = "C:/Users/Nathan/Desktop/cards/b4.png";
		String cardB5 = "C:/Users/Nathan/Desktop/cards/b5.png";
		String cardB6 = "C:/Users/Nathan/Desktop/cards/b6.png";
		String cardB7 = "C:/Users/Nathan/Desktop/cards/b7.png";
		String cardB8 = "C:/Users/Nathan/Desktop/cards/b8.png";
		String cardB9 = "C:/Users/Nathan/Desktop/cards/b9.png";
		
		// Red Cards
		String cardR0 = "C:/Users/Nathan/Desktop/cards/r0.png";
		String cardR1 = "C:/Users/Nathan/Desktop/cards/r1.png";
		String cardR2 = "C:/Users/Nathan/Desktop/cards/r2.png";
		String cardR3 = "C:/Users/Nathan/Desktop/cards/r3.png";
		String cardR4 = "C:/Users/Nathan/Desktop/cards/r4.png";
		String cardR5 = "C:/Users/Nathan/Desktop/cards/r5.png";
		String cardR6 = "C:/Users/Nathan/Desktop/cards/r6.png";
		String cardR7 = "C:/Users/Nathan/Desktop/cards/r7.png";
		String cardR8 = "C:/Users/Nathan/Desktop/cards/r8.png";
		String cardR9 = "C:/Users/Nathan/Desktop/cards/r9.png";
		
		// Green Cards
		String cardG0 = "C:/Users/Nathan/Desktop/cards/g0.png";
		String cardG1 = "C:/Users/Nathan/Desktop/cards/g1.png";
		String cardG2 = "C:/Users/Nathan/Desktop/cards/g2.png";
		String cardG3 = "C:/Users/Nathan/Desktop/cards/g3.png";
		String cardG4 = "C:/Users/Nathan/Desktop/cards/g4.png";
		String cardG5 = "C:/Users/Nathan/Desktop/cards/g5.png";
		String cardG6 = "C:/Users/Nathan/Desktop/cards/g6.png";
		String cardG7 = "C:/Users/Nathan/Desktop/cards/g7.png";
		String cardG8 = "C:/Users/Nathan/Desktop/cards/g8.png";
		String cardG9 = "C:/Users/Nathan/Desktop/cards/g9.png";
		
		// Yellow Cards
		String cardY0 = "C:/Users/Nathan/Desktop/cards/y0.png";
		String cardY1 = "C:/Users/Nathan/Desktop/cards/y1.png";
		String cardY2 = "C:/Users/Nathan/Desktop/cards/y2.png";
		String cardY3 = "C:/Users/Nathan/Desktop/cards/y3.png";
		String cardY4 = "C:/Users/Nathan/Desktop/cards/y4.png";
		String cardY5 = "C:/Users/Nathan/Desktop/cards/y5.png";
		String cardY6 = "C:/Users/Nathan/Desktop/cards/y6.png";
		String cardY7 = "C:/Users/Nathan/Desktop/cards/y7.png";
		String cardY8 = "C:/Users/Nathan/Desktop/cards/y8.png";
		String cardY9 = "C:/Users/Nathan/Desktop/cards/y9.png";
		
		// Special cards
		String cardB10 = "C:/Users/Nathan/Desktop/cards/b10.png";
		String cardB11 = "C:/Users/Nathan/Desktop/cards/b11.png";
		String cardB12 = "C:/Users/Nathan/Desktop/cards/b12.png";
		String cardR10 = "C:/Users/Nathan/Desktop/cards/r10.png";
		String cardR11 = "C:/Users/Nathan/Desktop/cards/r11.png";
		String cardR12 = "C:/Users/Nathan/Desktop/cards/r12.png";
		String cardG10 = "C:/Users/Nathan/Desktop/cards/g10.png";
		String cardG11 = "C:/Users/Nathan/Desktop/cards/g11.png";
		String cardG12 = "C:/Users/Nathan/Desktop/cards/g12.png";
		String cardY10 = "C:/Users/Nathan/Desktop/cards/y10.png";
		String cardY11 = "C:/Users/Nathan/Desktop/cards/y11.png";
		String cardY12 = "C:/Users/Nathan/Desktop/cards/y12.png";
		String cardX1 = "C:/Users/Nathan/Desktop/cards/x1.png";
		String cardX0 = "C:/Users/Nathan/Desktop/cards/x0.png";
		
		
		
		// Creates the first row holding cards on the left side of the player display
		cardBar1.setLayout(new GridLayout(1,9));
		cardBar2.setLayout(new GridLayout(1,9));
		cardBar3.setLayout(new GridLayout(1,9));
		cardBar4.setLayout(new GridLayout(1,9));
		cardBar5.setLayout(new GridLayout(1,14));
		
		
		// Creates buttons out of each card from png files
		// Blue Buttons
		JButton cardSlotb0 = new JButton(new ImageIcon(((new ImageIcon(cardB0).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotb1 = new JButton(new ImageIcon(((new ImageIcon(cardB1).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotb2 = new JButton(new ImageIcon(((new ImageIcon(cardB2).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotb3 = new JButton(new ImageIcon(((new ImageIcon(cardB3).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotb4 = new JButton(new ImageIcon(((new ImageIcon(cardB4).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotb5 = new JButton(new ImageIcon(((new ImageIcon(cardB5).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotb6 = new JButton(new ImageIcon(((new ImageIcon(cardB6).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotb7 = new JButton(new ImageIcon(((new ImageIcon(cardB7).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotb8 = new JButton(new ImageIcon(((new ImageIcon(cardB8).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotb9 = new JButton(new ImageIcon(((new ImageIcon(cardB9).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		// Red Buttons
		JButton cardSlotr0 = new JButton(new ImageIcon(((new ImageIcon(cardR0).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotr1 = new JButton(new ImageIcon(((new ImageIcon(cardR1).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotr2 = new JButton(new ImageIcon(((new ImageIcon(cardR2).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotr3 = new JButton(new ImageIcon(((new ImageIcon(cardR3).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotr4 = new JButton(new ImageIcon(((new ImageIcon(cardR4).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotr5 = new JButton(new ImageIcon(((new ImageIcon(cardR5).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotr6 = new JButton(new ImageIcon(((new ImageIcon(cardR6).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotr7 = new JButton(new ImageIcon(((new ImageIcon(cardR7).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotr8 = new JButton(new ImageIcon(((new ImageIcon(cardR8).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotr9 = new JButton(new ImageIcon(((new ImageIcon(cardR9).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		// Green Buttons
		JButton cardSlotg0 = new JButton(new ImageIcon(((new ImageIcon(cardG0).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotg1 = new JButton(new ImageIcon(((new ImageIcon(cardG1).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotg2 = new JButton(new ImageIcon(((new ImageIcon(cardG2).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotg3 = new JButton(new ImageIcon(((new ImageIcon(cardG3).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotg4 = new JButton(new ImageIcon(((new ImageIcon(cardG4).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotg5 = new JButton(new ImageIcon(((new ImageIcon(cardG5).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotg6 = new JButton(new ImageIcon(((new ImageIcon(cardG6).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotg7 = new JButton(new ImageIcon(((new ImageIcon(cardG7).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotg8 = new JButton(new ImageIcon(((new ImageIcon(cardG8).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotg9 = new JButton(new ImageIcon(((new ImageIcon(cardG9).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		// Yellow Buttons
		JButton cardSloty0 = new JButton(new ImageIcon(((new ImageIcon(cardY0).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSloty1 = new JButton(new ImageIcon(((new ImageIcon(cardY1).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSloty2 = new JButton(new ImageIcon(((new ImageIcon(cardY2).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSloty3 = new JButton(new ImageIcon(((new ImageIcon(cardY3).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSloty4 = new JButton(new ImageIcon(((new ImageIcon(cardY4).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSloty5 = new JButton(new ImageIcon(((new ImageIcon(cardY5).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSloty6 = new JButton(new ImageIcon(((new ImageIcon(cardY6).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSloty7 = new JButton(new ImageIcon(((new ImageIcon(cardY7).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSloty8 = new JButton(new ImageIcon(((new ImageIcon(cardY8).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSloty9 = new JButton(new ImageIcon(((new ImageIcon(cardY9).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		// Special Cards
		JButton cardSlotb10 = new JButton(new ImageIcon(((new ImageIcon(cardB10).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotb11 = new JButton(new ImageIcon(((new ImageIcon(cardB11).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotb12 = new JButton(new ImageIcon(((new ImageIcon(cardB12).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotr10 = new JButton(new ImageIcon(((new ImageIcon(cardR10).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotr11 = new JButton(new ImageIcon(((new ImageIcon(cardR11).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotr12 = new JButton(new ImageIcon(((new ImageIcon(cardR12).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotg10 = new JButton(new ImageIcon(((new ImageIcon(cardG10).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotg11 = new JButton(new ImageIcon(((new ImageIcon(cardG11).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotg12 = new JButton(new ImageIcon(((new ImageIcon(cardG12).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSloty10 = new JButton(new ImageIcon(((new ImageIcon(cardY10).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSloty11 = new JButton(new ImageIcon(((new ImageIcon(cardY11).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSloty12 = new JButton(new ImageIcon(((new ImageIcon(cardY12).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotx1 = new JButton(new ImageIcon(((new ImageIcon(cardX1).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlotx0 = new JButton(new ImageIcon(((new ImageIcon(cardX0).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		
		

		// Builds first row of cards
		// Blue card bar
		//cardBar1.add(cardSlotb0);
		//cardBar1.add(cardSlotb1);
		//cardBar1.add(cardSlotb2);
		//cardBar1.add(cardSlotb3);
		//cardBar1.add(cardSlotb4);
		//cardBar1.add(cardSlotb5);
		//cardBar1.add(cardSlotb6);
		cardBar1.add(cardSlotb7);
		cardBar1.add(cardSlotb8);
		cardBar1.add(cardSlotb9);
		// Red card bar
		cardBar2.add(cardSlotr0);
		cardBar2.add(cardSlotr1);
		cardBar2.add(cardSlotr2);
		cardBar2.add(cardSlotr3);
		cardBar2.add(cardSlotr4);
		cardBar2.add(cardSlotr5);
		cardBar2.add(cardSlotr6);
		cardBar2.add(cardSlotr7);
		cardBar2.add(cardSlotr8);
		cardBar2.add(cardSlotr9);
		// Green card bar
		cardBar3.add(cardSlotg0);
		cardBar3.add(cardSlotg1);
		cardBar3.add(cardSlotg2);
		cardBar3.add(cardSlotg3);
		cardBar3.add(cardSlotg4);
		cardBar3.add(cardSlotg5);
		cardBar3.add(cardSlotg6);
		cardBar3.add(cardSlotg7);
		cardBar3.add(cardSlotg8);
		cardBar3.add(cardSlotg9);
		// Yellow card bar
		cardBar4.add(cardSloty0);
		cardBar4.add(cardSloty1);
		cardBar4.add(cardSloty2);
		cardBar4.add(cardSloty3);
		cardBar4.add(cardSloty4);
		cardBar4.add(cardSloty5);
		cardBar4.add(cardSloty6);
		cardBar4.add(cardSloty7);
		cardBar4.add(cardSloty8);
		cardBar4.add(cardSloty9);
		// Special card bar
		cardBar5.add(cardSlotb10);
		cardBar5.add(cardSlotb11);
		cardBar5.add(cardSlotb12);
		cardBar5.add(cardSlotr10);
		cardBar5.add(cardSlotr11);
		cardBar5.add(cardSlotr12);
		cardBar5.add(cardSlotg10);
		cardBar5.add(cardSlotg11);
		cardBar5.add(cardSlotg12);
		cardBar5.add(cardSloty10);
		cardBar5.add(cardSloty11);
		cardBar5.add(cardSloty12);
		cardBar5.add(cardSlotx1);
		cardBar5.add(cardSlotx0);


		// Add btn to main panel
		btnBarMain.add(closeHand);
		
		Card card1 = playersHand.get(0);
		System.out.println(card1);
		Board comparison = new Board();
		comparison.generateComparisonDeck();
		compareDeck = comparison.getCompDeck();
		System.out.println(compareDeck);
		
		for (int i = 0; i < 7; i++)
		{
			System.out.println(playersHand.get(i));
		}
		
		// Test
		int testHandSize = 7;
		for (int i = 0; i < testHandSize; i++)
		{
			if (playersHand.get(i) == compareDeck.get(82) )
			{
				cardBar1.add(cardSlotb0);
			}
		}
		for (int i = 0; i < testHandSize; i++)
		{
			if (playersHand.get(i) == compareDeck.get(83) )
			{
				cardBar1.add(cardSlotb1);
			}
		}
		for (int i = 0; i < testHandSize; i++)
		{
			if (playersHand.get(i) == compareDeck.get(85) )
			{
				cardBar1.add(cardSlotb2);
			}
		}
		for (int i = 0; i < testHandSize; i++)
		{
			if (playersHand.get(i) == compareDeck.get(87) )
			{
				cardBar1.add(cardSlotb3);
			}
		}
		for (int i = 0; i < testHandSize; i++)
		{
			if (playersHand.get(i) == compareDeck.get(89) )
			{
				cardBar1.add(cardSlotb4);
			}
		}
		for (int i = 0; i < testHandSize; i++)
		{
			if (playersHand.get(i) == compareDeck.get(91) )
			{
				cardBar1.add(cardSlotb5);
			}
		}
		for (int i = 0; i < testHandSize; i++)
		{
			if (playersHand.get(i) == compareDeck.get(83) )
			{
				cardBar1.add(cardSlotb6);
			}
		}
		
		
		//builds the player hand display
		mainPanel.add(leftPanel);
		mainPanel.add(rightPanel);
		add(btnBarMain, BorderLayout.SOUTH);
		add(mainPanel);
		
	}

	
	public class QuitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
}
