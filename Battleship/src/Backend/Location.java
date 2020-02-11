package Backend;

public class Location
{
    public static final int UNGUESSED = 0;
    public static final int HIT = 1;
    public static final int MISSED = 2;
    
    private boolean ship;
    private int status;
    
    public Location()
    {
        
    }
    
    public boolean checkHit()
    {
        if(this.status == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean checkMiss()
    {
        if(this.status == 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean isUnguessed()
    {
        if(status == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void markHit()
    {
        this.status = 1;
    }
    
    public void markMiss()
    {
        this.status = 2;
    }
    
    public boolean hasShip()
    {
        return this.ship;
    }
    
    public void setShip(boolean val)
    {
        this.ship = val;
    }
    
    public void setStatus(int status)
    {
        this.status = status;
    }
    
    public int getStatus()
    {
        return this.status;
    }
}
