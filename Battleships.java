import io.*;
public class Battleships extends Map
{
	private Position currentPosition;
	private int hitCount;
	private int missCount;
	private int numberofShips;
	private int turnCount;

	//Battlships Defualt Constructor
	public Battleships( int size_in, TextFile filein )
	{
		//size_in is put into the super class Map's Constructor
		super( size_in );
		loadFileToMap( filein );

		System.out.println( "BATTLESHIPS\n" +
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
		"  ( Art By Matthew Bace )\n" );


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

	//checks if the position that the user entered whether it has hit a ship and handles it
	public void checkHit()
	{
		int x = currentPosition.getX();
		int y = currentPosition.getY();
		char currentTile = getMapElement( x,y );
		//So has the map hit the ship?
		//Btw I used the constant because since battleships IS a map I can therefore access the constant. But it was accessible anyway
		if( currentTile == SHIP )
		{
			//yes now increment the hitcount and set the appropriate map element to shiphit
			alertHit();
			setMapElement( x,y,SHIPHIT );
			hitCount++;
		}
		else
		{
			//handle missing
			System.out.println( "MISS!" );
			missCount++;
		}
	}
	//alert the user that they have hit the target
	private void alertHit()
	{
		System.out.println( "BOOM! Direct Hit" );
	}
	//gives the score to the user once the game has been completed
	public void giveScore()
	{
		outputMap();
		System.out.println( "Congratulations!\nYou win!\nNumber of Ships That Got Destroyed:" +
								getHitCount() + 
								"\nNumber of Times that You Missed:" +
				 				getMissCount() +
				  				"\nAscii Explosion By jnh" );
	}

	public void inputAndValidate()
	{
		int x,y;
		int size = getMapSize();
		
		//asks the user if they want to see the map and outputs if its true
		if( askToSeeMap() == true )
		{
			outputMap();
		}
		do
		{
			System.out.println( "Input x Coordinate: " );
			x = ConsoleInput.readInt();
			System.out.println( "Input y Coordinate: " );
			y = ConsoleInput.readInt();
			currentPosition = new Position( x,y );
			if( coordsAreInvalid() )
			{
				System.out.println( "\nInput is invalid: "+
				"Please input numbers between the 0 and the size of the map" );
			}
		}while( coordsAreInvalid() );
		
	}
	//checks if the coordinates are valid or not. Ie within the map. 
	//for it to be valid x greater than or equal to 0 and less than size
	//same with y
	//so it just checks if it is invalid
	private boolean coordsAreInvalid()
	{
		int x = currentPosition.getX();
		int y = currentPosition.getY();
		int size = getMapSize();
		return !( x < size && x >= 0 && y < size && y >= 0 );

	}

	//basically just asks for a "yes" from the user to show the map
	private boolean askToSeeMap()
	{
		//by default if yes is not entered then i am not interested
		boolean returnVal = false;
		System.out.println( "Do you want to see the map?" );
		String userInput = ConsoleInput.readWord();
		//checks if the user has entered yes
		if( userInput.equals( "yes" ) || userInput.equals( "y" ) )
		{
			returnVal = true;
		}
		return returnVal;
	}
	//loads the Textfile ( which is assumed open and valid and in reading mode )
	//cycles through the file and simultaniously
	private void loadFileToMap( TextFile filein )
	{
		int size = getMapSize();
		for( int y=0;y<size;y++ )
		{
			for( int x=0;x<size;x++ )
			{
				char currentChar = filein.readChar();
				setMapElement( x,y,currentChar );
			}
			filein.clearRestOfLine();
		}

	}

	//scans through the Map and outputs it to the display with a newline after each line of x coords
	public void outputMap()
	{
		int size = getMapSize();
		for( int y=0;y<size;y++ )
		{			
				for( int x = 0; x < size; x++ )
				{
					System.out.print( getMapElement( x,y ) );
				}
				System.out.print( "\n" );
		}
		System.out.print( "\n" );
    }
    //checks if the game is over by scanning through the map and checking if there no ships left
	public boolean isGameOver()
	{
		boolean returnVal = true;
		int size = getMapSize();
		for( int y=0;y<size;y++ )
		{
			for( int x=0;x<size;x++ )
			{
				if( getMapElement( x,y ) == SHIP )
				{
					returnVal = false;
				}
			}
		}
		turnCount++;
		return returnVal;
    }
}