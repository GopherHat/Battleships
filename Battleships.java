import io.*;
public class Battleships extends Map
{
	private TextFile file;
	private String filename;
	private Position currentPosition;
	private int hitCount;
	private int missCount;

	//Battlships Defualt Constructor
	//Inputs size_in
	public Battleships(int size_in)
	{
		//size_in is put into the super class Map's Constructor
		super(size_in);
		//Since the game has just been created the default constructor
		//defualt settings for beginining of game
		hitCount = 0;
		missCount = 0;
	}

	//getter for hitCount
	public int getHitCount()
	{
		return hitCount;
	}
	//getter for missCount
	public int getMissCount()
	{
		return missCount;
	}

	public void checkHit()
	{
		int x = currentPosition.getX();
		int y = currentPosition.getY();
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
		int size = getMapSize();
		do
		{
			System.out.println("Input x Coordinate: ");
			x = ConsoleInput.readInt();
			System.out.println("Input y Coordinate: ");
			y = ConsoleInput.readInt();
			if(!(x < size || y < size))
			{	
				System.out.println("\nInput is invalid: "+
				"Please input a number between the 0 and the size of the map");
			}
		}while(!(x < size || y < size));
		currentPosition = new Position(x,y);
	}


	public void outputMap()
	{
		int size = getMapSize();
		for(int y=0;y<size;y++)
	   	{			
	   			for(int x = 0; x < size; x++)
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
		int size = getMapSize();
		for(int y=0;y<size;y++)
		{
			for(int x=0;x<size;x++)
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