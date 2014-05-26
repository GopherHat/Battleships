/**Position class
 * This class has two fields.
 * ints x and y
 *x is the X coordinate in the grid, such as in a Map
 * the start of a coordinate is 0 and the last one is the size of the array
 */

import io.*;
public class Position
{
	//The X coordinate of the position Object
	private int x;
	//The Y coordinate of the position Object
	private int y;
	
	//Default Constructor for the Position class
	//Takes two inputs of integers
	//the x coordinate and the y coordinate
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

//Getters 
	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
//Setters
	private void setY(int yin)
	{
		y = yin;
	}	

	private void setX(int xin)
	{
		x = xin;
	}

}