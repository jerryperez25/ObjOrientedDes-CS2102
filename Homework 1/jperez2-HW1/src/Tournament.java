import java.util.LinkedList;
/**
 * 
 * @author jperez2
 * Tournament is a class that contains a linked list of all the rounds that make up the tournament
 */
public class Tournament 
{
	LinkedList<AbsRound> allrounds;
	
	Tournament (LinkedList<AbsRound> allrounds)
	{
		this.allrounds = allrounds;
	}
	Tournament ()
	{
		
	}
	/**
	 * 
	 * @param takes in a contestant, or IContestant
	 * @return a boolean statement indicating whether the contestant that is passed in won at least half of the rounds
	 */
	public boolean finalWinnerIsValid(IContestant winner)
	{
		int counter = 0;
		
		for (AbsRound thisone : allrounds) // for each round in my list of rounds
		{
			if (thisone.isWinner(winner) == true)
			{
				counter = counter+1;
			}
		}
		if (counter >= allrounds.size()/2) // if the number of appearances of the contestant in the list of winners is greater than or equal to half of the size of the data then return true 
		{
			return true;
		}
		return false; //otherwise the statement is false
	}
}
