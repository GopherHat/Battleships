import io.*;
public class Battleships extends Map
{
private TextFile file;
private String filename;
private Position currentPosition;


	public Battleships(int size_in)
	{
		super(size_in);
	}

	public void checkHit()
	{
		int x = currentPosition.getX();
		int y=currentPosition.getY();
		char currentTile = getMapElement(x,y);
		if(currentTile == Map.SHIP)
			{setMapElement(x,y,Map.SHIPHIT);}
	}

	public void setPos(Position pos_in)
	{
		currentPosition = new Position(pos_in);
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
		boolean returnval = true;
		for(int x=0;x<getMapSize();x++)
		{
			for(int y=0;y<getMapSize();y++)
			{
				if(getMapElement(x,y) == Map.SHIP)
				{
					returnval = false;
				}
			}
		}
		return returnval;
    }
}