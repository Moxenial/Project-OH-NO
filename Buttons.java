import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Buttons {

	private JFrame frame;
	private JButton drawButton;
	private drawButtonListener drawListener;
	
	public Buttons(JButton drawButton) 
	{
		this.drawButton = drawButton;
		frame = new JFrame("Draw Card Pls");
		drawButton = new JButton("Draw Card");
		
		frame.setLayout(new FlowLayout());
		drawListener = new drawButtonListener();
		
		frame.add(drawButton);
		
		drawButton.addActionListener(drawListener);
		
		frame.setSize(300,200);
		frame.setLocation(500,500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	public void execute(JButton drawButton)
	{
		this.drawButton = drawButton;
		frame.setVisible(true);
	}
	
	public class drawButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		if(((JButton)e.getSource()).getText().equals("Draw Card"))
			{
				JButton newCard = new JButton("New Card");
				newCard.setForeground(Color.BLACK);
				newCard.setBackground(Color.GREEN);
			
				newCard.addActionListener(this);
				frame.add(newCard);
			}
		else
		{
			JButton cardPicked = (JButton) e.getSource();
			
			frame.remove(cardPicked);
			frame.repaint();
		}
		}
	}
	
	
}

