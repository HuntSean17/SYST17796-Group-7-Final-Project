/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package blackjack;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */

 // built card class to interact with Rank and Suit files to create cards from the enum storage of the other two files 
public class Card {
    
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getCardSuit() {
        return suit;
    }

    public Rank getCardRank() {
        return rank;
    }

    public int getCardValue() {
        return rank.getRankValue();
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

}
