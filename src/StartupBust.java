import java.util.ArrayList;


public class StartupBust
{
	private GameHelper helper = new GameHelper ( );
	private ArrayList <StartUp> startups = new ArrayList <StartUp> ( );
	private int numOfGuesses = 0;

	public static void main ( String[] args )
	{
		StartupBust game = new StartupBust ( );
		game.SetUpGame ( );
		game.StartPlaying ( );
	}

	private void SetUpGame ( )
	{
		StartUp one = new StartUp ( );
		one.setName ("Google");
		StartUp two = new StartUp ( );
		two.setName ("Facebook");
		StartUp three = new StartUp ( );
		three.setName ("Twitter");
		startups.add (one);
		startups.add (two);
		startups.add (three);
		System.out.println ("Your goal is to sink three startups");
		System.out.println ("Google, Facebook, Twitter");
		System.out.println ("Try to sink them all in the fewest number of guesses");
		for ( StartUp startup : startups ) {
			ArrayList <String> newLocation = helper.placeStartup (3);
			startup.setLocationCells (newLocation);
		}
	}

	private void StartPlaying ( )
	{
		while ( ! startups.isEmpty ( ) ) {
			String userGuess = helper.GetUserInput ("Enter a guess");
			checkUserGuess (userGuess);
		}
		finishGame ( );
	}

	private void checkUserGuess ( String userGuess )
	{
		numOfGuesses++;
		String result = "miss";
		for ( StartUp startup : startups ) {
			result = startup.checkYourself (userGuess);
			if ( result.equals ("hit") ) {
				break;
			}
			if ( result.equals ("kill") ) {
				startups.remove (startup);
				break;
			}
		}
		System.out.println (result);
	}

	private void finishGame ( )
	{
		System.out.println ("All startups are dead! Your stock is now worthless.");
		if ( numOfGuesses <= 18 ) {
			System.out.println ("It only took you " + numOfGuesses + " guesses.");
			System.out.println ("You got out before your options sank.");
		} else {
			System.out.println ("Took you long enough. " + numOfGuesses + " guesses.");
			System.out.println ("Fish are dancing with your options.");
		}
	}
}
