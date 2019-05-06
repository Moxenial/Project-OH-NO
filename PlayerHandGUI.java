import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PlayerHandGUI extends JFrame {

	private static final int WIDTH = 1000;
	private static final int HEIGHT =  800;
	private ArrayList<String> playersHand = new ArrayList<String>();
	private ArrayList<Card> deck;
	private ArrayList<String> deckStr = new ArrayList<String>(deck.size());
	private ArrayList<Card> playPile = new ArrayList<Card>();
	private ArrayList<String> playPileStr = new ArrayList<String>();
	private ArrayList<Card> newHand = new ArrayList<Card>(playersHand.size());

	// Imports card images for buttons
	// Blue Cards
	
	String cardB0 = "C:/Users/Nate/Desktop/cards/b0.png";
	String cardB1 = "C:/Users/Nate/Desktop/cards/b1.png";
	String cardB2 = "C:/Users/Nate/Desktop/cards/b2.png";
	String cardB3 = "C:/Users/Nate/Desktop/cards/b3.png";
	String cardB4 = "C:/Users/Nate/Desktop/cards/b4.png";
	String cardB5 = "C:/Users/Nate/Desktop/cards/b5.png";
	String cardB6 = "C:/Users/Nate/Desktop/cards/b6.png";
	String cardB7 = "C:/Users/Nate/Desktop/cards/b7.png";
	String cardB8 = "C:/Users/Nate/Desktop/cards/b8.png";
	String cardB9 = "C:/Users/Nate/Desktop/cards/b9.png";
	
	// Red Cards
	String cardR0 = "C:/Users/Nate/Desktop/cards/r0.png";
	String cardR1 = "C:/Users/Nate/Desktop/cards/r1.png";
	String cardR2 = "C:/Users/Nate/Desktop/cards/r2.png";
	String cardR3 = "C:/Users/Nate/Desktop/cards/r3.png";
	String cardR4 = "C:/Users/Nate/Desktop/cards/r4.png";
	String cardR5 = "C:/Users/Nate/Desktop/cards/r5.png";
	String cardR6 = "C:/Users/Nate/Desktop/cards/r6.png";
	String cardR7 = "C:/Users/Nate/Desktop/cards/r7.png";
	String cardR8 = "C:/Users/Nate/Desktop/cards/r8.png";
	String cardR9 = "C:/Users/Nate/Desktop/cards/r9.png";
	
	// Green Cards
	String cardG0 = "C:/Users/Nate/Desktop/cards/g0.png";
	String cardG1 = "C:/Users/Nate/Desktop/cards/g1.png";
	String cardG2 = "C:/Users/Nate/Desktop/cards/g2.png";
	String cardG3 = "C:/Users/Nate/Desktop/cards/g3.png";
	String cardG4 = "C:/Users/Nate/Desktop/cards/g4.png";
	String cardG5 = "C:/Users/Nate/Desktop/cards/g5.png";
	String cardG6 = "C:/Users/Nate/Desktop/cards/g6.png";
	String cardG7 = "C:/Users/Nate/Desktop/cards/g7.png";
	String cardG8 = "C:/Users/Nate/Desktop/cards/g8.png";
	String cardG9 = "C:/Users/Nate/Desktop/cards/g9.png";
	
	// Yellow Cards
	String cardY0 = "C:/Users/Nate/Desktop/cards/y0.png";
	String cardY1 = "C:/Users/Nate/Desktop/cards/y1.png";
	String cardY2 = "C:/Users/Nate/Desktop/cards/y2.png";
	String cardY3 = "C:/Users/Nate/Desktop/cards/y3.png";
	String cardY4 = "C:/Users/Nate/Desktop/cards/y4.png";
	String cardY5 = "C:/Users/Nate/Desktop/cards/y5.png";
	String cardY6 = "C:/Users/Nate/Desktop/cards/y6.png";
	String cardY7 = "C:/Users/Nate/Desktop/cards/y7.png";
	String cardY8 = "C:/Users/Nate/Desktop/cards/y8.png";
	String cardY9 = "C:/Users/Nate/Desktop/cards/y9.png";
	
	// Special cards
	String cardB10 = "C:/Users/Nate/Desktop/cards/b10.png";
	String cardB11 = "C:/Users/Nate/Desktop/cards/b11.png";
	String cardB12 = "C:/Users/Nate/Desktop/cards/b12.png";
	String cardR10 = "C:/Users/Nate/Desktop/cards/r10.png";
	String cardR11 = "C:/Users/Nate/Desktop/cards/r11.png";
	String cardR12 = "C:/Users/Nate/Desktop/cards/r12.png";
	String cardG10 = "C:/Users/Nate/Desktop/cards/g10.png";
	String cardG11 = "C:/Users/Nate/Desktop/cards/g11.png";
	String cardG12 = "C:/Users/Nate/Desktop/cards/g12.png";
	String cardY10 = "C:/Users/Nate/Desktop/cards/y10.png";
	String cardY11 = "C:/Users/Nate/Desktop/cards/y11.png";
	String cardY12 = "C:/Users/Nate/Desktop/cards/y12.png";
	String cardX1 = "C:/Users/Nate/Desktop/cards/x1.png";
	String cardX0 = "C:/Users/Nate/Desktop/cards/x0.png";
	
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
	
	public PlayerHandGUI(ArrayList<Card> playersDeck, ArrayList<Card> playersActiveHand)
	{
		
		super("Player Hand");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		
		deck = playersDeck;
		for (Card deck : playersDeck)
		{
			
		}
		// CONVERTS CARD OBJECTS IN DECK TO STRING OBJECTS FOR ADDING CARD BUTTONS
		for (Card objects : playersActiveHand)
		{
			playersHand.add(objects.toString());
		}
		System.out.println("Here is the new string deck" + playersHand);
		
		
		// Main panels
		JPanel mainPanel = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		JPanel btnBarMain = new JPanel();
		
		// Panels within the main
		JPanel playAndDraw = new JPanel();
		JPanel otherPlayers = new JPanel();
		JPanel player1 = new JPanel();
		JPanel player2 = new JPanel();
		JPanel player3 = new JPanel();
		JPanel player4 = new JPanel();
		JPanel cardBar1 = new JPanel();
		JPanel cardBar2 = new JPanel();
		JPanel cardBar3 = new JPanel();
		JPanel cardBar4 = new JPanel();
		JPanel cardBar5 = new JPanel();
		
		// Main btn bar -- switch to close hand later!!!!
		JButton closeHand = new JButton("QUIT GAME");
		closeHand.addActionListener(new QuitListener());
		
		// sets background color for main panels
		mainPanel.setBackground(Color.WHITE);
		leftPanel.setBackground(Color.LIGHT_GRAY);
		rightPanel.setBackground(Color.LIGHT_GRAY);
		btnBarMain.setBackground(Color.DARK_GRAY);
		
		// sets layouts of panels
		mainPanel.setLayout(new GridLayout(1,2));
		leftPanel.setLayout(new GridLayout(2,1));
		rightPanel.setLayout(new GridLayout(5,1));
		btnBarMain.setLayout(new FlowLayout());
		
		// temp must get card and display from board
		playAndDraw.setLayout(new GridLayout(2,2));
		String currentCardPlayed = "C:/Users/Nate/Desktop/cards/x0.png";
		JButton cardSlotPlay = new JButton(new ImageIcon(((new ImageIcon(currentCardPlayed).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		playAndDraw.setBackground(Color.WHITE);
		JLabel playPile = new JLabel("Play Pile");
		playAndDraw.add(playPile);
		playAndDraw.add(cardSlotPlay);
		
		String drawBtnCard = "C:/Users/Nate/Desktop/cards/facedown.png";
		JButton drawBtn = new JButton(new ImageIcon(((new ImageIcon(drawBtnCard).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		drawBtn.addActionListener(new DrawActionListener());
		JLabel drawPile = new JLabel("Draw Pile");
		playAndDraw.add(drawPile);
		playAndDraw.add(drawBtn);
		
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
		
		
		leftPanel.add(playAndDraw);
		leftPanel.add(otherPlayers);

		// Builds the players hand panel
		rightPanel.add(cardBar1);
		rightPanel.add(cardBar2);
		rightPanel.add(cardBar3);
		rightPanel.add(cardBar4);
		rightPanel.add(cardBar5);

		// Creates the first row holding cards on the left side of the player display
		cardBar1.setLayout(new GridLayout(1,9));
		cardBar2.setLayout(new GridLayout(1,9));
		cardBar3.setLayout(new GridLayout(1,9));
		cardBar4.setLayout(new GridLayout(1,9));
		cardBar5.setLayout(new GridLayout(1,14));

		// Add btn to main panel
		btnBarMain.add(closeHand);



		// Adds red cards to players hand
		if (playersHand.contains("Red 0"))
		{
			cardBar2.add(cardSlotr0);
		}
		if (playersHand.contains("Red 1"))
		{
			cardBar2.add(cardSlotr1);
		}
		if (playersHand.contains("Red 2"))
		{
			cardBar2.add(cardSlotr2);
		}
		if (playersHand.contains("Red 3"))
		{
			cardBar2.add(cardSlotr3);
		}
		if (playersHand.contains("Red 4"))
		{
			cardBar2.add(cardSlotr4);
		}
		if (playersHand.contains("Red 5"))
		{
			cardBar2.add(cardSlotr5);
		}
		if (playersHand.contains("Red 6"))
		{
			cardBar2.add(cardSlotr6);
		}
		if (playersHand.contains("Red 7"))
		{
			cardBar2.add(cardSlotr7);
		}
		if (playersHand.contains("Red 8"))
		{
			cardBar2.add(cardSlotr8);
		}
		if (playersHand.contains("Red 9"))
		{
			cardBar2.add(cardSlotr9);
		}
		if (playersHand.contains("Red Skip"))
		{
			cardBar2.add(cardSlotr10);
		}
		if (playersHand.contains("Red Reverse"))
		{
			cardBar2.add(cardSlotr11);
		}
		if (playersHand.contains("Red Draw 2"))
		{
			cardBar2.add(cardSlotr12);
		}
		
		// Adds blue cards to players hand
		if (playersHand.contains("Blue 0"))
		{
			cardBar1.add(cardSlotb0);
		}
		if (playersHand.contains("Blue 1"))
		{
			cardBar1.add(cardSlotb1);
		}
		if (playersHand.contains("Blue 2"))
		{
			cardBar1.add(cardSlotb2);
		}
		if (playersHand.contains("Blue 3"))
		{
			cardBar1.add(cardSlotb3);
		}
		if (playersHand.contains("Blue 4"))
		{
			cardBar1.add(cardSlotb4);
		}
		if (playersHand.contains("Blue 5"))
		{
			cardBar1.add(cardSlotb5);
		}
		if (playersHand.contains("Blue 6"))
		{
			cardBar1.add(cardSlotb6);
		}
		if (playersHand.contains("Blue 7"))
		{
			cardBar1.add(cardSlotb7);
		}
		if (playersHand.contains("Blue 8"))
		{
			cardBar1.add(cardSlotb8);
		}
		if (playersHand.contains("Blue 9"))
		{
			cardBar1.add(cardSlotb9);
		}
		if (playersHand.contains("Blue Skip"))
		{
			cardBar1.add(cardSlotb10);
		}
		if (playersHand.contains("Blue Reverse"))
		{
			cardBar1.add(cardSlotb11);
		}
		if (playersHand.contains("Blue Draw 2"))
		{
			cardBar1.add(cardSlotb12);
		}
		// for adding Green Cards
		if (playersHand.contains("Green 0"))
		{
			cardBar3.add(cardSlotg0);
		}
		if (playersHand.contains("Green 1"))
		{
			cardBar3.add(cardSlotg1);
		}
		if (playersHand.contains("Green 2"))
		{
			cardBar3.add(cardSlotg2);
		}
		if (playersHand.contains("Green 3"))
		{
			cardBar3.add(cardSlotg3);
		}
		if (playersHand.contains("Green 4"))
		{
			cardBar3.add(cardSlotg4);
		}
		if (playersHand.contains("Green 5"))
		{
			cardBar3.add(cardSlotg5);
		}
		if (playersHand.contains("Green 6"))
		{
			cardBar3.add(cardSlotg6);
		}
		if (playersHand.contains("Green 7"))
		{
			cardBar3.add(cardSlotg7);
		}
		if (playersHand.contains("Green 8"))
		{
			cardBar3.add(cardSlotg8);
		}
		if (playersHand.contains("Green 9"))
		{
			cardBar3.add(cardSlotg9);
		}
		if (playersHand.contains("Green Skip"))
		{
			cardBar3.add(cardSlotg10);
		}
		if (playersHand.contains("Green Reverse"))
		{
			cardBar3.add(cardSlotg11);
		}
		if (playersHand.contains("Green Draw 2"))
		{
			cardBar3.add(cardSlotg12);
		}
		
		// for adding yellow cards
		if (playersHand.contains("Yellow 0"))
		{
			cardBar4.add(cardSloty0);
		}
		if (playersHand.contains("Yellow 1"))
		{
			cardBar4.add(cardSloty1);
		}
		if (playersHand.contains("Yellow 2"))
		{
			cardBar4.add(cardSloty2);
		}
		if (playersHand.contains("Yellow 3"))
		{
			cardBar4.add(cardSloty3);
		}
		if (playersHand.contains("Yellow 4"))
		{
			cardBar4.add(cardSloty4);
		}
		if (playersHand.contains("Yellow 5"))
		{
			cardBar4.add(cardSloty5);
		}
		if (playersHand.contains("Yellow 6"))
		{
			cardBar4.add(cardSloty6);
		}
		if (playersHand.contains("Yellow 7"))
		{
			cardBar4.add(cardSloty7);
		}
		if (playersHand.contains("Yellow 8"))
		{
			cardBar4.add(cardSloty8);
		}
		if (playersHand.contains("Yellow 9"))
		{
			cardBar4.add(cardSloty9);
		}
		if (playersHand.contains("Yellow Skip"))
		{
			cardBar4.add(cardSloty10);
		}
		if (playersHand.contains("Yellow Reverse"))
		{
			cardBar4.add(cardSloty11);
		}
		if (playersHand.contains("Yellow Draw 2"))
		{
			cardBar4.add(cardSloty12);
		}
		// Adds Special No Color Cards
		if (playersHand.contains("Wild Card"))
		{
			cardBar5.add(cardSlotx0);
			
		}
		if (playersHand.contains("Wild Draw 4"))
		{
			cardBar5.add(cardSlotx1);
		}
		
		addActionListeners();
		//builds the player hand display
		mainPanel.add(leftPanel);
		mainPanel.add(rightPanel);
		add(btnBarMain, BorderLayout.SOUTH);
		add(mainPanel);
		
	}
	public void addActionListeners()
	{	
		cardSlotb0.addActionListener(new cardPlayedActionListener());
		cardSlotb1.addActionListener(new cardPlayedActionListener());
		cardSlotb2.addActionListener(new cardPlayedActionListener());
		cardSlotb3.addActionListener(new cardPlayedActionListener());
		cardSlotb4.addActionListener(new cardPlayedActionListener());
		cardSlotb5.addActionListener(new cardPlayedActionListener());
		cardSlotb6.addActionListener(new cardPlayedActionListener());
		cardSlotb7.addActionListener(new cardPlayedActionListener());
		cardSlotb8.addActionListener(new cardPlayedActionListener());
		cardSlotb9.addActionListener(new cardPlayedActionListener());
		cardSlotb10.addActionListener(new cardPlayedActionListener());
		cardSlotb11.addActionListener(new cardPlayedActionListener());
		cardSlotb12.addActionListener(new cardPlayedActionListener());
		
		cardSlotr0.addActionListener(new cardPlayedActionListener());
		cardSlotr1.addActionListener(new cardPlayedActionListener());
		cardSlotr2.addActionListener(new cardPlayedActionListener());
		cardSlotr3.addActionListener(new cardPlayedActionListener());
		cardSlotr4.addActionListener(new cardPlayedActionListener());
		cardSlotr5.addActionListener(new cardPlayedActionListener());
		cardSlotr6.addActionListener(new cardPlayedActionListener());
		cardSlotr7.addActionListener(new cardPlayedActionListener());
		cardSlotr8.addActionListener(new cardPlayedActionListener());
		cardSlotr9.addActionListener(new cardPlayedActionListener());
		cardSlotr10.addActionListener(new cardPlayedActionListener());
		cardSlotr11.addActionListener(new cardPlayedActionListener());
		cardSlotr12.addActionListener(new cardPlayedActionListener());
	
		cardSlotg0.addActionListener(new cardPlayedActionListener());
		cardSlotg1.addActionListener(new cardPlayedActionListener());
		cardSlotg2.addActionListener(new cardPlayedActionListener());
		cardSlotg3.addActionListener(new cardPlayedActionListener());
		cardSlotg4.addActionListener(new cardPlayedActionListener());
		cardSlotg5.addActionListener(new cardPlayedActionListener());
		cardSlotg6.addActionListener(new cardPlayedActionListener());
		cardSlotg7.addActionListener(new cardPlayedActionListener());
		cardSlotg8.addActionListener(new cardPlayedActionListener());
		cardSlotg9.addActionListener(new cardPlayedActionListener());
		cardSlotg10.addActionListener(new cardPlayedActionListener());
		cardSlotg11.addActionListener(new cardPlayedActionListener());
		cardSlotg12.addActionListener(new cardPlayedActionListener());
		
		cardSloty0.addActionListener(new cardPlayedActionListener());
		cardSloty1.addActionListener(new cardPlayedActionListener());
		cardSloty2.addActionListener(new cardPlayedActionListener());
		cardSloty3.addActionListener(new cardPlayedActionListener());
		cardSloty4.addActionListener(new cardPlayedActionListener());
		cardSloty5.addActionListener(new cardPlayedActionListener());
		cardSloty6.addActionListener(new cardPlayedActionListener());
		cardSloty7.addActionListener(new cardPlayedActionListener());
		cardSloty8.addActionListener(new cardPlayedActionListener());
		cardSloty9.addActionListener(new cardPlayedActionListener());
		cardSloty10.addActionListener(new cardPlayedActionListener());
		cardSloty11.addActionListener(new cardPlayedActionListener());
		cardSloty12.addActionListener(new cardPlayedActionListener());
		
		cardSlotx1.addActionListener(new cardPlayedActionListener());
		cardSlotx0.addActionListener(new cardPlayedActionListener());
	}

	

	public class cardPlayedActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent p)
		{
			String pick = p.getActionCommand();

			// Only adds string version of card to pile. need to add Card object to hand as well
			playPileStr.add(pick);

			
			

		}
		
	}
	public class DrawActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			boolean flip = false;
			// Adds String Version of card to deck
			newHand.add(deck.get(0));
			playersHand.clear();
			for (Card objects : newHand)
			{
				playersHand.add(objects.toString());
			}

			
			

			
			
			
			
			
		}
	}
	public class QuitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}

	
}
