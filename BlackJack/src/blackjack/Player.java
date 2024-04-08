/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String playerName;
    private int chips;
    private int handscore;
    private int bet;
    private List<Card> cards;

    public Player(String name, int chips) {
        this.playerName = name;
        this.handscore = 0;
        this.bet = 0;
        this.chips= chips;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return handscore;
    }

    public void addToScore(int value) {
        handscore += value;
    }

    public void resetScore() {
        handscore = 0;
    }

    public int getBet() {
        return bet;
    }
    
     public int getChips() {
        return chips;
    }
     
    public int setChips(int bet) {
        chips += bet;
           return chips;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public void winBet() {
        chips += bet;
        System.out.println(playerName + " won their bet and won " + bet + " chips!");
    }

    public void loseBet() {
        chips -= bet;
        System.out.println(playerName + " lost their bet and " + bet + " chips better luck next time.");
    }
    
    @Override
    public String toString() {
        return playerName;
    }

   // public void clearCards() {
    //    cards.clear();
    //}

    void setScore(int i) {
        this.handscore = i;
    }
}

    

