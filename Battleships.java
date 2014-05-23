import io.*;
public class Battleships 
{
private Map map;
private TextFile file;
private String filename;
private int size;
private Position currentPosition;


	public Battleships(String filenamein)
	{
		filename = filenamein;
		file = new TextFile(filename, "r");
		file.openFile();
	}



	public void setPos(Position pos_in)
	{
		currentPosition = new Position(pos_in);
	}

	public int getSize(){return size;}


	public void inputAndValidate()
	{
		int x,y;
		do
		{
			System.out.println("Input x Coordinate: ");
			x = ConsoleInput.readInt();
			System.out.println("Input y Coordinate: ");
			y = ConsoleInput.readInt();
		}while(x < size || y < size);
		currentPosition = new Position(x,y);
	}

	private void readAndOutputFile()
	{
		System.out.println("Here is the contents of the file " + filename + ":");
		readFile();
	}

	public String inputFilename()
	{
		//TODO Validate?
		return ConsoleInput.readLine("Enter the name of the map:");
	}
	public void readFile()
	{
		if(file.openFile())
		{
			readSizeAndPrint();
		 	readandOutputMap();
		}
		else
		{
			System.out.println("Unable to properly open the file. Are you sure that the filename is valid. Does the file even exist?");
		}
	}

	private void readSizeAndPrint()
	{
		size = file.readInt();
		
	}

	private void readandOutputMap()
	{
		System.out.println("The file is opened");
		System.out.println(size);
		for(int x=0;x<=size;x++)
	   	{			
	   			for(int y = 0; y < size; y++)
	   			{
    	        	char currentchar = file.readChar();

    	           	System.out.print(currentchar);
	   			}

	   			if(file.endOfFile())
	   			{
	   				System.out.print("\n");
	   			}
	   	}
	   	System.out.print("\n");
    }

    private boolean checkIfGameIsNotOver()
	{
		boolean returnval = false;
		while(!file.endOfFile())
		{
			if(file.readChar() == Map.SHIP)
			{
				returnval = true;
			}
		}
		return returnval;
    }





}


		/*public static void main(String [] args)
		{
			filename = inputFilename(); 
			//put the textfile object into read mode to read the file : filename
			Battleships battleship = new Battleships(filename);
			battleship.readAndOutputFile();
		}*/


   