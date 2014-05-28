import io.*;


public class PlayBattleships
{
	//This is just a 

	public static void main(String [] args) 
	{
		String filename;
		TextFile file;
		do
		{
			System.out.println("Make sure the map file is the following format \n"+
			"<filename>.dat \nthe test file is named: game1.dat \n" + "To Quit the game Ctrl + C\n"+ "Enter FileName: ");
			filename = ConsoleInput.readWord();
			file = new TextFile(filename, "r");
			file.openFile();
		}while(!file.readStatus());

		//get the size from the file to put into the Battleships class
		int size = file.readInt();
		file.clearRestOfLine();
		
		System.gc();
		
		//Game Logic
		Battleships battleship = new Battleships(size,file);
		while(!(battleship.isGameOver()))
		{
			battleship.inputAndValidate();
			battleship.checkHit();
		}
		battleship.giveScore();	
	}
}
