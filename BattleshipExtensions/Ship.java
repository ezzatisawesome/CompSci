public class Ship
{
    public static final int UNSET = -1;
    public static final int HORIZONTAL = 0; 
    public static final int VERTICAL = 1;
    
    private int row;
    private int col;
    private int length;
    private int direction;
    private boolean alreadySunk;

    public Ship(int length)
    {
        this.length = length;
        this.row = -1;
        this.col = -1;
        this.direction = -1;
        this.alreadySunk = false;
    }
    
    public boolean isLocationSet()
    {
        if(row == -1 && col == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public boolean isDirectionSet()
    {
        if(direction == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public void setAlreadySunk(boolean stat)
    {
        this.alreadySunk = stat;
    }
    
    public void setLocation(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
    
    public void setDirection(int direction)
    {
        this.direction = direction;
    }
    
    public boolean isAlreadySunk()
    {
        return this.alreadySunk;
    }
    
    public int getRow()
    {
        return this.row;
    }
    
    public int getCol()
    {
        return this.col;
    }
    
    public int getLength()
    {
        return this.length;
    }
    
    public int getDirection()
    {
        return this.direction;
    }
    
    public String directionToString()
    {
        if(this.direction == -1)
        {
            return "unset direction";
        }
        else if(this.direction == 0)
        {
            return "horizontal";
        }
        else
        {
            return "vertical";
        }
    }
    
    public String locationToString()
    {
        if(this.row == -1 && this.col == -1)
        {
            return "(unset location)";
        }
        else return "(" + this.row + ", " + this.col + ")";
    }
    
    public String toString()
    {
        return directionToString() + " ship of length " + this.length + " at " + locationToString();
    }
}

