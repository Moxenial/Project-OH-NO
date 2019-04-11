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
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			
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
			
			JPanel blueCard = new JPanel();
			blueCard.setBackground(Color.BLUE);
			homeDisplay.add(blueCard);
			
			JPanel greenCard = new JPanel();
			greenCard.setBackground(Color.GREEN);
			homeDisplay.add(greenCard);
			
			JPanel yellowCard = new JPanel();
			yellowCard.setBackground(Color.YELLOW);
			homeDisplay.add(yellowCard);
			
			JPanel redCard = new JPanel();
			redCard.setBackground(Color.RED);
			homeDisplay.add(redCard);
			
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
		public void actionPerformed(ActionEvent p)
		{
			// Prints to console for now..
			System.out.println("Playing Game");
		}
	}
	public class OhNoRulesListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// Goes to rulebook
			// This is the action performed
		}
	}
	
}
