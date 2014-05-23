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
	}

	public int getSize(){return size;}

	public void readAndOutputFile()
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
		file.openFile();
		readSizeFromFile();
		readMapFromFile();

	}

	private void readSizeFromFile()
	{
		size = file.readInt();
		file.newLine();
	}

	private void readMapFromFile()
	{
		for(int x=0;x<size;x++)
		{
    	   		for(int y = 0; y < size; y++)
    	   		{
    	   			file.readChar();
	    	           		file.printIt(map.getMapElement(x, y));	
    	   		}
    	    		file.newLine();
		}
       	 }

}


		/*public static void main(String [] args)
		{
			filename = inputFilename(); 
			//put the textfile object into read mode to read the file : filename
			Battleships battleship = new Battleships(filename);
			battleship.readAndOutputFile();
		}*/


   