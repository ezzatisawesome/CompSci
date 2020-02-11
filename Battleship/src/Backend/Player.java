package Backend;

public class Player
{
    // Static constants for the Player class
    public static final int[] SHIP_LENGTHS = {2, 3, 3, 4, 5};
    public static final int NUM_SHIPS = 5;
    private static final int MAX_HITS = computeMaxHits();
    
    //ship num check
    private int length_check = 0;
    
    // Direction constants
    private static final int UNSET = -1;
    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    

    private Grid myGrid;
    private Grid opponentGrid;
    public Ship[] myShips;
    private int numShips;
    private int totalHitsTaken;
    private int totalHitsDelivered;


    public Player()
    {
        numShips = 0;
        myGrid = new Grid();
        opponentGrid = new Grid();
        myShips = new Ship[SHIP_LENGTHS.length];
        for(int i = 0; i < SHIP_LENGTHS.length; i++)
        {
            myShips[i] = new Ship(SHIP_LENGTHS[i]);
        }
    }

    public boolean isSunk(Ship ship)
    {
        boolean alreadySunk = ship.isAlreadySunk();
        int row = ship.getRow();
        int col = ship.getCol();
        int len = ship.getLength();
        int dir = ship.getDirection();
        int hits = 0;
        
        if(dir == HORIZONTAL)
        {
            for(int i = col; i < col+len; i++)
            {
                if(myGrid.getStatus(row, i) == 1)
                {
                    hits++;
                }
            }
        }
            
        else if(dir == VERTICAL)
        {
            for(int i = row; i < row + len; i++)
            {
                if(myGrid.getStatus(i, col) == 1)
                {
                    hits++;
                }
            }
        }
        
        if(hits == len && !alreadySunk)
        {
            ship.setAlreadySunk(true);
            return true;
        }
        return false;
    }

    private static int computeMaxHits()
    {
        int hits = 0;
        for(int i = 0; i < SHIP_LENGTHS.length; i++)
        {
            hits += SHIP_LENGTHS[i];
        }
        return hits;
    }


    public void initializeShipsRandomly()
    {
        for(int i = 0; i < SHIP_LENGTHS.length; i++)
        {
            int row = Randomizer.nextInt(10);
            int col = Randomizer.nextInt(10);
            int direction = Randomizer.nextInt(2);
            
            while(chooseShipLocation(myShips[i], row, col, direction) == false)
            {
                row = Randomizer.nextInt(10);
                col = Randomizer.nextInt(10);
                direction = Randomizer.nextInt(2);
            }
        }
    }
    
    /**
     * Method to check if location is within the grid
     */
    public boolean inBounds(Grid grid, Ship s, int row, int col)
    {
        
        int dir = s.getDirection();
        int len = s.getLength();
        if(row < grid.numRows() && col < grid.numCols())
        {
            if(dir == HORIZONTAL && len+col <= grid.numCols())
            {
                return true;
            }
            else if(dir == VERTICAL && len+row <= grid.numRows())
            {
                return true;
            }
        }
        return false;
    }


    /**
     * Code to determine if ship is able to be placed at given location
     * Must check two things:
     *   if it goes off the grid
     *   if there is already a ship in the location
     */
    public boolean canPlaceShip(Grid grid, Ship s)
    {
        int row = s.getRow();
        int col = s.getCol();
        int dir = s.getDirection();
        int len = s.getLength();
        if(inBounds(grid, s, row, col))
        {
            if(dir == HORIZONTAL)
            {
                for(int i = col; i < col+len; i++)
                {
                    if(myGrid.hasShip(row, i))
                    {
                        return false;
                    }
                }
            }
            
            else if(dir == VERTICAL)
            {
                for(int i = row; i < row + len; i++)
                {
                    if(myGrid.hasShip(i, col))
                    {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean alreadyGuessed(int row, int col)
    {
        if(opponentGrid.getStatus(row, col) == 1 || opponentGrid.getStatus(row, col) == 2)
        {
            return true;
        }
        return false;
    }
    // Adds a ship if it's a legal placement
    // Returns whether the ship was successfully added
    public boolean addShip(Ship s)
    {
        if(canPlaceShip(myGrid, s))
        {
            myGrid.addShip(s);
            numShips++;
            return true;
        }
        return false;
    }
    
    public int getShipLength() {
        int len = SHIP_LENGTHS[length_check];
        return len;
    }

    public int getRandomRowGuess()
    {
        return Randomizer.nextInt(10);
    }


    public int getRandomColGuess()
    {
        return Randomizer.nextInt(10);
    }

    public boolean shipAtLocation(int row, int col)
    {
        if(myGrid.hasShip(row, col))
        {
            return true;
        }
        return false;
    }

    public void setOpponentGrid(Grid grid) {
        opponentGrid = grid;
    }
    
    public boolean makeGuess(int row, int col, Player other)
    {
        boolean val = other.shipAtLocation(row, col);
        markGuess(row, col, val);
        return val;
    }
    
    private void markGuess(int row, int col, boolean val)
    {
        if(val == true)
        {
            opponentGrid.setStatus(row, col, 1);
            totalHitsDelivered++;
        }
        else
        {
            opponentGrid.setStatus(row, col, 2);
        }
    }


    /*
     * Takes in an opponent guess for a row, col location.
     * Records the guess, and returns a boolean indicating
     * whether the guess was a hit.
     */
    public boolean recordOpponentGuess(int row, int col)
    {
        if(myGrid.hasShip(row, col))
        {
            myGrid.markHit(row, col);
            totalHitsTaken++;
            return true;
        }
        else
        {
            myGrid.markMiss(row, col);
            return false;
        }
    }
    
    public int getNumShipsAdded() {
        return numShips;
    }
    
    public Grid getGrid()
    {
        return myGrid;
    }

    public int opponentHitsRemaining() {
        return MAX_HITS - totalHitsDelivered;
    }
    
    public void printHitsDelivered()
    {
        System.out.println(totalHitsDelivered);
    }


    public boolean hasWon()
    {
        if(totalHitsDelivered >= MAX_HITS)
        {
            return true;
        }
        return false;
    }


    public boolean hasLost()
    {
        if(totalHitsTaken >= MAX_HITS)
        {
            return true;
        }
        return false;
    }


    public boolean chooseShipLocation(Ship s, int row, int col, int direction)
    {
        s.setLocation(row, col);
        s.setDirection(direction);
        return addShip(s);
    }
}