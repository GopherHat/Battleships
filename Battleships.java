import io.*;
public class Battleships extends Map
{
	private Position currentPosition;
	private int hitCount;
	private int missCount;
	private int turnCount;
	//This is just used cosmetically to clear the line after everything

	//Battlships Defualt Constructor
	//Inputs size_in
	public Battleships(int size_in, TextFile filein)
	{
		//size_in is put into the super class Map's Constructor
		super(size_in);
		loadFileToMap(filein);
		cls();
		System.out.println("BATTLESHIPS" +
"	                                                                             \n"+
"                         `-              . .                                    \n"+
"                          :              ..h.                                   \n"+
"                         .o        `..:  :odh/                                  \n"+
"                       .--y....` `-+hdm-`-yhho-/.``                             \n"+
"               ``.``-`/oh/syhhhyyyyyhhds+ohhdhyyyys:/o+/..-.``                  \n"+
"-------:--:/+s+syyysyshhhhhhhdhhhyhhhyyhhhhhyhhhhhhyyhhy//yyyy/++:::::::::+:://-\n"+
".+yyyyyyyyyhhhhhhhhhhhhhhhhhyyyyyyyyyyyyyyyyyyyyyyyyhhhhhhhhhhyyyssssssssssssy- \n"+
"  ``:soyyhdhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhy  \n");

		//Since the game has just been created the default constructor
		//defualt settings for beginining of game
		hitCount = 0;
		missCount = 0;
	}
	private void cls()
	{
		for(int i=0;i<24;i++)
		System.out.println("\n");
	}
	public int getHitCount()
	{
		return hitCount;
	}

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
				alertHit();
				setMapElement(x,y,Map.SHIPHIT);
				hitCount++;
			}
		else
			{
				System.out.println("MISS!");
				missCount++;
			}
	}
	private void alertHit()
	{
		System.out.println("BOOM!");
		System.out.println( "            --_--\n"+
							"         (  -_    _).\n"+
							"       ( ~       )   )\n"+
							"     (( )  (    )  ()  )\n"+
							"      (.   )) (       )\n"+
							"        ``..     ..``\n"+
							"             | |\n"+
							"           (=| |=)\n"+
							"             | |         \n"+
							"         (../( )\\.))");
				System.out.println("" +
		"	                                                                             \n"+
		"             /\\            `-              . .                                 \n"+
		"            (  )           :      /)        ..h.                                \n"+
		"          ' )  \\           .o    ( \\ `..:  :odh/              (\\             \n"+
		"         , (    \\    .--y....\\*|`-+h\\  `-yhho-/.``           |  )            \n"+
		"           /   ``.``-`/oh/syhhhyyyyyhhd/  hhdhyyyys:/o+/..-.`` / /) \\          \n"+
		"-------:--:/+s+syyysyshhhhhhhdhhhyhhhyy>  hhyhhhhhhyyhhy//yyyy/++:::::::::+:://-\n"+
		".+yyyyyyyyyhhhhhhhhhhhhhhhhhyyyyyyyyyyy>  yyyyyyyyyyhhhhhhhhhhyyyssssssssssssy- \n"+
		"  ``:soyyhdhhhhhhhhhhhhhhhhhhhhhhhhhhh/   \\hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhy \n");

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
			if(!(x < size || y < size))
			{
				System.out.println("\nInput is invalid: "+
				"Please input a number between the 0 and the size of the map");
			}
		}while(!(x < size || y < size));
		currentPosition = new Position(x,y);
	}

	private boolean askToSeeMap()
	{
		boolean returnval = false;
		System.out.println("Do you want to see the map?");
		String userInput = ConsoleInput.readWord();
		if(userInput.equals("yes"))
		{
			returnval = true;
		}
		return returnval;
	}

	private void loadFileToMap(TextFile filein)
	{
		int size = getMapSize();
		for(int y=0;y<size;y++)
		{
			for(int x=0;x<size;x++)
			{
				char currentchar = filein.readChar();
				setMapElement(x,y,currentchar);
			}
			filein.clearRestOfLine();
		}

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