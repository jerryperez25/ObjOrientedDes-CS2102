import java.util.LinkedList;
/**
 * 
 * @author jperez2
 * creates a class called InitRound that contains a linked list of matches played in that round 
 * 
 */
public class InitRound extends AbsRound
{
	LinkedList<Match> matches;
	
	public InitRound(LinkedList<Match> matches) 
	{
		this.matches = matches;
	}
	
	public InitRound()
	{
		
	}
	/**
	 * does not need an input because we will be directly calling it with an initround
	 * @return list of winners, or contestants, that won
	 */
	public LinkedList<IContestant> getMatchWinners()
	
	{
		
		LinkedList<IContestant> result = new LinkedList<IContestant>();
		
		for (Match m : matches) // for each match in my list of matches
		{ 
			result.addFirst(m.winner()); // check m.winner and add it to the result list
		}
		return result;
	}
	/**
	 * does not need to take an input type because we will be calling it with a round
	 * @return an integer of the number of winners in the newly created winners list
	 */
	public int getNumWinners()
	
	{
		int counter = 0;
		counter = this.getMatchWinners().size();
		return counter;
	}
	/**
	 * this is an overloaded function from AbsRound that determines if the winner is in the list of winners
	 * @param takes in a contestant, or IContestant 
	 * @return a boolean that returns true if the winner is in the list and false if the winner is not in the list
	 */
	public boolean isWinner(IContestant thisone)
	
	{
		for (IContestant a : this.getMatchWinners())
		{
			if (thisone == a)
			{
				return true;
			}
		}
		return false;
	}
}
