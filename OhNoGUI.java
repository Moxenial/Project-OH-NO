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
		
		// doesnt do anything yet, prep for home menu button alignment
		setLayout(new GridLayout(ROWS, COLUMNS));
		
		// Button to start the game
		JButton playButton = new JButton("Play Game");
		playButton.addActionListener(new OhNoPlayListener());
		add(playButton);
		
		// Button to bring up rules
		JButton rulesButton = new JButton("View Rules");
		rulesButton.addActionListener(new OhNoRulesListener());
		add(rulesButton);
		
		
		// Button to quit out of GUI/Game
		JButton exitButton = new JButton("Quit Game");
		exitButton.addActionListener(new OhNoQuitListener());
		add(exitButton);
		
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
