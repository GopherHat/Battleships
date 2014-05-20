public class Map
{
//Written by Mike Robey, Feb 12th 2014.

private char theMap[][];
private int size;
/**********************Class Fields*****************************
 * theMap:  A 2D array containing the map data where element   *
 *          0,0 represents the top left hand corner of the map *
 * size: The map  is always square and size represents its dim-*
 *       ensions. Note Java arrays have a legth class field but*
 *       its more convenient to have this class field.         *
 ***************************************************************/

public static final char          SHIP = '#';
public static final char         OCEAN = '-';
public static final char       SHIPHIT = 'X';
public static final char       INVALID = '?';
public static final char UNINITIALISED = '*';
public static final int        MAXSIZE = 30;

public Map()
   {
   size = 10;
   theMap = new char[10][10];
   initialiseMap();
   }

public Map( int inSize)
   {
   size = 10;
   if (( 0 <= inSize) && ( inSize <= MAXSIZE ))
      size = inSize;

   theMap = new char[size][size];
   initialiseMap();
   }
// this class has no copy constructor

public void setMapElement( int inRow, int inCol, char inValue)
   {
   char value;
   if ( validateMapValue( inValue) && validateCoords( inRow, inCol))
      theMap[inRow][inCol] = inValue;
   }

public char getMapElement( int inRow, int inCol)
   {
   char value;

   if ( validateCoords( inRow, inCol))
      value = theMap[inRow][inCol];
   else
      value = INVALID;
   return value;
   }

public int getMapSize()
   {
   return size;
   }

// no equals method and no toString methid required

private boolean validateMapValue( char value)
   {
   return (( value == SHIP ) || ( value == OCEAN ) || ( value == SHIPHIT ));
   }

private boolean validateCoords( int row, int col)
   {
   return ( (( 0 <= row ) && ( row < size )) && 
            (( 0 <= col ) && ( col < size )) );
   }

private void initialiseMap()
   {
   f int row = 0; row<size; row++)
      for( int col = 0; col<size; col++)
         theMap[row][col] = UNINITIALISED;
   }
}
