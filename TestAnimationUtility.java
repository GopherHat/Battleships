import io.*;
public class TestAnimationUtility
{
	public static void main(String [] args)
	{
		AnimationUtility animation = new AnimationUtility("openmap.wsfe");
		animation.play();
		System.out.println("Test Complete");
		System.exit(0);
	}
}