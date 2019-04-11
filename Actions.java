
public class Actions {
	
	public int discardPileType, discardPileNum;
	public int playerCardType, playerCardNum;
	
	public void playCard() {
		cardCompare();
	}
	
	
	// Card comparrision
	public void cardCompare() {
		if (discardPileType != playerCardType) {
			if(discardPileNum != playerCardNum)
				// Don't allow user to play card
				pickAnotherCard();
		
				
		}
		
	}
	
	
	//Draw until playable or one and pass
	
	//Skip cards
	
	//Draw cards
	
	//Declaration of UNO
	
	//Pick another card
	public void pickAnotherCard() {
		
	}
	
}
