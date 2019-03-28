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
