import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class OhNoGUI extends JFrame implements DefaultRules{


	private boolean turnFinished;
	private boolean isPlayOrderClockwise;
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 400;
	public static final int ROWS = 3;
	public static final int COLUMNS = 2;
	private JTextField playerCountEntry = new JTextField(3);
	private int numPlayers;
	private int currentPlayer;
	private Board board;
	//private ArrayList<Card> deck = new ArrayList<Card>();
	private ArrayList<Card> playPile = new ArrayList<Card>();
	
	private ArrayList<Player> player = new ArrayList<Player>();
	
	// This should be to build the start of the game, who goes first,
	// deal out a hand, get everyone hands and set  the first play card.
	// Thinking the arraylists need to be able to be static referenced through the different class
	// for consisitencey.
	
	public void initialDealing() {
		player.clear();
		if(numPlayers == 2) {
			player.add(new Player(1));
			player.add(new Player(2));
			for(int x = 0; x < STARTINGHAND; ++x) {
				player.get(0).addCard(board.drawCard());
				player.get(1).addCard(board.drawCard());
			}
		}
		else if(numPlayers == 3) {

			player.add(new Player(1));
			player.add(new Player(2));
			player.add(new Player(3));
			for(int x = 0; x < STARTINGHAND; ++x) {
				player.get(0).addCard(board.drawCard());
				player.get(1).addCard(board.drawCard());
				player.get(2).addCard(board.drawCard());
			}
		}
		else if(numPlayers == 4) {

			player.add(new Player(1));
			player.add(new Player(2));
			player.add(new Player(3));
			player.add(new Player(4));
			for(int x = 0; x < STARTINGHAND; ++x) {
				player.get(0).addCard(board.drawCard());
				player.get(1).addCard(board.drawCard());
				player.get(2).addCard(board.drawCard());
				player.get(3).addCard(board.drawCard());
			}
		}
		System.out.println("Player ArrayList size: " + player.size());
	}
	
	
	public void drawCard() {
		
		player.get(currentPlayer - 1).addCard(board.drawCard());
		
	}
	
	public void playCard(Card playedCard) {
		if(playedCard.getColor() == 0 && playedCard.getValue() == 0)
			wildRules();
		if(playedCard.getColor() == 0 && playedCard.getValue() == 0)
			wildDraw4Rules();
	}

	private void wildRules() {
		// TODO Auto-generated method stub
		int c = (int) (Math.random() * 4);
		if(c == 0) {
			board.getTopCard();
		}
	}
	private void wildDraw4Rules() {
		// TODO Auto-generated method stub
		// maybe for time's sake, make it randomly select a color
		
	}
	private void skipRules() {
		// TODO Auto-generated method stub
		// maybe for time's sake, make it randomly select a color
	}
	private void draw2Rules() {
		// TODO Auto-generated method stub
		// maybe for time's sake, make it randomly select a color
	}
	private void reverseRules() {
		
		// TODO Auto-generated method stub
		// maybe for time's sake, make it randomly select a color
	}


	// if reverse is played set boolean isPlayOrder Clockwise to false
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
	public void gameBuilder()
	{
		currentPlayer = 1;
		
		board = new Board();
		board.addToPile(board.drawCard());
		System.out.println("Deck size is: " + board.getDeck().size());
		System.out.println("Top card: " + board.getTopCard().toString());
		initialDealing();
		
		//update GUI with top card
		

	}
	
	//maybe delete
	public void gameRunning()
	{
		// get the first player
		currentPlayer = 1;
		// Show current players number in the BOARD GUI
		// gets initial card for play pile
		
		

		// player goes
		
		//updateBoard();
		// add players played card to play pile
		
		// How do we update the decks of each player
		
		
	}
	
	public OhNoGUI()
		{
			super();
			setSize(WIDTH, HEIGHT);
			
			setTitle("OH-NO: UNO for your Computer!");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			setLayout(new BorderLayout());
			
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new FlowLayout());
			
			// Button to start the game
			JButton playButton = new JButton("Play Game");
			playButton.addActionListener(new OhNoPlayListener());
			buttonPanel.add(playButton);
			
			// Button to bring up rules
			JButton rulesButton = new JButton("View Rules");
			rulesButton.addActionListener(new OhNoRulesListener());
			buttonPanel.add(rulesButton);
			
			// Button to quit out of GUI/Game
			JButton exitButton = new JButton("Quit Game");
			exitButton.addActionListener(new OhNoQuitListener());
			buttonPanel.add(exitButton);
			
			add(buttonPanel, BorderLayout.SOUTH);
			
			// Card Display Home Menu

			JPanel homeDisplay = new JPanel();
			homeDisplay.setLayout(new GridLayout(1,4));
			
			
			// blue background and O***
			JPanel blueCard = new JPanel();
			blueCard.setBackground(Color.BLUE);
			homeDisplay.add(blueCard);
			JLabel lblO = new JLabel("O");
			lblO.setHorizontalAlignment(SwingConstants.CENTER);
			lblO.setForeground(Color.WHITE);
			lblO.setFont(new Font("Arial Black", Font.BOLD, 40));
			blueCard.add(lblO);
			
			// green background and *H**
			JPanel greenCard = new JPanel();
			greenCard.setBackground(Color.GREEN);
			homeDisplay.add(greenCard);
			JLabel lblH = new JLabel("H");
			lblH.setHorizontalAlignment(SwingConstants.CENTER);
			lblH.setForeground(Color.BLACK);
			lblH.setFont(new Font("Arial Black", Font.BOLD, 40));
			greenCard.add(lblH);
			
			
			// yellow background and **N*
			JPanel yellowCard = new JPanel();
			yellowCard.setBackground(Color.YELLOW);
			homeDisplay.add(yellowCard);
			JLabel lblN = new JLabel("N");
			lblN.setHorizontalAlignment(SwingConstants.CENTER);
			lblN.setForeground(Color.BLACK);
			lblN.setFont(new Font("Arial Black", Font.BOLD, 40));
			yellowCard.add(lblN);
			
			
			// red background and ***O
			JPanel redCard = new JPanel();
			redCard.setBackground(Color.RED);
			homeDisplay.add(redCard);
			JLabel lblO2 = new JLabel("O");
			lblO2.setHorizontalAlignment(SwingConstants.CENTER);
			lblO2.setForeground(Color.WHITE);
			lblO2.setFont(new Font("Arial Black", Font.BOLD, 40));
			redCard.add(lblO2);
			
			
			
			add(homeDisplay, BorderLayout.CENTER);
			
			JPanel topBar = new JPanel();
			topBar.setLayout(new GridLayout(1,1));
			topBar.setBackground(Color.WHITE);
			JPanel whiteCard = new JPanel();
			JLabel welcome = new JLabel("Welcome to Oh-No, UNO for your Computer!");
			topBar.add(welcome);
			topBar.add(whiteCard);
			add(topBar, BorderLayout.NORTH);
			
			
			
			
	}

	public class playerCount extends JFrame
	{
		private static final int WIDTH = 500;
		private static final int HEIGHT = 300;
		private JPanel playerMain = new JPanel();
		private JLabel header = new JLabel("How many people will be playing? 2-4 Players");
		private JButton enterPlayer = new JButton("Play");
		
		playerCount()
		{
			super("How many players?");
			setSize(WIDTH, HEIGHT);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			setLayout(new BorderLayout());
			
			header.setFont(new Font("Tahoma", Font.BOLD, 20));
			playerMain.add(header, BorderLayout.NORTH);
			playerMain.add(playerCountEntry, BorderLayout.CENTER);
			playerMain.add(enterPlayer, BorderLayout.SOUTH);
			enterPlayer.addActionListener(new EnterPlayerListener());
			
			// needs to send number of players to other parts of the program

			//numPlayers holds number of players;
			add(playerMain);
		}
	}

	public class RuleBook extends JFrame
	{
		public static final int WIDTH = 900;
		public static final int HEIGHT = 600;
		public RuleBook(){
		
			super();
			setSize(WIDTH, HEIGHT);
			setTitle("Rulebook!");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			setLayout(new BorderLayout());
			
			JPanel rulesPanel = new JPanel();
			rulesPanel.setBackground(Color.LIGHT_GRAY);
			JLabel title = new JLabel("Here are the rules for OH-NO!");
			JLabel rule1 = new JLabel("1. Each player will be dealt 7 cards at start");
			JLabel rule2 = new JLabel("2. Starting card will be flipped from the top of the Draw Pile and placed face up on the Discard Pile");
			JLabel rule3 = new JLabel("3. Player to the left of the dealer will go first");
			JLabel rule4 = new JLabel("4. Cards to be played must be of matching color, number or you can play a Wild/Draw4 card");
			JLabel rule5 = new JLabel("5. If no card can be played, player must draw from the Draw Pile");
			JLabel rule6 = new JLabel("6. When a player has only one card left they must call Oh-No prior to playing their last card");
			JLabel rule7 = new JLabel("7. If the player does not call Oh-No and another player calls them on it, they must draw 7 cards from the Draw Pile");
			JLabel rule8 = new JLabel("8. Special Cards: Draw +2 causes the next player to Draw 2 cards from the Draw Pile. Skip Cards cause the next player to be skipped. Draw 4 Cards cause the next player to draw 4 cards and the player who played the Draw 4 chooses the color to be played");
			
			
			rulesPanel.setLayout(new GridLayout(9, 1));
			rulesPanel.add(title);
			rulesPanel.add(rule1);
			rulesPanel.add(rule2);
			rulesPanel.add(rule3);
			rulesPanel.add(rule4);
			rulesPanel.add(rule5);
			rulesPanel.add(rule6);
			rulesPanel.add(rule7);
			rulesPanel.add(rule8);
			
			add(rulesPanel, BorderLayout.CENTER);

			
			// deal 7 cards per player at start
			// clockwise play starting with left of dealer
			// play card matching color, type or number
			// must declare uno with one card left in hand before playing, otherwise if missed and other player catches, draw 7
			// skips/draw 2/draw 4/reverse
			// Draw 1 and pass or draw until a playable card it obtained for condition of non-playable in hand
		}

	}
	
	public class boardGUI extends JFrame
	{
		private static final int WIDTH = 1200;
		private static final int HEIGHT = 900;
		private JFrame frame;
		public boardGUI()
		{
			playGame();
		}
		
		public void playGame()
		{
			
			frame = new JFrame();
			frame.setBounds(100, 100, 1500, 900);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			JPanel ButtonPanel = new JPanel();
			ButtonPanel.setBackground(Color.DARK_GRAY);
			frame.getContentPane().add(ButtonPanel, BorderLayout.SOUTH);
			
			// Player GUI Buttons
			JButton btnNewGame = new JButton("New Game");
			btnNewGame.addActionListener(new OhNoPlayListener());
			ButtonPanel.add(btnNewGame);
			
			JButton btnQuitGame = new JButton("Quit Game");
			btnQuitGame.addActionListener(new OhNoQuitListener());
			ButtonPanel.add(btnQuitGame);
			
			JPanel BoardPanel = new JPanel();
			frame.getContentPane().add(BoardPanel, BorderLayout.CENTER);
			BoardPanel.setLayout(new GridLayout(9, 1, 0, 0));
			
			JPanel row1panel = new JPanel();
			BoardPanel.add(row1panel);
			row1panel.setLayout(new GridLayout(0, 9, 0, 0));
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			row1panel.add(panel);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			row1panel.add(panel_1);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(Color.BLACK);
			row1panel.add(panel_3);

			
			JLabel lblOhno = new JLabel("OH-NO");
			lblOhno.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblOhno.setForeground(Color.RED);
			lblOhno.setBackground(Color.BLACK);
			panel_3.add(lblOhno);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBackground(Color.BLACK);
			row1panel.add(panel_4);
			
			JLabel lblOhno_1 = new JLabel("OH-NO");
			lblOhno_1.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblOhno_1.setForeground(Color.RED);
			lblOhno_1.setBackground(Color.BLACK);
			panel_4.add(lblOhno_1);
			
			JPanel panel_5 = new JPanel();
			panel_5.setBackground(Color.BLACK);
			row1panel.add(panel_5);
			
			JLabel lblOhno_2 = new JLabel("OH-NO");
			lblOhno_2.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblOhno_2.setForeground(Color.RED);
			lblOhno_2.setBackground(Color.BLACK);
			panel_5.add(lblOhno_2);
			
			JPanel panel_6 = new JPanel();
			panel_6.setBackground(Color.BLACK);
			row1panel.add(panel_6);
			
			JLabel lblOhno_3 = new JLabel("OH-NO");
			lblOhno_3.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblOhno_3.setForeground(Color.RED);
			lblOhno_3.setBackground(Color.BLACK);
			panel_6.add(lblOhno_3);
			
			JPanel panel_7 = new JPanel();
			panel_7.setBackground(Color.BLACK);
			row1panel.add(panel_7);
			
			JLabel lblOhno_4 = new JLabel("OH-NO");
			lblOhno_4.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblOhno_4.setForeground(Color.RED);
			lblOhno_4.setBackground(Color.BLACK);
			panel_7.add(lblOhno_4);
			
			
			
			JPanel panel_8 = new JPanel();
			panel_8.setBackground(Color.WHITE);
			row1panel.add(panel_8);
			
			JPanel panel_9 = new JPanel();
			panel_9.setBackground(Color.WHITE);
			row1panel.add(panel_9);
			
			JPanel row2panel = new JPanel();
			row2panel.setBackground(Color.WHITE);
			BoardPanel.add(row2panel);
			
			JPanel row3panel = new JPanel();
			BoardPanel.add(row3panel);
			row3panel.setLayout(new GridLayout(0, 9, 0, 0));
			
			JPanel panel_27 = new JPanel();
			panel_27.setBackground(Color.WHITE);
			row3panel.add(panel_27);
			
			JPanel panel_28 = new JPanel();
			panel_28.setBackground(Color.WHITE);
			row3panel.add(panel_28);
			
			JPanel panel_29 = new JPanel();
			panel_29.setBackground(Color.WHITE);
			row3panel.add(panel_29);
			
			JPanel drawPile_Upper_panel = new JPanel();
			drawPile_Upper_panel.setBackground(Color.BLACK);
			row3panel.add(drawPile_Upper_panel);
			
			JLabel lblDrawPile = new JLabel("OH-NO");
			lblDrawPile.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblDrawPile.setForeground(Color.RED);
			lblDrawPile.setBackground(Color.BLACK);
			drawPile_Upper_panel.add(lblDrawPile);
			
			JPanel panel_31 = new JPanel();
			panel_31.setBackground(Color.WHITE);
			row3panel.add(panel_31);
			
			JPanel playPile_Upper_panel = new JPanel();
			playPile_Upper_panel.setBackground(Color.GRAY);
			row3panel.add(playPile_Upper_panel);
			
			JLabel lblPlayPile = new JLabel("Play Pile");
			lblPlayPile.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblPlayPile.setForeground(Color.RED);
			lblPlayPile.setBackground(Color.BLACK);
			playPile_Upper_panel.add(lblPlayPile);
			
			JPanel panel_33 = new JPanel();
			panel_33.setBackground(Color.WHITE);
			row3panel.add(panel_33);
			
			JPanel panel_34 = new JPanel();
			panel_34.setBackground(Color.WHITE);
			row3panel.add(panel_34);
			
			JPanel panel_35 = new JPanel();
			panel_35.setBackground(Color.WHITE);
			row3panel.add(panel_35);
			
			JPanel row4panel = new JPanel();
			BoardPanel.add(row4panel);
			row4panel.setLayout(new GridLayout(0, 9, 0, 0));
			
			JPanel panel_36 = new JPanel();
			panel_36.setBackground(Color.WHITE);
			row4panel.add(panel_36);
			
			JPanel panel_37 = new JPanel();
			panel_37.setBackground(Color.WHITE);
			row4panel.add(panel_37);
			
			JPanel panel_38 = new JPanel();
			panel_38.setBackground(Color.WHITE);
			row4panel.add(panel_38);
			
			JPanel drawPile_Bottom_panel = new JPanel();
			drawPile_Bottom_panel.setBackground(Color.BLACK);
			row4panel.add(drawPile_Bottom_panel);
			
			JLabel lblDrawPileBottom = new JLabel("OH-NO");
			lblDrawPileBottom.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblDrawPileBottom.setForeground(Color.RED);
			lblDrawPileBottom.setBackground(Color.BLACK);
			drawPile_Bottom_panel.add(lblDrawPileBottom);
				
			
			JPanel panel_40 = new JPanel();
			panel_40.setBackground(Color.WHITE);
			row4panel.add(panel_40);
			
			JPanel playPile_Bottom_panel = new JPanel();
			playPile_Bottom_panel.setBackground(Color.GRAY);
			row4panel.add(playPile_Bottom_panel);
			
			// Change to add current card to play pile with image
			JLabel lblPlayPileBottom = new JLabel("OH-NO");
			lblPlayPileBottom.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblPlayPileBottom.setForeground(Color.RED);
			lblPlayPileBottom.setBackground(Color.BLACK);
			playPile_Bottom_panel.add(lblPlayPileBottom);
			
			
			JPanel panel_42 = new JPanel();
			panel_42.setBackground(Color.WHITE);
			row4panel.add(panel_42);
			
			JPanel panel_43 = new JPanel();
			panel_43.setBackground(Color.WHITE);
			row4panel.add(panel_43);
			
			JPanel panel_44 = new JPanel();
			panel_44.setBackground(Color.WHITE);
			row4panel.add(panel_44);
			
			
			
			// Label for next Player
			JPanel row5panel = new JPanel();
			row5panel.setBackground(Color.DARK_GRAY);
			JLabel playerTurnLbl = new JLabel("Player # goes: ");
			row5panel.add(playerTurnLbl);
			BoardPanel.add(row5panel);
			
			
			// Display player Number
			JPanel row6panel = new JPanel();
			row6panel.setBackground(Color.LIGHT_GRAY);
			// Change to text area later
			JLabel playerNumLbl = new JLabel("1,2,3,4");
			row6panel.add(playerNumLbl);
			BoardPanel.add(row6panel);
			
			
			
			
			
			
			JPanel row7panel = new JPanel();
			row7panel.setBackground(Color.WHITE);
			BoardPanel.add(row7panel);
			
			// Blank row
			JPanel row8panel = new JPanel();
			BoardPanel.add(row8panel);
			row8panel.setLayout(new GridLayout(1, 9, 0, 0));
			
			
			
			
			
			JPanel panel_18 = new JPanel();
			panel_18.setBackground(Color.WHITE);
			row8panel.add(panel_18);
			
			JPanel panel_19 = new JPanel();
			panel_19.setBackground(Color.WHITE);
			row8panel.add(panel_19);
			
			JPanel panel_20 = new JPanel();
			panel_20.setBackground(Color.WHITE);
			row8panel.add(panel_20);
			
			JPanel panel_21 = new JPanel();
			panel_21.setBackground(Color.WHITE);
			row8panel.add(panel_21);
			
			JPanel panel_22 = new JPanel();
			panel_22.setBackground(Color.WHITE);
			row8panel.add(panel_22);
			
			JPanel panel_23 = new JPanel();
			panel_23.setBackground(Color.WHITE);
			row8panel.add(panel_23);
			
			JPanel panel_24 = new JPanel();
			panel_24.setBackground(Color.WHITE);
			row8panel.add(panel_24);
			
			JPanel panel_25 = new JPanel();
			panel_25.setBackground(Color.WHITE);
			row8panel.add(panel_25);
			
			JPanel panel_26 = new JPanel();
			panel_26.setBackground(Color.WHITE);
			row8panel.add(panel_26);
			
			
			// Bottom Row with buttons for players
			JPanel bottomPanel = new JPanel();
			BoardPanel.add(bottomPanel);
			bottomPanel.setLayout(new GridLayout(1, 8, 0, 0));
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			bottomPanel.add(panel_2);
			
			JPanel panel_10 = new JPanel();
			panel_10.setBackground(Color.WHITE);
			bottomPanel.add(panel_10);
			
			
			// Player selection cards/buttons to open player GUI
			JPanel player1 = new JPanel();
			player1.setBackground(Color.LIGHT_GRAY);
			bottomPanel.add(player1);
			JButton player1btn = new JButton("Player 1's Hand");
			player1btn.addActionListener(new playerHand());
			player1.add(player1btn);
			
			JPanel player2 = new JPanel();
			player2.setBackground(Color.DARK_GRAY);
			bottomPanel.add(player2);
			JButton player2btn = new JButton("Player 2's Hand");
			//player2btn.addActionListener(new OhNoPlayerHand());
			player2btn.addActionListener(new playerHand());
			player2.add(player2btn);
			
			JPanel player3 = new JPanel();
			player3.setBackground(Color.LIGHT_GRAY);
			bottomPanel.add(player3);
			JButton player3btn = new JButton("Player 3's Hand");
			//player3btn.addActionListener(new OhNoPlayerHand());
			player3btn.addActionListener(new playerHand());
			player3.add(player3btn);
			
			JPanel player4 = new JPanel();
			player4.setBackground(Color.DARK_GRAY);
			bottomPanel.add(player4);
			JButton player4btn = new JButton("Player 4's Hand");
			//player4btn.addActionListener(new OhNoPlayerHand());
			player4btn.addActionListener(new playerHand());
			player4.add(player4btn);

			JPanel panel_15 = new JPanel();
			panel_15.setBackground(Color.WHITE);
			bottomPanel.add(panel_15);
			
			JPanel panel_16 = new JPanel();
			panel_16.setBackground(Color.WHITE);
			bottomPanel.add(panel_16);
			
		}
		

}

	public class playerHand implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	/*	
			String playerChoice = e.getActionCommand();
			if (playerChoice == "Player 1's Hand")
			{
			PlayerHandGUI playerHand1 = new PlayerHandGUI(deck, player.get(0).getHand());
			playerHand1.setVisible(true);
			}
			else if (playerChoice == "Player 2's Hand")
			{
				PlayerHandGUI playerHand2 = new PlayerHandGUI(deck, player.get(1).getHand());
				playerHand2.setVisible(true);
			}
			else if (playerChoice == "Player 3's Hand")
			{
				if(numPlayers == 3)
				{
					PlayerHandGUI playerHand3 = new PlayerHandGUI(deck, player.get(2).getHand());
					playerHand3.setVisible(true);
				}
			}
			else if (playerChoice == "Player 4's Hand")
			{
				if(numPlayers == 4)
				{
					PlayerHandGUI playerHand4 = new PlayerHandGUI(deck, player.get(3).getHand());
					playerHand4.setVisible(true);
				}
			}
		*/
		}
	}

	public class EnterPlayerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int numOfPlayers = 0;
			String userStr = playerCountEntry.getText();
			if(Integer.parseInt(userStr) >= 2 && Integer.parseInt(userStr) <= 4)
			{
				numOfPlayers = Integer.parseInt(userStr);
				numPlayers = numOfPlayers;
				
				System.out.println("NumPlayers: " + numPlayers);
				
				gameBuilder();
				// Sets boardGUi to visible
				boardGUI game = new boardGUI();
				game.frame.setVisible(true);
			}
		}
	}

	public class OhNoQuitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	public class OhNoPlayListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			playerCount players = new playerCount();
			players.setVisible(true);
		}
	}
	public class OhNoRulesListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// Goes to rulebook
			RuleBook ruleDisplay = new RuleBook();
			ruleDisplay.setVisible(true);
		}
	}
}
