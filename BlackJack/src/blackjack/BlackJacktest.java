package blackjack;

public class BlackJacktest{
    
public static boolean checkPlayerCount(int playerCount){
    if(playerCount <= 4 && playerCount >= 1){
        return true;
    }
    else {
        return false;
    }
}

public static boolean checkPlayerHitStand(String userInput){
    if (userInput.equalsIgnoreCase("h")) {
            return true;
        }
    else if (userInput.equalsIgnoreCase("s")) {
        return true;
    }
    else{
        return false;
    }
}

public static boolean checkUserBet(int userBet){
    if (userBet >0 ){
        return true;
    }
    else{
        return false;
    }
}

    @test
    public static void playerAmountGood(){
       int playerCount = 4;
       System.out.println("testing player count of " + playerCount);
       boolean expectedResult = true;
       boolean result = checkPlayerCount(playerCount);
       if(expectedResult == result){
            System.out.println("testing player count of " + playerCount+ " passed");
       }
       else{
            System.out.println("testing player count of " + playerCount+ " failed");
       }
    }

    @test
    public static void playerAmountBoundary(){
        int playerCount = 0;
        System.out.println("testing player count of " + playerCount);
        boolean expectedResult = false;
        boolean result = checkPlayerCount(playerCount);
        if(expectedResult == result){
             System.out.println("testing player count of " + playerCount+ " passed");
        }
        else{
             System.out.println("testing player count of " + playerCount+ " failed");
        }
}

    @test
    public static void playerAmountbad(){
        int playerCount = 10;
        System.out.println("testing player count of " + playerCount);
        boolean expectedResult = false;
        boolean result = checkPlayerCount(playerCount);
    if(expectedResult == result){
         System.out.println("testing player count of " + playerCount+ " passed");
    }
    else{
         System.out.println("testing player count of " + playerCount+ " failed");
    }
}

@test
public static void playerHitStandGood(){
    String userInput = "h";
    System.out.println("user h/s input " + userInput);
    boolean expectedResult = true;
    boolean result = checkPlayerHitStand(userInput);
if(expectedResult == result){
     System.out.println("user h/s inputf " + userInput+ " passed");
}
else{
     System.out.println("user h/s input " + userInput+ " failed");
}
}

@test
public static void playerHitStandboundary(){
    String userInput = "hs";
    System.out.println("user h/s input " + userInput);
    boolean expectedResult = false;
    boolean result = checkPlayerHitStand(userInput);
if(expectedResult == result){
     System.out.println("user h/s input " + userInput+ " passed");
}
else{
     System.out.println("user h/s input " + userInput+ " failed");
}
}

@test
public static void playerHitStandBad(){
    String userInput = "hit";
    System.out.println("user h/s input " + userInput);
    boolean expectedResult = false;
    boolean result = checkPlayerHitStand(userInput);
if(expectedResult == result){
     System.out.println("user h/s input " + userInput+ " passed");
}
else{
     System.out.println("user h/s input " + userInput+ " failed");
}
}

@test
    public static void playerBetGood(){
       int userBet = 50;
       System.out.println("testing player bet of " + userBet);
       boolean expectedResult = true;
       boolean result = checkUserBet(userBet);
       if(expectedResult == result){
            System.out.println("testing player count of " + userBet+ " passed");
       }
       else{
            System.out.println("testing player count of " + userBet+ " failed");
       }
    }

    @test
    public static void playerBetboundary(){
       int userBet = 2345;
       System.out.println("testing player bet of " + userBet);
       boolean expectedResult = true;
       boolean result = checkUserBet(userBet);
       if(expectedResult == result){
            System.out.println("testing player count of " + userBet+ " passed");
       }
       else{
            System.out.println("testing player count of " + userBet+ " failed");
       }
    }

    @test
    public static void playerBetBad(){
       int userBet = 0;
       System.out.println("testing player bet of " + userBet);
       boolean expectedResult = false;
       boolean result = checkUserBet(userBet);
       if(expectedResult == result){
            System.out.println("testing player count of " + userBet+ " passed");
       }
       else{
            System.out.println("testing player count of " + userBet+ " failed");
       }
    }



public static void main(String[] args){
    playerBetBad();
    playerBetboundary();
    playerBetGood();

    playerAmountbad();
    playerAmountBoundary();
    playerAmountGood();

    playerHitStandBad();
    playerHitStandboundary();
    playerHitStandGood();
}
}
