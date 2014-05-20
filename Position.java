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
	int getx(){return x;}
	int gety(){return y;}
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
		
	private void sety(int yin)
	{
		y = yin;
	}	

	private void setx(int xin)
	{
		x = xin;
	}	
}