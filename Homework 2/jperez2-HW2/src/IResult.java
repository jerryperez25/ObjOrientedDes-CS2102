
public interface IResult 

{
	// getWinner and isValid must be accessed through Match via this interface 
	public IContestant getWinner();
	public boolean isValid();
}
