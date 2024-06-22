import java.util.Random;

public class Main
{

	public static void main ( String[] args )
	{
		SimpleStartup dot = new SimpleStartup ( );
		int numberOfGuesses = 0;
		GameHelper helper = new GameHelper ( );
		int randomNumber = new Random ( ).nextInt (5);
		int[] locations = {randomNumber, randomNumber + 1, randomNumber + 2};
		dot.setLocationCells (locations);
		boolean isAlive = true;
		while (isAlive) {
			int guess = helper.GetUserInput ("Enter a number");
			String result = dot.checkYourself (guess);
			numberOfGuesses++;
			if (result.equals ("kill")) {
				isAlive = false;
				System.out.println ("You took " + numberOfGuesses + " guesses");
			}
		}
	}
}
