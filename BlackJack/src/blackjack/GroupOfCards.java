/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    private int size;//the size of the grouping

    //creates a deck of cards using values from Suit and Rank will be called when game starts
    public GroupOfCards() {
        cards = new ArrayList<>();
        for (int i = 0; i < Suit.values().length; i++) {
            Suit suit = Suit.values()[i];
              for (int j = 0; j < Rank.values().length; j++) {
                Rank rank = Rank.values()[j];
                cards.add(new Card(suit, rank));
              }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.remove(0);
    }

    public int size() {
        return cards.size();
    }
}

