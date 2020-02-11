package Backend;

class Battleship {
    private static final String letters = "ABCDEFGHIJ";
    private static final int MAX_COL = 10;
    private static final char MAX_ROW = 'J';
    
    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    
    
}
/*
public class Battleship extends ConsoleProgram
{
    private static final String letters = "ABCDEFGHIJ";
    private static final int MAX_COL = 10;
    private static final char MAX_ROW = 'J';


    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;


    public void run()
    {
        System.out.println("=======================\nWelcome to Battle Ship\n=======================");


        Player human = new Player();
        Player computer = new Player();


        setUpShips(human, computer);


        readLine("\nHit enter to start guessing.");


        boolean gameOver = false;


        while(!gameOver)
        {
            gameOver = playRound(human, computer);
        }


        if(human.hasWon())
        {
            System.out.println("You won!");
        }
        else
        {
            System.out.println("You lost!");
        }


        System.out.println("Thanks for playing!");
    }


    /**
     * Method to do the following:
     *   Call a method to place the human ships onto the grid
     *   Call a method to place the computer ships on the grid randomly
     

    private void setUpShips(Player human, Player computer)
    {
        initializeShipsFromInput(human);
        System.out.println("\nPositioning computer ships!");
        computer.initializeShipsRandomly();
    }

    /**
     * Method should loop through 5 times to place all ships, each time showing 
     * the current ship placement.  Each loop the user will choose a location of
     * the ship to be placed.  If the location is invalid, it will prompt them
     * to enter another location
      
    public void initializeShipsFromInput(Player player)
    {
        for(int i = 0; i < player.SHIP_LENGTHS.length; i++)
        {
            System.out.println("Positioning ship with length " + player.SHIP_LENGTHS[i] + ".");
            int row = readRow();
            int col = readCol();
            int direction = readDirection();
            
            while(player.chooseShipLocation(player.myShips[i], row, col, direction) == false)
            {
                System.out.println("You can't place ship there!");
                System.out.println("Positioning ship with length " + player.SHIP_LENGTHS[i] + ".");
                row = readRow();
                col = readCol();
                direction = readDirection();
            }
            player.printMyShips();
        }
    }
    
    /**
     * Method to take in user input (in many formats) and convert it to the 
     * direction of the ship, as long as the direction entered was valid.
      
    private int readDirection()
    {
        String dir = readLine("What direction?: ");
        dir = dir.toLowerCase();
        while(!(dir.equals("v") || dir.equals("vertical") || dir.equals("h") || dir.equals("horizontal")))
        {
            dir = readLine("What direction?: ");
            dir = dir.toLowerCase();

        }
        
        if(dir.equals("v") || dir.equals("vertical"))
        {
            return 1;
        }
        
        return 0;
    }


    /**
     * Method to get user input as to which column the wish to place their ship
     * This method should verify the user input is valid (ie. within numerical range)
     


    private int readCol()
    {
        int col = readInt("What column?: ");
        col = col - 1;
        while(!(col < 10 && col > -1))
        {
            col = readInt("What column?: ");
        }
        return col;
    }


    /**
     * Method to get user input as to which row the wish to place their ship
     * This method should verify the user input is valid (ie. within alphabet range)
     
    private int readRow()
    {
        String stringRow = readLine("What row?: ");
        stringRow = stringRow.toUpperCase();
        String stringLet = stringRow.substring(0, 1);
        while(!(stringLet.equals("A") || stringLet.equals("B") || stringLet.equals("C") || stringLet.equals("D") || stringLet.equals("E") || stringLet.equals("F") || stringLet.equals("G") || stringLet.equals("H") || stringLet.equals("I") || stringLet.equals("J")))
        {
            stringRow = readLine("Invalid Input. What row?: ");
            stringRow = stringRow.toUpperCase();
            stringLet = stringRow.substring(0, 1);
        }
        return letters.indexOf(stringLet);
    }


    // Plays a round of battle ship, returns true if the game
    // is over, false otherwise.
    private boolean playRound(Player human, Player computer)
    {
        humanTurn(human, computer);
        computerTurn(human, computer);
        
        for(int i = 0; i < computer.myShips.length; i++)
        {
            if(computer.isSunk(computer.myShips[i]))
            {
                System.out.println("You sank my battleship!");
            }
        }
        
        return human.hasWon();
    }


    /**
     * Randomly get a computer guess and make guess, then mark as hit or miss.
     * Make sure to print to the screen what happened.
      
    private void computerTurn(Player human, Player computer)
    {
        int row = computer.getRandomRowGuess();
        int col = computer.getRandomColGuess();
        computer.makeGuess(row, col, human);
        human.recordOpponentGuess(row, col);
        System.out.println("\n----Opponent's Guesses----");
        computer.printOpponentGuesses();
    }


    /**
     * Allow user to guess a row and column, then make guess and 
     * mark as hit or miss.
      
    private void humanTurn(Player human, Player computer)
    {
        int row = readRow();
        int col = readCol();
        
        while(human.isGuessed(row, col))
        {
            System.out.println("Already Guessed!");
            row = readRow();
            col = readCol();
        }
        
        if(human.makeGuess(row, col, computer))
        {
            System.out.println("\nHit!");
        }
        else
        {
            System.out.println("\nMiss!");
        }
        computer.recordOpponentGuess(row, col);
        System.out.println("----You're Guesses----");
        human.printOpponentGuesses();
    }
}

*/
