
public class Match

{
	//takes on 2 contestants and a result for input
	
	IContestant cont1;
	IContestant cont2;
	IResult resultant;
	
	public Match (IContestant cont1, IContestant cont2, IResult resultant)
	{
		this.cont1 = cont1;
		this.cont2 = cont2;
		this.resultant = resultant;
	}
	public IContestant winner() // checks if either Contestants result is valid, if it is then we will process getWinner, if not...null.
	{
		if (!resultant.isValid()) // contestants result is not valid 
			return null;		// return null
		else 					//contestant result is valid
			return resultant.getWinner(); //call getWinner with their results to see who's the winner.
	}
}
