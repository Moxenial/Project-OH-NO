//package cards;
public class Card {
	private int color;
	private int value;
	
	//accessors
	public int getColor() {
		return this.color;
	}
	public int getValue() {
		return this.value;
	}
	
	//mutators
	public void setColor(int color) {
		this.color = color;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		String output = "";
		if(this.color == 0 && this.value == 0)
			output += "Wild Card";

		else if (this.color == 0 && this.value == 1)
			output += "Wild Draw 4";
			
		else
		{
			if(this.color == 1)
				output += "Red ";
			else if(this.color == 2)
				output += "Yellow ";
			else if(this.color == 3)
				output += "Green ";
			else if(this.color == 4)
				output += "Blue ";
			
			if(this.value == 10)
				output += "Skip";
			else if(this.value == 11)
				output += "Reverse";
			else if(this.value == 12)
				output += "Draw 2";
			else
				output += this.value;
		}
		//output += "\n";
		return output;
	}
	
	//constructors
	public Card() {
		this.color = 0;
		this.value = 0;
	}
	public Card(int color, int value) {
		this.color = color;
		this.value = value;
	}
}
