/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package blackjack;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author Sean Hunt
 */

public class Game {

    private final GroupOfCards deck;
    private final List<Player> players;
    private int dealerScore;

    public Game(List<Player> players) {
        deck = new GroupOfCards();
        deck.shuffle();
        this.players = players;
        dealerScore = 0;
    }

    //calls all methods in this file to play a round of blackajck
    public void play() {
        System.out.println("Welcome to Blackjack!");

        // Betting round where game ends if a player has 0 chips
        for (Player player : players) {
            Scanner scanner = new Scanner(System.in);
            int maxBet = player.getChips();
            if (maxBet <= 0) {
                //ends game when a player runs out of chips
                System.out.print(player.getPlayerName() + "is out of chips the game will now end" );
                    System.exit(0);
            }
            
            // tray catch to make sure chips bet is greater than 0 and less or equal to chips total
            try{
            System.out.print(player.getPlayerName() + ", enter your bet less than  (1-" + maxBet + "): ");
            int bet = scanner.nextInt();
            if(bet > player.getChips() || bet <= 0){
                throw new InputMismatchException();
            }
            player.setBet(bet);
            scanner.nextLine(); // consume the newline character when input functions correctlly
            }
            catch(InputMismatchException x){
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a number between 1 and your chip total");
            }
        }

        // Deal cards
        dealCards();
        showDealersCards(false);

        // Player turns
        for (Player player : players) {
            boolean playerBust = playerTurn(player);
            if (playerBust) {
                System.out.println(player.getPlayerName() + " busted! Dealer wins!");
            } else {
                System.out.println(player.getPlayerName() + "'s turn is over.");
            }
        }

        // Dealer turn
        dealerTurn();

        // Determine winners
        determineWinners();
    }

    //cards are sent to each player and added to score for deciding whos winner
    private void dealCards() {
        for (Player player : players) {
            Card playerCard1 = deck.drawCard();
            Card playerCard2 = deck.drawCard();
            player.addToScore(playerCard1.getCardValue() + playerCard2.getCardValue());
            System.out.println(player.getPlayerName() + " was dealt a " + playerCard1 + " and a " + playerCard2);
        }
        //dealer drwas cards here 1 syays hidden until later
        Card dealerCard1 = deck.drawCard();
        Card dealerCard2 = deck.drawCard();
        dealerScore = dealerCard1.getCardValue() + dealerCard2.getCardValue();
        System.out.println("Dealer's card " + dealerCard1);
    }

    //displays cards and score for the dealer
    private void showDealersCards(boolean showDealerCard) {
        for (Player player : players) {
            System.out.println(player.getPlayerName() + "'s score " + player.getScore()+ "'s bet " + player.getBet() + " chips");
        }
        if (showDealerCard) {
            System.out.println("Dealer's score " + dealerScore);
        } else {
            System.out.println("Dealer's card will be revealed later");
        }
    }
    
    //code for player turn asks for input to hit or stand and displays new cards
private boolean playerTurn(Player player) {
    Scanner scanner = new Scanner(System.in);
    System.out.println( "it's now " + player.getPlayerName() + "'s turn");
    while (true) {
        System.out.println(player.getPlayerName() + " your current score is " + player.getScore() + " hit or stand? (h/s)");
        String playerChoice = scanner.nextLine();
        if (playerChoice.equalsIgnoreCase("h")) {
            Card newCard = deck.drawCard();
            player.addToScore(newCard.getCardValue());
            System.out.println(player.getPlayerName() + " drew a " + newCard + "your score is now " + player.getScore());
            if (player.getScore() >= 21) {
                return true;
            }
        } 
        else if (playerChoice.equalsIgnoreCase("s")) {
            break;
        }
    }
    return false;
}





    // method for the dealer interaction dealer will always hit while under 16
    private void dealerTurn() {
        System.out.println("Dealer's turn");
        while (dealerScore < 16) {
            Card card = deck.drawCard();
            dealerScore += card.getCardValue();
            System.out.println("Dealer draws a " + card + " Dealer's score is now " + dealerScore);
        }
    }

    //checks all players hand score to 
    private void determineWinners() {
        System.out.println(dealerScore + " is the score to beat");
        
        //runs the scores of all players and dealer to determine who wins the round
        for (Player player : players) {
            //individual player busted loses chips
            if (player.getScore() > 21) {
                
                System.out.println(player.getPlayerName() + " has busted better luck next time you lost " + (player.getChips()- player.getBet()) +" chips");
             
                //player lost so bet is added to their chip total as a negative number
                player.setChips(player.getBet()*-1);
                 
            //dealer busted eveyone who did not bust will win
            } else if (dealerScore > 21) {
                System.out.println("Dealer busted " + player.getPlayerName() + " wins " + player.getBet() + " chips now has a chip total of " + (player.getChips()+player.getBet()));
                
                player.setChips(player.getBet());
            
            // neither bust but player beats dealer
            } else if (player.getScore() > dealerScore) {
                System.out.println(player.getPlayerName() + " wins " + player.getBet() + " chips now has a chip total of " + (player.getChips()+player.getBet()));
                
                //player won 
                player.setChips(player.getBet());
                
            //neither bust but dealer wins
            } else if (dealerScore > player.getScore()) {
                System.out.println("Dealer wins and " + player.getPlayerName() + " loses " + player.getBet() + " chips now has a chip total of " + (player.getChips()-player.getBet())); 
         
                //player lost so bet is added to their chip total as a negative number
                player.setChips(player.getBet()*-1);
                       
            //tie player gets thier chips back 
            } else {
                System.out.println("It's a tie " + player.getPlayerName() + " gets back their bet of " + player.getBet() + " chips");
            }
        }
    }
   

}//end class
