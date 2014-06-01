import io.*;
//Prototyping, testing the concept
//No longer compatible with new specs
//DEPRECIATED
public class DoAnimate
{
	public static void main(String [] args) throws InterruptedException
	{
		String filename;
		TextFile file;
		
		//Animation Class
		int size;
		int framenumber;
		//AnimationFrame frame1 = new AnimationFrame();

		do
		{
			System.out.println("Make sure the map file is the following format \n"+
			"<filename>.wsfe \nthe test file is named: test.wsfe \n" + "To Quit the game Ctrl + C\n"+ "Enter FileName: ");
			filename = ConsoleInput.readWord();
			//Propriertary is best
			if(!(filename.contains(".wsfe")))
			{
				System.exit(0);
			}
			file = new TextFile(filename, "r");
			file.openFile();
		}while(!file.readStatus());

		size = file.readInt();
		file.clearRestOfLine();
		framenumber = file.readInt();
		System.out.println(size);
		System.out.println(framenumber);
		//initial wipe of the canvas
		cls();
		printAnimation(size,framenumber,file);

	}


	public static void printAnimation(int sizein,int framenumber,TextFile filein) throws InterruptedException
	{
		for(int cf=0;cf<=framenumber;cf++)
		{
			printframe(sizein,filein);
			Thread.sleep(100);
			cls();
			System.out.print("\n");
		}
	}


	private static void printframe(int sizein,TextFile file)
	{
		for(int y=0;y<sizein;y++)
			{			
					for(int x = 0; x < sizein; x++)
					{
						char currentChar = file.readChar();
						System.out.print(currentChar);
					}
					file.clearRestOfLine();
					System.out.print("\n");
			}
	}

	public static void cls()
	{
		for(int i=0;i<=24;i++)
		{
			System.out.print("\n");
		}
	}
}

