/*INPUT name
create an instance of Map
create an instance of textfile
input the file into memory
while the game is still going
        input Position
        process the input to the map
        print out the map result form the memory
loop
*/


/**Position class
 * This class has three fields.
 * x , y and size.
 */

import io.*;
public class Position
{
	
	private int x;
	private int y;
	private int size;
	public Position(int xin,int yin,int sizein)
	{
		x = xin;
		y = yin;
		size = sizein;
	}
	public Position(int sizein)
	{
		size = sizein;
		System.out.println("Input the X Coordinate:");
		inputAndValidate(x,size);
		System.out.println("Input the Y Coordinate:");
		inputAndValidate(y,size);
	}
	//Copy Constructor
	public Position(Position pos_in)
	{
		//Keep in mind that I could have done this:
		//this(pos_in.getX(),pos_in.getY(),pos_in.getSize());
		//Compiles and works
		setX(pos_in.getX());
		setY(pos_in.getY());
		setSize(pos_in.getSize());
		
	}

	int getX(){return x;}
	int getY(){return y;}
	int getSize(){return size;}
	private int inputAndValidate(int coord,int size)
	{
		//sneaky way to enter the while loop
	    coord += size;
	    while(0 <= coord && coord <= size)
		{
	    	coord = inputCoord();
		}
	        return coord;
	}

	int inputCoord()
	{
		int coord = ConsoleInput.readInt();
	    return coord;
	}
		
	private void setY(int yin)
	{
		y = yin;
	}	

	private void setX(int xin)
	{
		x = xin;
	}
	private void setSize(int sizein)
	{
		size = sizein;
	}
}