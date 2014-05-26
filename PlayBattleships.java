import io.*;


public class PlayBattleships
{
	//This is just a 
	
	public static void loadFileToMap(Map mapin,TextFile filein)
	{
		int size = mapin.getMapSize();
		for(int y=0;y<size;y++)
		{
			for(int x=0;x<size;x++)
			{
				char currentchar = filein.readChar();
				mapin.setMapElement(x,y,currentchar);
				System.out.print(currentchar);
			}
			System.out.print("\n");
			filein.clearRestOfLine();
		}

	}




	public static void main(String [] args) 
	{
		/*Tell the user to put in a filename but politely suggest to get the */
		System.out.println("Make sure the map file is the following format \n"+
		"<filename>.dat \n the test file is named: \n" +
		"game1.dat \n Enter FileName: ");
		/*Get the name of the file from the user in the form of a string
		store it into the string called filename*/
		String filename = ConsoleInput.readWord();
		/*Create an instance of map reader with the previous filename that the user entered*/
		TextFile file = new TextFile(filename, "r");
		//open the file
		file.openFile();
		//get the size from the file to put into the Battleships class
		int size = file.readInt();
		file.clearRestOfLine();
		Battleships battleship = new Battleships(size);	
		loadFileToMap(battleship,file);
		while(!(battleship.isGameOver()))
		{
			battleship.inputAndValidate();
			battleship.checkHit();
			battleship.outputMap();
		}
			System.out.println("Congratulations!\nYou win!\nNumber of Ships That Got Destroyed:" +
								battleship.getHitCount() + 
								"\nNumber of Times that You Missed:" +
				 				battleship.getMissCount() +
				  				"\n");
	}
}
