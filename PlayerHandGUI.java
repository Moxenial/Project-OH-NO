import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayerHandGUI extends JFrame {

	private static final int WIDTH = 1000;
	private static final int HEIGHT =  800;
	
	public PlayerHandGUI()
	{
		super("Player Hand");
		setSize(WIDTH, HEIGHT);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		// Main panels
		JPanel mainPanel = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		JPanel btnBarMain = new JPanel();
		
		// Panels within the main
		JPanel currentCard = new JPanel();
		JPanel otherPlayers = new JPanel();
		JPanel cardBar1 = new JPanel();
		JPanel cardBtn1 = new JPanel();
		JPanel cardBar2 = new JPanel();
		JPanel cardBtn2 = new JPanel();
		JPanel cardBar3 = new JPanel();
		JPanel cardBtn3 = new JPanel();
		JPanel cardBar4 = new JPanel();
		JPanel cardBtn4 = new JPanel();
		
		// Main btn bar -- switch to close hand later!!!!
		JButton closeHand = new JButton("QUIT GAME");
		closeHand.addActionListener(new QuitListener());
		// Card buttons
		JButton playCard1 = new JButton("Play card 1");
		JButton playCard2 = new JButton("Play card 2");
		JButton playCard3 = new JButton("Play card 3");
		JButton playCard4 = new JButton("Play card 4");
		
		
		// sets background color for main panels
		mainPanel.setBackground(Color.WHITE);
		leftPanel.setBackground(Color.LIGHT_GRAY);
		rightPanel.setBackground(Color.LIGHT_GRAY);
		btnBarMain.setBackground(Color.DARK_GRAY);
		
		// sets layouts of panels
		mainPanel.setLayout(new GridLayout(1,2));
		leftPanel.setLayout(new GridLayout(2,1));
		rightPanel.setLayout(new GridLayout(8,1));
		btnBarMain.setLayout(new FlowLayout());
		
		// temp must get card and display from board
		currentCard.setBackground(Color.BLUE);
		// temp must get other players # cards remaining and display
		otherPlayers.setBackground(Color.BLACK);
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

		
		
		// Imports card images for buttons
		String cardB0 = "C:/Users/Nate/Desktop/cards/b0.png";
		String cardB1 = "C:/Users/Nate/Desktop/cards/b1.png";
		String cardB2 = "C:/Users/Nate/Desktop/cards/b2.png";
		String cardB3 = "C:/Users/Nate/Desktop/cards/b3.png";
		String cardB4 = "C:/Users/Nate/Desktop/cards/b4.png";
		
		// Creates the first row holding cards on the left side of the player display
		cardBar1.setLayout(new GridLayout(1,5));
		cardBar2.setLayout(new GridLayout(1,5));
		q
		
		// Creates buttons out of each card from png files
		JButton cardSlot1 = new JButton(new ImageIcon(((new ImageIcon(cardB0).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlot2 = new JButton(new ImageIcon(((new ImageIcon(cardB1).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlot3 = new JButton(new ImageIcon(((new ImageIcon(cardB2).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlot4 = new JButton(new ImageIcon(((new ImageIcon(cardB3).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		JButton cardSlot5 = new JButton(new ImageIcon(((new ImageIcon(cardB4).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
		

		// Builds first row of cards
		cardBar1.add(cardSlot1);
		cardBar1.add(cardSlot2);
		cardBar1.add(cardSlot3);
		cardBar1.add(cardSlot4);
		cardBar1.add(cardSlot5);
		
		
		


		// Add btn to main panel
		btnBarMain.add(closeHand);
		
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
