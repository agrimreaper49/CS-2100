package agents;

import java.util.*;
import casino.BlackjackPlayer;
import casino.Card;
import casino.Move;

/*
 * Define a blackjack player by inheriting from the superclass BlackjackPlayer
 *   and implementing the 3 abstract methods.
 */
public class MyBlackjackPlayer extends BlackjackPlayer{
	
	protected HashMap<Card.Suit, ArrayList<Integer>> cardsPlayed = new HashMap<>();
	
	@Override
	public int getBet() {
		//If number of chips is less than 10 just bet the remaining amount
		//Else bet 10 chips
		if (getChips() < 10) {
			return getChips();
		}
		return 10;
		
	}

	@Override
	public Move getMove() {
		/* Hits until we get a score of 16 or better */
		if(this.handScore() <= 16) return Move.HIT;
		return Move.STAY;
	}

	@Override
	public void handOver(Card[] dealerHand) {
		/**
		 * If you care about looking at the dealer's hand once
		 * the hand is over, then you can do it here. This method
		 * is called automatically after every hand and a copy of the dealer's
		 * final hand is given to you to process. The dealer's hand will be
		 * found in the array of Cards that you pass when the method returns.
		 */
		for (Card c : dealerHand) {
			ArrayList<Integer> ranks = cardsPlayed.get(c.getSuit());
			ranks.add(c.getRank());
			cardsPlayed.put(c.getSuit(), ranks);
		}
		
	}

	
}
