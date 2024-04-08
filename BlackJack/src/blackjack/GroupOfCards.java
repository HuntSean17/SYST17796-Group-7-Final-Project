/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupOfCards {

    private final List<Card> cards;

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

