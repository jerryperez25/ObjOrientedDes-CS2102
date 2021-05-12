import java.util.LinkedList;

public interface IWinner 
{
	public LinkedList<IContestant> getMatchWinners();
	public int getNumWinners();
	public boolean isWinner(IContestant aContestant);
}
