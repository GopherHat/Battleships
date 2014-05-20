package CypherString;

public class CypherStringClass
{
private char [] str;
private int     len;

public CypherStringClass( String message)
   {
   str = new char [message.length()];
   len = message.length();
   for(int i=0; i<len;i++)
     str[i] = message.charAt(i);
   }

public char getCharAt( int pos)
   {
   char ch = ' ';
   if (( pos >=0 ) && ( pos < len ))
      ch = str[pos];
   return ch;
   }

public void setCharAt( int pos, char ch)
   {
   if (( pos >= 0 ) && ( pos < len ))
      str[pos] = ch;
   }

public String toString()
   {
   return new String( str);
   }
public int length()
   {
   return len;
   }
}