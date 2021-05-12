import java.util.LinkedList;
/**
 * 
 * @author jperez2
 * AbsRound is an abstract class that holds all common fields and methods for InitRound and AdvancedRound
 */
public abstract class AbsRound implements IWinner
{
	// constructors do not need JavaDoc
	LinkedList<Match> matches;
	AbsRound (LinkedList<Match> matches)
	{
		this.matches = matches;
	}
	AbsRound()
	{
		
	}
	/**
	 * 
	 * @param IContestant thisone, meant to take in a contestant
	 * @return a boolean expression of either true or false if the winner won at least one match in the round
	 * this method is a placeholder to be overridden in each round class 
	 */
	public boolean isWinner(IContestant thisone)
	{
		return false;
	}
}
