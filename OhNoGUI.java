import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OhNoGUI extends JFrame {

	// practice gui build #1
		public static final int WIDTH = 600;
		public static final int HEIGHT = 400;
		public static final int ROWS = 3;
		public static final int COLUMNS = 2;

		
		public OhNoGUI()
		{
			super();
			setSize(WIDTH, HEIGHT);
			
			setTitle("Oh-No! UNO for your Computer!");
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
			boardGUI game = new boardGUI();
			game.frame.setVisible(true);
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

	public class RuleBook extends JFrame
	{
		public static final int WIDTH = 600;
		public static final int HEIGHT = 300;
		public RuleBook(){
		
			super();
			setSize(WIDTH, HEIGHT);
			setTitle("Rulebook!");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			setLayout(new BorderLayout());
			
			JPanel rulesPanel = new JPanel();
			JLabel title = new JLabel("Here are the rules for OH-NO!");
			JLabel rule1 = new JLabel("Here is rule 1");
			JLabel rule2 = new JLabel("here is rule 2");
			JLabel rule3 = new JLabel("here is rule 3");
			JLabel rule4 = new JLabel("here is rule 4");
			JLabel rule5 = new JLabel("here is rule 5");
			
			rulesPanel.setLayout(new GridLayout(6, 1));
			rulesPanel.add(title);
			rulesPanel.add(rule1);
			rulesPanel.add(rule2);
			rulesPanel.add(rule3);
			rulesPanel.add(rule4);
			rulesPanel.add(rule5);
			
			add(rulesPanel, BorderLayout.CENTER);

			
			// deal 7 cards per player at start
			// clockwise play starting with left of dealer
			// play card matching color, type or number
			// must declare uno with one card left in hand before playing, otherwise if missed and other player catches, draw 7
			// skips/draw 2/draw 4/reverse
			// Draw 1 and pass or draw until a playable card it obtained for condition of non-playable in hand
		}

	}
	
	public class playerGUI extends JFrame
	{
		public static final int WIDTH = 900;
		public static final int HEIGHT = 500;
		
		public playerGUI()
		{
			super();
			setSize(WIDTH, HEIGHT);
			setTitle("Player Hand!");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			JPanel redCards = new JPanel();
			redCards.setBackground(Color.RED);
			
			JPanel blueCards = new JPanel();
			blueCards.setBackground(Color.BLUE);
			
			JPanel greenCards = new JPanel();
			greenCards.setBackground(Color.GREEN);
			
			JPanel yellowCards = new JPanel();
			yellowCards.setBackground(Color.YELLOW);
			
			// main panel for cards
			JPanel playerCards = new JPanel();
			playerCards.setLayout(new GridLayout(1,4));
			playerCards.setBackground(Color.WHITE);
			
			
			
			
			PracticeArrayListForGUICards playerHand = new PracticeArrayListForGUICards();
			boolean [] cards = playerHand.hasCard();
			
			if (cards[0] == true) 	//add && number to check and display both
			{
				playerCards.add(redCards);
			}
			if (cards[1] == true)
			{
				playerCards.add(blueCards);
			}
			if (cards[2] == true)
			{
				playerCards.add(greenCards);
			}
			if (cards[3] == true)
			{
				playerCards.add(yellowCards);
			}
				
			add(playerCards, BorderLayout.CENTER);
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
			JButton btnPlayCard = new JButton("Play Card");
			ButtonPanel.add(btnPlayCard);
			
			JButton btnDrawCard = new JButton("Draw Card");
			ButtonPanel.add(btnDrawCard);
			
			
			
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
			
			JLabel lblPlayPile = new JLabel("OH-NO");
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
			
			// Action Listener for DrawFunction
			JPanel drawPile_Bottom_panel = new JPanel();
			drawPile_Bottom_panel.setBackground(Color.BLACK);
			row4panel.add(drawPile_Bottom_panel);
			
			JLabel lblDrawPileBottom = new JLabel("OH-NO");
			lblDrawPileBottom.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblDrawPileBottom.setForeground(Color.RED);
			lblDrawPileBottom.setBackground(Color.BLACK);
			drawPile_Bottom_panel.add(lblDrawPileBottom);
			
			
			JButton drawButton = new JButton("Draw Card");
			drawPile_Bottom_panel.add(drawButton);
			Buttons btn = new Buttons();
			btn.execute(drawButton);
			
			

			
			
			
			
			JPanel panel_40 = new JPanel();
			panel_40.setBackground(Color.WHITE);
			row4panel.add(panel_40);
			
			JPanel playPile_Bottom_panel = new JPanel();
			playPile_Bottom_panel.setBackground(Color.GRAY);
			row4panel.add(playPile_Bottom_panel);
			
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
			
			JPanel row5panel = new JPanel();
			row5panel.setBackground(Color.WHITE);
			BoardPanel.add(row5panel);
			
			JPanel row6panel = new JPanel();
			row6panel.setBackground(Color.WHITE);
			BoardPanel.add(row6panel);
			
			JPanel row7panel = new JPanel();
			row7panel.setBackground(Color.WHITE);
			BoardPanel.add(row7panel);
			
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
			panel_20.setBackground(Color.BLUE);
			row8panel.add(panel_20);
			
			JPanel panel_21 = new JPanel();
			panel_21.setBackground(Color.RED);
			row8panel.add(panel_21);
			
			JPanel panel_22 = new JPanel();
			panel_22.setBackground(Color.GREEN);
			row8panel.add(panel_22);
			
			JPanel panel_23 = new JPanel();
			panel_23.setBackground(Color.YELLOW);
			row8panel.add(panel_23);
			
			JPanel panel_24 = new JPanel();
			panel_24.setBackground(Color.DARK_GRAY);
			row8panel.add(panel_24);
			
			JPanel panel_25 = new JPanel();
			panel_25.setBackground(Color.WHITE);
			row8panel.add(panel_25);
			
			JPanel panel_26 = new JPanel();
			panel_26.setBackground(Color.WHITE);
			row8panel.add(panel_26);
			
			JPanel row9panel = new JPanel();
			BoardPanel.add(row9panel);
			row9panel.setLayout(new GridLayout(1, 9, 0, 0));
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			row9panel.add(panel_2);
			
			JPanel panel_10 = new JPanel();
			panel_10.setBackground(Color.WHITE);
			row9panel.add(panel_10);
			// link to draw pile to add buttons on card display
			JPanel panel_11 = new JPanel();
			panel_11.setBackground(Color.BLUE);
			row9panel.add(panel_11);
			
			JPanel panel_12 = new JPanel();
			panel_12.setBackground(Color.RED);
			row9panel.add(panel_12);
			
			JPanel panel_13 = new JPanel();
			panel_13.setBackground(Color.GREEN);
			row9panel.add(panel_13);
			
			JPanel panel_14 = new JPanel();
			panel_14.setBackground(Color.YELLOW);
			row9panel.add(panel_14);
			
			JPanel panel_15 = new JPanel();
			panel_15.setBackground(Color.DARK_GRAY);
			row9panel.add(panel_15);
			
			JPanel panel_16 = new JPanel();
			panel_16.setBackground(Color.WHITE);
			row9panel.add(panel_16);
			
			JPanel panel_17 = new JPanel();
			panel_17.setBackground(Color.WHITE);
			row9panel.add(panel_17);
		}
		

}
}