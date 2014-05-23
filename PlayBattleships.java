import io.*;
//import TextFile;
//import Map;

public class PlayBattleships
{
	public static void main(String [] args)
	{		
		/*Tell the user to put in a filename but politely suggest to get the */		
		System.out.println("Make sure the map file is the following format \n"+
		"<filename>.dat \n the test file is named: \n" +
		"game1.dat \n Enter FileName: ");
		/*Get the name of the file from the user in the form of a string and store it into 			the string called filename*/
		String filename = ConsoleInput.readLine();
		/*Create an instance of map reader with the previous filename that the user 			entered*/
		Battleships battleship = new Battleships(filename);
		boolean gameIsOn = true;	
		while(gameIsOn)
		{
			System.out.println("Input x Coordinate: ");
			int x = ConsoleInput.readInt();
			System.out.println("Input y Coordinate: ");
			int y = ConsoleInput.readInt();
			Position currentpos = new Position(x,y);
			battleship.setPos(currentpos);
			battleship.update();
			battleship.print();
		}
	}
}
