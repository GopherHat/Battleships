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
	public Position(int xin,int yin)
	{
		x = xin;
		y = yin;
	}

	//Copy Constructor
	public Position(Position pos_in)
	{
		//Keep in mind that I could have done this:
		//this(pos_in.getX(),pos_in.getY(),pos_in.getSize());
		//Compiles and works
		setX(pos_in.getX());
		setY(pos_in.getY());
		
		
	}

	int getX(){return x;}
	int getY(){return y;}



	private void setY(int yin)
	{
		y = yin;
	}	

	private void setX(int xin)
	{
		x = xin;
	}

}