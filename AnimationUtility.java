import io.*;
//Made by Tim McDonald 2014
//Probably only works with one digit parameters in the file
//I havent tested that case yet

public class AnimationUtility
{
	private String filename;
	private TextFile file;
	
	//Animation Class
	private int xlength;
	private int ylength;
	private int framenumber;
	private int waitTime;

	public AnimationUtility(String filenamein)
	{
		filename = filenamein;
		waitTime = 100;
		tryLoading();
		readConfig();


	}


	private void readConfig()
	{
		file.openFile();
		xlength = file.readInt();

		file.clearRestOfLine();
		ylength = file.readInt();

		
		framenumber = file.readInt();
	}

	private TextFile tryLoading()
	{
		file = new TextFile(filename, "r");
		if(validateFile())
			{
				System.out.println("Error: animation file loader is broken. Quitting....");
				System.exit(0);
			}
			return file;
	}

	private boolean validateFile()
	{
		return !((file.readStatus()) && (filename.contains(".wsfe")));
	}

	public void playLooped(int loops)
	{
		for(int i=0;i<=loops;loops++)
		{
			play();
		}
	}

	public void play()
	{
		
		for(int cf=0;cf<framenumber;cf++)
		{
			cls();
			printframe();
			try
			{
				Thread.sleep(waitTime);
			}
			catch(InterruptedException e)
			{
				System.out.println("Thread.sleep didnt work");
			}
			
			System.out.print("\n");
		}
	}


	private void printframe()
	{
		for(int y=0;y<xlength;y++)
			{			
					for(int x = 0; x < ylength; x++)
					{
						char currentChar = file.readChar();
						System.out.print(currentChar);
					}
					file.clearRestOfLine();
					System.out.print("\n");
			}
	}

	public void setWaitTime(int timein)
	{
		waitTime = timein;
	}

	public void setFps(int frameRate)
	{
		waitTime = 1000/frameRate;
	}

	private static void cls()
	{
		for(int i=0;i<=24;i++)
		{
			System.out.print("\n");
		}
	}
}