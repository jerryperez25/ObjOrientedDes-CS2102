import java.util.LinkedList;
/**
 * 
 * @author jperez2
 * creates a class called AdvancedRound that contains a linked list of matches played in that round and contestants for winners of the previous round
 */
public class AdvancedRound extends AbsRound
{
	LinkedList<Match> matches;
	LinkedList<IContestant> winners;
	
	public AdvancedRound (LinkedList<Match> matches, LinkedList<IContestant> winners)
	{
		this.matches = matches;
		this.winners = winners;
	}
	
	public AdvancedRound()
	{
	}
	/**
	 * does not need an input because we will be directly calling it with an advancedround
	 * @param takes in a contestant, or IContestant
	 * @return list of winners, or contestants, that won
	 */
	public LinkedList<IContestant> getMatchWinners()
	
	{
		for (Match m : matches) // for each match in my list of matches 
		{ 
			winners.add(m.winner()); //call the winner function that determines the winner and add that winner to a newly formed linked list of contestants 
		}
		return winners;
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
	 * @return a boolean that returns true if the winner is in the list and false if the winner is not in the list
	 */
	public boolean isWinner(IContestant thisone)
	{
		for (IContestant a : winners) // for every contestant in my list of contestants 
		{
			if (thisone == a)	// if the contestant that is passed in is in the list, then return true 
			{
				return true;
			}
		}
		return false;	//otherwise return false
	}
}
