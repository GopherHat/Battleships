import io.*;

public class Battleships extends Map
{
	private Position currentPosition;
	private int hitCount;
	private int missCount;
	private int turnCount;

	//Battlships Defualt Constructor
	public Battleships(int size_in, TextFile filein)
	{
		//size_in is put into the super class Map's Constructor
		super(size_in);
		loadFileToMap(filein);

		System.out.println("BATTLESHIPS\n" +
"                                     |__\n"+
"                                     |\\/\n"+
"                                     ---\n"+
"                                     / | [\n"+
"                              !      | |||\n"+
"                            _/|     _/|-++'\n"+
"                        +  +--|    |--|--|_ |-\n"+
"                     { /|__|  |/\\__|  |--- |||__/\n"+
"                    +---------------___[}-_===_.'____                 /\\\n"+
"                ____`-' ||___-{]_| _[}-  |     |_[___\\==--            \\/   _\n"+
" __..._____--==/___]_|__|_____________________________[___\\==--____,------' .7\n"+
"|                                                                     BB-61/\n"+
" \\_________________________________________________________________________|\n"+
"  (Art By Matthew Bace)\n");


		//Since the game has just been created the default constructor
		//defualt settings for beginining of game
		hitCount = 0;
		missCount = 0;
		turnCount = 0;
	}

	private int getHitCount()
	{
		return hitCount;
	}

	private int getMissCount()
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
				alertHit();
				setMapElement(x,y,Map.SHIPHIT);
				hitCount++;
		}
		else
		{
				alertMiss();
				missCount++;
		}
	}

	private void alertMiss()
	{
		AnimationUtility miss = new AnimationUtility("missfire.wsfe");
		miss.play();
		System.out.println("\033[36;1m");
		AnimationUtility explode1 = new AnimationUtility("explode.wsfe");
		explode1.setFps(20);
		explode1.play();
		System.out.println("MISS!");
		System.out.println("\033[31;0m");
		
	}
	private void alertHit()
	{
		
		AnimationUtility missle = new AnimationUtility("missleship.wsfe");
		missle.setWaitTime(250);
		missle.play();
		System.out.println("\033[31;1m");
		AnimationUtility explode = new AnimationUtility("explode.wsfe");
		explode.play();
		System.out.println("BOOM!");
		System.out.println("\033[31;0m");
	}

	public void giveScore()
	{
		System.out.println("Congratulations!\nYou win!\nNumber of Ships That Got Destroyed:" +
								getHitCount() + 
								"\nNumber of Times that You Missed:" +
				 				getMissCount() +
				  				"\nAscii Explosion By jnh");
	}

	public void inputAndValidate()
	{
		int x,y;
		int size = getMapSize();
		

		if(askToSeeMap() == true)
		{
			outputMap();
		}
		do
		{
			System.out.println("Input x Coordinate: ");
			x = ConsoleInput.readInt();
			System.out.println("Input y Coordinate: ");
			y = ConsoleInput.readInt();
			currentPosition = new Position(x,y);
			if(coordsAreInvalid())
			{
				System.out.println("\nInput is invalid: "+
				"Please input numbers between the 0 and the size of the map");
			}
		}while(coordsAreInvalid());
		
	}

	private boolean coordsAreInvalid()
	{
		int x = currentPosition.getX();
		int y = currentPosition.getY();
		int size = getMapSize();

		return !(x < size && x >= 0 && y < size && y >= 0);

	}


	private boolean askToSeeMap()
	{
		boolean returnVal = false;
		System.out.println("Do you want to see the map?");
		String userInput = ConsoleInput.readWord();
		if(userInput.equals("yes"))
		{
			returnVal = true;
		}
		return returnVal;
	}

	private void loadFileToMap(TextFile filein)
	{
		int size = getMapSize();
		for(int y=0;y<size;y++)
		{
			for(int x=0;x<size;x++)
			{
				char currentChar = filein.readChar();
				setMapElement(x,y,currentChar);
			}
			filein.clearRestOfLine();
		}

	}


	public void outputMap()
	{
		mapAnimation();
		
		int size = getMapSize();
		for(int y=0;y<size;y++)
		{			
		System.out.print("\033[46;0m");
				for(int x = 0; x < size; x++)
				{
					char currentTile = getMapElement(x,y);
					assignColours(currentTile,x,y);
					System.out.print(currentTile);
					
				}
				System.out.print("\033[44;0m");
				System.out.print("\n");
		}
		//reset the colour back to black
		System.out.print("\033[36;0m");
		
		System.out.print("\n");
    }

    public void assignColours(char tileIn,int x,int y)
    {
    	
    	if(tileIn == Map.OCEAN)
    		System.out.print("\033[34;1m");
    	if(tileIn == Map.SHIPHIT)
    		System.out.print("\033[31;1m");
    	if(tileIn == Map.SHIP)
    		System.out.print("\033[32;1m");
    }

    private void mapAnimation()
    {
    	AnimationUtility mapOpen = new AnimationUtility("openmap.wsfe");
    	mapOpen.play();
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
		turnCount++;
		return returnVal;
    }
}