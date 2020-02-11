package Backend;

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
    
    public String[][] getGridStatus()
    {
        String[][] gridData = new String[10][10];
        for(int i = 0; i < NUM_COLS; i++)
        {
            for(int j = 0; j < NUM_COLS; j++)
            {
                int stat = grid[i][j].getStatus();
                if(stat == 0)
                {
                    gridData[i][j] = "-";
                }
                else if(stat == 1)
                {
                    gridData[i][j] = "X";
                }
                else
                {
                    gridData[i][j] = "O";
                }
            }
        }
        return gridData;
    }
    
    public String[][] getGridShips()
    {
        String[][] shipStatus = new String[10][10];
        for(int i = 0; i < NUM_COLS; i++)
        {
            for(int j = 0; j < NUM_COLS; j++)
            {
                if(grid[i][j].hasShip())
                {
                    shipStatus[i][j] = "X";
                }
                else
                {
                    shipStatus[i][j] = "-";
                }
            }
        }
        return shipStatus;
    }
}
