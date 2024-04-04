/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.List;

public  class Player {

   private final String name;
    private int bank;
    private int bet;
    private List<Card> cards;

    public Player(String name, int bank) {
        this.name = name;
        this.bet = 0;
        this.bank= bank;
    }

    public String getName() {
        return name;
    }

    public int getBet() {
        return bet;
    }
    
     public int getBank() {
        return bank;
    }
     
    public int setBank(int bet) {
        bank += bet;
           return bank;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public void winBet() {
        bank += bet;
        System.out.println(name + " wins " + bet + " credits!");
    }

    public void loseBet() {
        bank -= bet;
        System.out.println(name + " loses " + bet + " credits.");
    }
    
    @Override
    public String toString() {
        return name;
    }
    
}
