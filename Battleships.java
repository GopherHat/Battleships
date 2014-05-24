import io.*;
public class Battleships extends Map
{
	private TextFile file;
	private String filename;
	private Position currentPosition;
	private int hitCount;
	private int missCount;


	public Battleships(int size_in)
	{
		super(size_in);
		hitCount = 0;
		missCount = 0;
	}


	public int getRekt()
	{
		return hitCount;
	}

	public int getShrekt()
	{
		return missCount;
	}

	public void checkHit()
	{
		int x = currentPosition.getX();
		int y=currentPosition.getY();
		char currentTile = getMapElement(x,y);
		if(currentTile == Map.SHIP)
			{
				setMapElement(x,y,Map.SHIPHIT);
				hitCount++;
			}
		else
			{
				missCount++;
			}
	}

	public void inputAndValidate()
	{
		int x,y;
		do
		{
			System.out.println("Input x Coordinate: ");
			x = ConsoleInput.readInt();
			System.out.println("Input y Coordinate: ");
			y = ConsoleInput.readInt();
		}while(!(x < getMapSize() || y < getMapSize()));
		currentPosition = new Position(x,y);
	}


	public void outputMap()
	{
		
		for(int y=0;y<getMapSize();y++)
	   	{			
	   			for(int x = 0; x < getMapSize(); x++)
	   			{
    	           	System.out.print(getMapElement(x,y));
	   			}
	   			System.out.print("\n");
	   	}
	   	System.out.print("\n");
    }

    public boolean isGameOver()
	{
		boolean returnVal = true;
		for(int y=0;y<getMapSize();y++)
		{
			for(int x=0;x<getMapSize();x++)
			{
				if(getMapElement(x,y) == Map.SHIP)
				{
					returnVal = false;
				}
			}
		}
		return returnVal;
    }
}