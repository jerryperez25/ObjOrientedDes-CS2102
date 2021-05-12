
public class RoboticsResult implements IResult
{
	
	// the class will use 2 (Robotics) teams..points (double) ,tasks (int), and if it fell or not (bool), for each.
	
	RoboticsTeam team1;
	RoboticsTeam team2;
	double Team1Points;
	double Team2Points;
	int Team1Tasks;
	int Team2Tasks;
	boolean Team1Fell;
	boolean Team2Fell;
	
	public RoboticsResult (RoboticsTeam team1, RoboticsTeam team2, 
							double Team1Points, int Team1Tasks, boolean Team1Fell, 
							double Team2Points, int Team2Tasks, boolean Team2Fell)
	{
		this.team1 = team1;
		this.team2 = team2;
		this.Team1Points = Team1Points;
		this.Team2Points = Team2Points;
		this.Team1Tasks = Team1Tasks;
		this.Team2Tasks = Team2Tasks;
		this.Team1Fell = Team1Fell;
		this.Team2Fell = Team2Fell;
	}
	
	public boolean isValid() //isValid determines if results are expected/reasonable
	
	{
		// valid/true if both teams have less than 8 tasks and less than or equal to 16 points
		if (Team1Tasks < 8 && Team2Tasks < 8 && Team1Points <= 16.0 && Team2Points <= 16.0)
			return true;
		else
			return false;
	}
	
	public double getScore(double numofpoints, int numoftasks, boolean diditfall)
	// getScore calculates a final score depending on the number of points, number of tasks and if the robot fell
	{
		double Score = 0; // Score will be where we store our result and later return it  
		if (diditfall == false) // if it did not fall then we can calculate the score normally by summing points and tasks 
		{
			Score = numofpoints + numoftasks;
			return Score; // return result
		}
		
		if (diditfall ==true) // if the robot fell then the score will be calculated normally but with a 5 point deduction
			Score = (numofpoints + numoftasks) - 5.0;
			return Score; // return result
	}
	
	public IContestant getWinner() //used by Match class to determine who is the winner
	
	{
		// the winner of a robotics match is the one with the higher score calculated above 
		if (getScore(Team1Points, Team1Tasks, Team1Fell) > getScore(Team2Points, Team2Tasks, Team2Fell)) //team 1 has a greater score 
		{
			return team1; //returns the team with the greater score 
		}
		else			// team 2 has the greater score
			return team2; //return team 2
	}
}
