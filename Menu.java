import java.util.Scanner;

public class Menu {

	Scanner choice = new Scanner(System.in);
	
	
	public void menu() {
		System.out.println("Enter the menu option as a number");
		int menuOption = choice.nextInt();
	
		switch (menuOption)
		{
		case 1:
			System.out.println("Rules");
			rulesDisplay();
			break;
		case 2:
			System.out.println("New Game");
			//Go to start a new game
			break;
		case 3:
			System.out.println("Quit");
			System.exit(0);
			break;
		}
	
	}
	
	public void rulesDisplay() {
		System.out.println("Here are all the rules of UNO");
		// deal 7 cards per player at start
		// clockwise play starting with left of dealer
		// play card matching color, type or number
		// must declare uno with one card left in hand before playing, otherwise if missed and other player catches, draw 7
		// skips/draw 2/draw 4/reverse
		// Draw 1 and pass or draw until a playable card it obtained for condition of non-playable in hand
	}
	
}
