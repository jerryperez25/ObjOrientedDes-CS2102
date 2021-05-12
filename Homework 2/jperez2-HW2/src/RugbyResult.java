
public class RugbyResult implements IResult

{
	// this class will use 2 (Rugby) teams and the points for each (double).
	
	RugbyTeam team1;
	RugbyTeam team2;
	double Team1Points;
	double Team2Points;
	
	public RugbyResult (RugbyTeam team1, RugbyTeam team2, double Team1Points, double Team2Points)
	
	{
		this.team1 = team1;
		this.team2 = team2;
		this.Team1Points = Team1Points;
		this.Team2Points = Team2Points;
	}
	
	public boolean isValid() //isValid determines if results are expected/reasonable 
	
	{
		// valid/true if both Rugby teams scored under 150 points
		if (Team1Points < 150.0 && Team2Points < 150.0)
			return true;
		else
			return false;
	}
	
	public IContestant getWinner() //used by Match class to determine who is the winner
	
	{ 
		// for a Rugby match, the winner is the team with the most points 
		if (Team1Points > Team2Points)
		{
			return team1;
		}
		else
			return team2;
	}
}
