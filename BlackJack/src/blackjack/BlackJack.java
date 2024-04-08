/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blackjack;

/**
 *
 * @author Sean Hunt
 */
import java.util.*;

public class BlackJack {

   //aks user for uinputs foor number of players then calls play method from game file which contains all game mechanics

    public static void main(String[] args) {
        //array list of player objects from player.java
        List<Player> players = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
       
        //asks user to input number of players between 1 and 4
        int PlayerCount = 0;
        boolean validPlayerCount = false;
        while (!validPlayerCount) {
            System.out.print("Enter the number of players (1-4): ");
            // try and catch makes sure that users input is between 1 and 4
            try {
                PlayerCount = scanner.nextInt();
                scanner.nextLine();
                if (PlayerCount < 1 || PlayerCount > 4) {
                    throw new InputMismatchException();
                }
                validPlayerCount = true;
                } 
            catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a number of players between 1 and 4.");
            }
        }

        //sets the name and chip value for each player start at one because it is the minimum amount of players
        for (int i = 1; i <= PlayerCount; i++) {
           String PlayerName = "player " +i;
           int Chips = 500;           
           Player player = new Player(PlayerName, Chips);
           players.add(player);
        }
        
        // Create the initial game
        Game game = new Game(players);
        //conatains all the methods that make the game function
        game.play();

    
}
}
    

