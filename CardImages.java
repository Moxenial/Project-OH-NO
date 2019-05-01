import java.awt.*;
import javax.swing.*;

public class CardImages extends JFrame {

	public CardImages(String arg)
	{
		if(arg == null)
		{
			arg = "C:/Users/Nate/Desktop/cards/b0.png";
		}
		
		JPanel cardTest = new JPanel();
		
		
		cardTest.setSize(500, 300);
		cardTest.setBackground(Color.BLACK);
		
		
		ImageIcon icon = new ImageIcon(arg);
		JLabel label = new JLabel();
		label.setIcon(icon);
		cardTest.add(label);
		
		
		this.getContentPane().add(cardTest);
		
	}
	
}
