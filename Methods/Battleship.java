import java.util.Scanner;
public class Battleship {
	public static void main(String[] args) {
        {
            char[][] player1ShipLocations = new char[5][5];
            char[][] player2ShipLocations = new char[5][5];
            char[][] player1ScoreCard = new char[5][5];
            char[][] player2ScoreCard = new char[5][5];
            String invalidCoordinatesMessage = "Invalid coordinates. Choose different coordinates.";

           
            //Initialize player ship position and score card arrays
            initializeArray(player1ShipLocations, '-');
            initializeArray(player2ShipLocations, '-');
            initializeArray(player1ScoreCard, '-');
            initializeArray(player2ScoreCard, '-');

            System.out.println("Welcome to Battleship!");
            System.out.println("\nPLAYER 1, ENTER YOUR SHIPS' COORDINATES.");

            loadPlayerShipPositions(player1ShipLocations, invalidCoordinatesMessage);

            printBattleShip(player1ShipLocations);

            for(int i = 0; i < 99; i++)
                System.out.print("\n");
            
            System.out.println("\nPLAYER 2, ENTER YOUR SHIPS' COORDINATES.");

            loadPlayerShipPositions(player2ShipLocations, invalidCoordinatesMessage);
            printBattleShip(player2ShipLocations);

            for(int i = 0; i < 99; i++)
                System.out.print("\n"); 
            
            do 
            { 
                // checkShipHit(char[][] shipLocationsArray, int playerID, int opponentID, char[][] scoreCardArray, String invalidCoordMessage)
                checkShipHit(player2ShipLocations, 1, 2, player1ScoreCard, invalidCoordinatesMessage);   
                printBattleShip(player1ScoreCard);

                if(Win(player1ScoreCard))
                    break;

                checkShipHit(player1ShipLocations, 2, 1, player2ScoreCard, invalidCoordinatesMessage);  
                printBattleShip(player2ScoreCard);

                
            } while (!(Win(player2ScoreCard)||Win(player1ScoreCard)));


            if(Win(player1ScoreCard))
                System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
            else
                System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
       
            System.out.println("\nFinal boards:");
            System.out.println("");
            printBattleShip(player1ShipLocations);
            System.out.println("");
            printBattleShip(player2ShipLocations);
            
        }
    }
	// Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}

    public static boolean setShipLocations(int x, int y, char shipCoordinatesArray[][], char shipChar, String invalidInputMessage)
    {
        boolean result = false;
        String shipAlreadyAtSpotMessage = "You already have a ship there. Choose different coordinates.";
        if(x > 4 || y > 4 || x < 0 || y < 0)
        {
            System.out.println(invalidInputMessage);
            return result;
        }
        else if(shipCoordinatesArray[x][y]!='-')//Not sure this is the correct check
        {
            System.out.println(shipAlreadyAtSpotMessage);
            return result;
        }
        else
        {
            shipCoordinatesArray[x][y] = shipChar;
            result = true;
            return result;
        }
    }

    public static void initializeArray(char[][] charArray, char c)
    {
        for(int i = 0; i< charArray.length; i++)
        {
            for(int j = 0; j < charArray[i].length; j++)
            {
                charArray[i][j] = c;
            }
        }
    }

    public static void loadPlayerShipPositions(char[][] playerShipPositions, String invalidCoordMessage)
    {
        Scanner input = new Scanner(System.in);
        int validInput = 1;
        do
        {
            System.out.println("Enter ship " + validInput + " location:");
            if(input.hasNextInt())
            {
                int num1 = input.nextInt();
                if(input.hasNextInt())
                {
                    int num2  = input.nextInt();
                    if(setShipLocations(num1, num2, playerShipPositions, '@', invalidCoordMessage))
                        validInput+=1;   
                }
                else
                {
                        System.out.println(invalidCoordMessage);
                }
            }
            else
            {
                System.out.println(invalidCoordMessage);
            }
        }
        while(validInput < 6);
    }
    public static void checkShipHit(char[][] shipLocationsArray, int playerID, int opponentID, char[][] scoreCardArray, String invalidCoordMessage)
    {
        Scanner input = new Scanner(System.in);
        boolean playerTurn = true;
        do
        {
            System.out.println("\nPlayer " + playerID +", enter hit row/column:");
            if(input.hasNextInt())
            {
                int num1 = input.nextInt();
                if(input.hasNextInt())
                {
                    int num2  = input.nextInt();
                    if(logScore(num1, num2, shipLocationsArray, scoreCardArray, playerID, opponentID, invalidCoordMessage))
                        playerTurn = false;
                    
                }
                else
                {
                        System.out.println(invalidCoordMessage);
                }
            }
            else
            {
                System.out.println(invalidCoordMessage);
            }
        }
        while(playerTurn);
    }
    public static boolean logScore(int x, int y, char[][] targetShipLocations, char[][] scoreCard, int playerID, int opponentID, String invalidInputMessage)
    {
        boolean result = false;
        String spotAlreadyHitMessage = "You already fired on this spot. Choose different coordinates.";
        if(x > 4 || y > 4 || x < 0 || y < 0)
        {
            System.out.print(invalidInputMessage);
            return result;
        }
        else if (scoreCard[x][y] == 'X' || scoreCard[x][y] == 'O') 
        {
            System.out.print(spotAlreadyHitMessage);
            return result;
        }
        else if(targetShipLocations[x][y] == '@')
        {
            System.out.println("PLAYER " + playerID + " HIT PLAYER " + opponentID +"'s SHIP!");
            scoreCard[x][y] = 'X';
            targetShipLocations[x][y] = 'X';
            result = true;
            return result;
        }
        else
        {
            System.out.println("PLAYER " + playerID +" MISSED!");
            scoreCard[x][y] = 'O';
            targetShipLocations[x][y] = 'O';
            result = true;
            return result;
        }
    }
    public static boolean Win(char[][] scorecard)
    {
        int numOfHits = 0;
        for(int i = 0; i < scorecard.length; i++)
        {
            for(int j = 0; j < scorecard[i].length; j++)
            {
                if(scorecard[i][j] == 'X')
                {
                    numOfHits+=1;
                }
            }
        }
        return numOfHits>4;
    }
   
}