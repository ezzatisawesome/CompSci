public class Grid
{
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLS = 10;
    
    private Location[][] grid;
    
    public Grid()
    {
        grid = new Location[NUM_ROWS][NUM_COLS];
        for(int i = 0; i < NUM_ROWS; i++)
        {
            for(int j = 0; j < NUM_COLS; j++)
            {
                grid[i][j] = new Location();
            }
        }
    }
    
    public void addShip(Ship s)
    {
        int length = s.getLength();
        int row = s.getRow();
        int col = s.getCol();
        int direction = s.getDirection();
        if(direction == 0)
        {
            for(int i = 0; i < length; i++)
            {
                grid[row][col+i].setShip(true);
            }
        }
        else
        {
            for(int i = 0; i< length; i++)
            {
                grid[row+i][col].setShip(true);
            }
        }
    }
    
    public void markHit(int row, int col)
    {
        grid[row][col].markHit();
    }
    
    public void markMiss(int row, int col)
    {
        grid[row][col].markMiss();
    }
    
    public void setStatus(int row, int col, int status)
    {
        grid[row][col].setStatus(status);
    }
    
    public int getStatus(int row, int col)
    {
        return grid[row][col].getStatus();
    }
    
    public boolean alreadyGuessed(int row, int col)
    {
        return(!grid[row][col].isUnguessed());
    }
    
    public void setShip(int row, int col, boolean val)
    {
        grid[row][col].setShip(val);
    }
    
    public boolean hasShip(int row, int col)
    {
        return grid[row][col].hasShip();
    }
    
    public Location get(int row, int col)
    {
        return grid[row][col];
    }
    
    public int numRows()
    {
        return NUM_ROWS;
    }
    
    public int numCols()
    {
        return NUM_COLS;
    }
    
    public void printStatus()
    {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for(int i = 0; i < NUM_COLS; i++)
        {
            System.out.print((char)(i+65));
            System.out.print(" ");
            for(int j = 0; j < NUM_COLS; j++)
            {
                int stat = grid[i][j].getStatus();
                if(stat == 0)
                {
                    System.out.print("-");
                }
                else if(stat == 1)
                {
                    System.out.print("X");
                }
                else
                {
                    System.out.print("O");
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    
    public void printShips()
    {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for(int i = 0; i < NUM_COLS; i++)
        {
            System.out.print((char)(i+65));
            System.out.print(" ");
            for(int j = 0; j < NUM_COLS; j++)
            {
                if(grid[i][j].hasShip())
                {
                    System.out.print("X");
                }
                else
                {
                    System.out.print("-");
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
