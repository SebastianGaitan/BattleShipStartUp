import java.lang.reflect.Array;
import java.util.ArrayList;

public class StartUp
{
	//Declare and initialize variables
	private ArrayList <String> locationCells;
	private String name;

	public void setLocationCells ( ArrayList <String> location )
	{
		this.locationCells = location;
	}

	public void setName ( String name )
	{
		this.name = name;
	}

	public String checkYourself ( String userInput )
	{
		String result = "miss";
		//Checks if the user's guess is in the ArrayList of locationCells if not it returns -1 if yes it returns the index
		int index = locationCells.indexOf (userInput);
		System.out.println ("Index: " + index);
		if ( index >= 0 ) {
			locationCells.remove (index);
			if ( locationCells.isEmpty ( ) ) {
				result = "kill";
				System.out.println ("Ouch! You sunk " + name + " :(");
			} else {
				result = "hit";
			}
		}
		return result;
	}
}
