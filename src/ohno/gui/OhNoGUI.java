package ohno.gui;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.event.ListDataListener;

import ohno.core.Board;
import ohno.core.Card;
import ohno.core.DefaultRules;
import ohno.core.Player;

import java.util.ArrayList;

public class OhNoGUI extends JFrame implements DefaultRules {

	private boolean turnFinished;
	private boolean cardDrawn;
	private boolean isPlayOrderClockwise;
	private boolean ohnoDeclared;

	public static final int WIDTH = 600;
	public static final int HEIGHT = 400;
	public static final int ROWS = 3;
	public static final int COLUMNS = 2;
	private int cardsForNextPlayer;
	private int timesToSkip;
	private int numPlayers;
	private int currentPlayer;
	private Board board;

	private ArrayList<Player> player = new ArrayList<Player>();

	JComboBox playerCount;

	public OhNoGUI() {
		super();
		setSize(WIDTH, HEIGHT);

		setTitle("OH-NO: UNO for your Computer!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		JLabel playerCountLabel = new JLabel("Number of Players");
		String[] playerCountChoices = { "2", "3", "4" };
		playerCount = new JComboBox(playerCountChoices);
		buttonPanel.add(playerCountLabel);
		buttonPanel.add(playerCount);

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
		homeDisplay.setLayout(new GridLayout(1, 4));

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
		topBar.setLayout(new GridLayout(1, 1));
		topBar.setBackground(Color.WHITE);
		JPanel whiteCard = new JPanel();
		JLabel welcome = new JLabel("Welcome to Oh-No, UNO for your Computer!");
		topBar.add(welcome);
		topBar.add(whiteCard);
		add(topBar, BorderLayout.NORTH);

	}

	
	
	public class boardGUI extends JFrame {
		private static final int WIDTH = 590;
		private static final int HEIGHT = 450;
		private static final int CARDWIDTH = 90;
		private static final int CARDHEIGHT = 150;

		private JPanel mainPanel = new JPanel();
		private JPanel northPanel = new JPanel(new GridLayout(1, 3));
		private JLabel currentPlayerCounter;
		private JLabel cardCounter;
		private JLabel deckCounter;
		private JPanel instructionPanel = new JPanel(new GridLayout(2, 1));
		private JLabel instruction = new JLabel("Select a card, then press ''End Turn''. Then, press ''Next Player'' to advance to the next player.");
		private JLabel error = new JLabel();
		private JPanel centerPanel = new JPanel(new GridLayout(1, 2, 5, 5));
		private JPanel westPanel = new JPanel(new GridLayout(2, 2, 5, 5));
		private JLabel topCardLabel = new JLabel("Top Card", SwingConstants.RIGHT);
		private JLabel topCardHousing;
		private ImageIcon topCardImage;
		private String topCardImagePath;
		private JLabel drawCardLabel = new JLabel("Draw Card", SwingConstants.RIGHT);
		private JButton drawCardButton;
		private JPanel eastPanel = new JPanel(new GridLayout(2, 1, 0, 5));
		private JPanel eastCenterPanel = new JPanel(new GridLayout(1, 2, 5, 0));
		private JLabel handLabel = new JLabel("Player " + (currentPlayer + 1) + "'s Hand");
		private JComboBox hand = new JComboBox();
		private JPanel eastSouthPanel = new JPanel(new GridLayout(3, 1, 2, 2));
		private JButton endTurnButton;
		private JButton nextPlayerButton;
		private JButton declareOhnoButton;

		public void advanceTurn() {
			for (int i = 0; i <= timesToSkip; ++i) {
				if (isPlayOrderClockwise) {
					++currentPlayer;
					if (currentPlayer == numPlayers) {
						currentPlayer = 0;
						System.out.println("currentPlayer reset to 0");
					}

				} else {
					--currentPlayer;
					if (currentPlayer < 0) {
						currentPlayer = numPlayers - 1;
						System.out.println("currentPlayer reset up to " + currentPlayer);
					}
				}

				for (int z = 0; z < cardsForNextPlayer; ++z) {
					player.get(currentPlayer).addCard(board.drawCard());
				}
			}
			cardsForNextPlayer = 0;
			timesToSkip = 0;
			updateError(0);
			cardDrawn = false;
			ohnoDeclared = false;
			turnFinished = false;
		}

		public void initialDealing() {
			if (numPlayers == 2) {
				for (int x = 0; x < STARTINGHAND; ++x) {
					player.get(0).addCard(board.drawCard());
					player.get(1).addCard(board.drawCard());
				}
			} else if (numPlayers == 3) {
				for (int x = 0; x < STARTINGHAND; ++x) {
					player.get(0).addCard(board.drawCard());
					player.get(1).addCard(board.drawCard());
					player.get(2).addCard(board.drawCard());
				}
			} else if (numPlayers == 4) {
				for (int x = 0; x < STARTINGHAND; ++x) {
					player.get(0).addCard(board.drawCard());
					player.get(1).addCard(board.drawCard());
					player.get(2).addCard(board.drawCard());
					player.get(3).addCard(board.drawCard());
				}
			}
			while (board.getTopCard().getColor() == 0)
				board.addToPile(board.drawCard());
		}

		public void drawCard() {
			if(board.getDeck().size() == 0)
				board.recycle();
			player.get(currentPlayer).addCard(board.drawCard());
			updateGUI();
			cardDrawn = true;
		}

		public void playCard() {
			int index = hand.getSelectedIndex();
			System.out.println("selected index" + index);
			System.out.println("currentPlayer " + currentPlayer);
			if(!turnFinished){
				if (player.get(currentPlayer).getHand().get(index).getColor() == 0) {
					if (player.get(currentPlayer).getHand().get(index).getValue() == 0) {
						wildRules();
						hand.setVisible(false);
						player.get(currentPlayer).removeCard(index);
						turnFinished = true;
						System.out.println("Wild Rules!");
					} else if (player.get(currentPlayer).getHand().get(index).getValue() == 1) {
						wildDraw4Rules();
						hand.setVisible(false);
						player.get(currentPlayer).removeCard(index);
						turnFinished = true;
						System.out.println("Wild Draw 4 Rules!");
					}
				} else if (player.get(currentPlayer).getHand().get(index).getColor() == board.getTopCard().getColor()
						|| player.get(currentPlayer).getHand().get(index).getValue() == board.getTopCard().getValue()) {
					System.out.println("Card matches!");
					board.addToPile(player.get(currentPlayer).getHand().get(index));

					if (player.get(currentPlayer).getHand().get(index).getValue() == 10) {
						skipRules();
						System.out.println("Skip Rules!");
					} else if (player.get(currentPlayer).getHand().get(index).getValue() == 11) {
						reverseRules();
						System.out.println("Reverse Rules!");
					} else if (player.get(currentPlayer).getHand().get(index).getValue() == 12) {
						draw2Rules();
						System.out.println("Draw 2 Rules!");
					}

					player.get(currentPlayer).removeCard(index);
					hand.setVisible(false);
					turnFinished = true;
				} else { // if it doesn't match and isn't a wild
					if (!cardDrawn) {
						updateError(2);
						turnFinished = false;
					}
					else {
						updateError(0);
						hand.setVisible(false);
						turnFinished = true;
					}
				}
			}
			else
				updateError(8);
		}

		private void wildRules() {
			int newColor = (int) ((Math.random() * 4) + 1);
			board.setTopCard(newColor, 13);
			updateTopCardPath();
		}

		private void wildDraw4Rules() {
			int newColor = (int) ((Math.random() * 4) + 1);
			board.setTopCard(newColor, 14);
			updateTopCardPath();
			cardsForNextPlayer = 4;
		}

		private void skipRules() {
			timesToSkip = 1;
		}

		private void draw2Rules() {
			cardsForNextPlayer = 2;
		}

		private void reverseRules() {
			isPlayOrderClockwise = !isPlayOrderClockwise;
		}

		public void updateHand() {
			String path;
			String color = "";
			String value = "";
			System.out.println("currentPlayer = " + currentPlayer);
			System.out.println("player.get(currentPlayer) " + player.get(currentPlayer));
			System.out.println("player.get(currentPlayer).getHand().size() " + player.get(currentPlayer).getHand().size());
			ImageIcon[] cardImages = new ImageIcon[player.get(currentPlayer).getHand().size()];
			for (int i = 0; i < player.get(currentPlayer).getHand().size(); ++i) {
				if (player.get(currentPlayer).getHand().get(i).getColor() == 0)
					color = "x";
				else if (player.get(currentPlayer).getHand().get(i).getColor() == 1)
					color = "r";
				else if (player.get(currentPlayer).getHand().get(i).getColor() == 2)
					color = "y";
				else if (player.get(currentPlayer).getHand().get(i).getColor() == 3)
					color = "g";
				else if (player.get(currentPlayer).getHand().get(i).getColor() == 4)
					color = "b";

				if (player.get(currentPlayer).getHand().get(i).getValue() == 0)
					value = "0";
				else if (player.get(currentPlayer).getHand().get(i).getValue() == 1)
					value = "1";
				else if (player.get(currentPlayer).getHand().get(i).getValue() == 2)
					value = "2";
				else if (player.get(currentPlayer).getHand().get(i).getValue() == 3)
					value = "3";
				else if (player.get(currentPlayer).getHand().get(i).getValue() == 4)
					value = "4";
				else if (player.get(currentPlayer).getHand().get(i).getValue() == 5)
					value = "5";
				else if (player.get(currentPlayer).getHand().get(i).getValue() == 6)
					value = "6";
				else if (player.get(currentPlayer).getHand().get(i).getValue() == 7)
					value = "7";
				else if (player.get(currentPlayer).getHand().get(i).getValue() == 8)
					value = "8";
				else if (player.get(currentPlayer).getHand().get(i).getValue() == 9)
					value = "9";
				else if (player.get(currentPlayer).getHand().get(i).getValue() == 10)
					value = "10";
				else if (player.get(currentPlayer).getHand().get(i).getValue() == 11)
					value = "11";
				else if (player.get(currentPlayer).getHand().get(i).getValue() == 12)
					value = "12";
				path = "cards//" + color + value + ".png";
				System.out.println("Card at " + i + ": " + player.get(currentPlayer).getHand().get(i).getColor() + ", "
						+ player.get(currentPlayer).getHand().get(i).getValue());
				System.out.println("updateHand Path: " + path);
				cardImages[i] = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(CARDWIDTH, CARDHEIGHT,
						java.awt.Image.SCALE_SMOOTH));
			}
			DefaultComboBoxModel handModel = new DefaultComboBoxModel(cardImages);
			hand.setModel(handModel);
			repaint();
		}

		public void updateError(int code) {
			if (code == 0)
				error.setText("");
			else if (code == 1)
				error.setText("Player drew the following card: " + player.get(currentPlayer).getHand()
						.get(player.get(currentPlayer).getHand().size() - 1).toString());
			else if (code == 2)
				error.setText("ERROR: Please pick a valid card or draw a card from the deck.");
			else if (code == 3)
				error.setText("ERROR: You have already drawn a card. Please make an action or end your turn.");
			else if (code == 4)
				error.setText("ERROR: You do not meet the criteria to declare OH-NO! Please make a different action.");
			else if (code == 5)
				error.setText("You have already declared OH-NO! Please make an action and end your turn!");
			else if (code == 6)
				error.setText("You forgot to declare OH-NO! You have been given two cards from the deck.");
			else if (code == 7)
				error.setText("ERROR: You must end your turn before you can move to the next player.");
			else if (code == 8)
				error.setText("ERROR: You have already ended your turn. Please press ''Next Player''.");
			else if (code == 9)
				error.setText("You declared OH-NO! You do not have to draw two cards from the deck.");
			else if( code == 10)
			{
				error.setText("PLAYER " + currentPlayer + " WINS!");
				error.setFont(new Font("Tahoma", Font.BOLD, 24));
				error.setForeground(Color.ORANGE);
			}

		}

		public void updateTopCard() {
			try {
				ImageIcon ii = new ImageIcon(ImageIO.read(new File(topCardImagePath)));
				Image img = ii.getImage().getScaledInstance(CARDWIDTH, CARDHEIGHT, java.awt.Image.SCALE_SMOOTH);
				ii = new ImageIcon(img);
				topCardHousing.setIcon(ii);
			} catch (IOException e) {
				e.printStackTrace();
			}
			repaint();
		}

		public void updateTopCardPath() {
			System.out.println("Previous Path: " + topCardImagePath);
			String color = "";
			String value = "";
			if (board.getTopCard().getColor() == 0)
				color = "x";
			else if (board.getTopCard().getColor() == 1)
				color = "r";
			else if (board.getTopCard().getColor() == 2)
				color = "y";
			else if (board.getTopCard().getColor() == 3)
				color = "g";
			else if (board.getTopCard().getColor() == 4)
				color = "b";

			if (board.getTopCard().getValue() == 0)
				value = "0";
			else if (board.getTopCard().getValue() == 1)
				value = "1";
			else if (board.getTopCard().getValue() == 2)
				value = "2";
			else if (board.getTopCard().getValue() == 3)
				value = "3";
			else if (board.getTopCard().getValue() == 4)
				value = "4";
			else if (board.getTopCard().getValue() == 5)
				value = "5";
			else if (board.getTopCard().getValue() == 6)
				value = "6";
			else if (board.getTopCard().getValue() == 7)
				value = "7";
			else if (board.getTopCard().getValue() == 8)
				value = "8";
			else if (board.getTopCard().getValue() == 9)
				value = "9";
			else if (board.getTopCard().getValue() == 10)
				value = "10";
			else if (board.getTopCard().getValue() == 11)
				value = "11";
			else if (board.getTopCard().getValue() == 12)
				value = "12";
			else if (board.getTopCard().getValue() == 13)
				value = "13";
			else if (board.getTopCard().getValue() == 14)
				value = "14";

			topCardImagePath = "cards//" + color + value + ".png";
			// repaint();
		}

		public void updateGUI() {
			String spacer = "             ";
			currentPlayerCounter.setText("Current Player: " + (currentPlayer + 1) + " out of " + numPlayers + spacer);
			deckCounter.setText("Cards Remaining: " + board.getDeck().size());
			cardCounter.setText(spacer + "You have..." + player.get(currentPlayer).getHand().size() + " cards.");
			handLabel.setText("Player " + (currentPlayer + 1) + "'s Hand");
		}
		
		public boardGUI() {
			super("OH-NO");
			setSize(WIDTH, HEIGHT);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			isPlayOrderClockwise = true;

			initialDealing();

			currentPlayerCounter = new JLabel("", SwingConstants.LEFT);
			deckCounter = new JLabel("", SwingConstants.CENTER);
			cardCounter = new JLabel("", SwingConstants.RIGHT);

			northPanel.add(currentPlayerCounter);
			northPanel.add(deckCounter);
			northPanel.add(cardCounter);
			mainPanel.add(northPanel, BorderLayout.NORTH);

			updateTopCardPath();
			westPanel.add(topCardLabel);

			topCardImage = new ImageIcon(topCardImagePath);
			Image img = topCardImage.getImage().getScaledInstance(CARDWIDTH, CARDHEIGHT, Image.SCALE_SMOOTH);
			topCardImage = new ImageIcon(img);
			topCardHousing = new JLabel(topCardImage);

			drawCardButton = new JButton(new ImageIcon(new ImageIcon("cards//facedown.png").getImage()
					.getScaledInstance(CARDWIDTH, CARDHEIGHT, java.awt.Image.SCALE_SMOOTH)));
			drawCardButton.addActionListener(new ActionListener() { // Browse
				public void actionPerformed(ActionEvent e) {
					if (!cardDrawn) {
						drawCard();
						updateError(1);
						updateHand();
					} else
						updateError(3);
				}

			});

			westPanel.add(topCardHousing);
			westPanel.add(drawCardLabel);
			westPanel.add(drawCardButton);

			updateHand();
			eastCenterPanel.add(handLabel);
			eastCenterPanel.add(hand);
			centerPanel.add(westPanel);
			centerPanel.add(eastPanel);
			mainPanel.add(centerPanel);

			declareOhnoButton = new JButton("Declare OH-NO");
			declareOhnoButton.addActionListener(new DeclareOhnoListener());
			endTurnButton = new JButton("End Turn");
			endTurnButton.addActionListener(new EndTurnListener());
			nextPlayerButton = new JButton("Next Player");
			nextPlayerButton.addActionListener(new NextPlayerListener());
			eastSouthPanel.add(declareOhnoButton);
			eastSouthPanel.add(endTurnButton);
			eastSouthPanel.add(nextPlayerButton);
			eastPanel.add(eastCenterPanel);
			eastPanel.add(eastSouthPanel);
			instructionPanel.add(instruction);
			instructionPanel.add(error);
			mainPanel.add(instructionPanel, BorderLayout.SOUTH);

			add(mainPanel);
			setVisible(true);
		}

		public class DeclareOhnoListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (!ohnoDeclared) {
					if (player.get(currentPlayer).getHand().size() != 2)
						updateError(4);
					else {
						ohnoDeclared = true;
						updateError(9);
					}
				} else
					updateError(5);
			}
		}

		public class NextPlayerListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (turnFinished) {
					advanceTurn();
					hand.setVisible(true);
					updateGUI();
					updateHand();
					updateError(0);
					System.out.println("End of NextPlayerListener");
					// if(applyDraw2Rules) {}
				} else
					updateError(7);
			}
		}

		public class EndTurnListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (!turnFinished) {
					playCard();
					updateGUI();
					updateTopCardPath();
					updateTopCard();
					updateHand();
					if(!ohnoDeclared && player.get(currentPlayer).getHand().size() == 1) {
						updateError(6);
						drawCard();
						drawCard();
					}
					if(player.get(currentPlayer).getHand().size() == 0)
					{
						mainPanel.remove(centerPanel);
						updateError(10);
					}

				} else
					updateError(8);
			}
		}

	}

	public class RuleBook extends JFrame {
		public static final int WIDTH = 900;
		public static final int HEIGHT = 600;

		public RuleBook() {

			super();
			setSize(WIDTH, HEIGHT);
			setTitle("Rulebook!");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			setLayout(new BorderLayout());

			JPanel rulesPanel = new JPanel();
			rulesPanel.setBackground(Color.LIGHT_GRAY);
			JLabel title = new JLabel("Here are the rules for OH-NO!");
			JLabel rule1 = new JLabel("1. Each player will be dealt 7 cards at start");
			JLabel rule2 = new JLabel(
					"2. Starting card will be flipped from the top of the Draw Pile and placed face up on the Discard Pile");
			JLabel rule3 = new JLabel("3. Player to the left of the dealer will go first");
			JLabel rule4 = new JLabel(
					"4. Cards to be played must be of matching color, number or you can play a Wild/Draw4 card");
			JLabel rule5 = new JLabel("5. If no card can be played, player must draw from the Draw Pile");
			JLabel rule6 = new JLabel(
					"6. When a player has only one card left they must call Oh-No prior to playing their last card");
			JLabel rule7 = new JLabel(
					"7. If the player does not call Oh-No and another player calls them on it, they must draw 7 cards from the Draw Pile");
			JLabel rule8 = new JLabel(
					"8. Special Cards: Draw +2 causes the next player to Draw 2 cards from the Draw Pile. Skip Cards cause the next player to be skipped. Draw 4 Cards cause the next player to draw 4 cards and the player who played the Draw 4 chooses the color to be played");

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

			
		}

	}

	public class OhNoQuitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	public class OhNoPlayListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userStr = (String) playerCount.getSelectedItem();
			if (Integer.parseInt(userStr) >= 2 && Integer.parseInt(userStr) <= 4) {
				numPlayers = Integer.parseInt(userStr);
				for (int i = 0; i < numPlayers; ++i)
					player.add(new Player(i + 1));

				currentPlayer = 0;

				board = new Board();
				board.addToPile(board.drawCard());
				boardGUI game = new boardGUI();
				game.updateGUI();
				// Sets boardGUi to visible
				game.setVisible(true);
			}
		}
	}

	public class OhNoRulesListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Goes to rulebook
			RuleBook ruleDisplay = new RuleBook();
			ruleDisplay.setVisible(true);
		}
	}
}
