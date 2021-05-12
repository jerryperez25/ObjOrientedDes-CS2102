
public class RoboticsTeam implements IContestant 

{
	// this class makes up a Robotics team.. which has a specific school (String), feature (String), and rank (int) for their last competition (0 is never competed).
	
	String School;
	String SpecialFeature;
	int LastCompRank;
	
	public RoboticsTeam (String School, String SpecialFeature, int LastCompRank)
	
	{
		this.School = School;
		this.SpecialFeature = SpecialFeature;
		this.LastCompRank = LastCompRank;
	}
	
	public boolean expectToBeat(IContestant opponent) // takes in a contestant and returns a boolean statement determining who the expected winner is against the given input
	{
		// ((RoboticsTeam)opponent).Ritual needs to be used for this to work
		// for Robotics the expected winner is the one who has the greater competition rank 
		if(this.LastCompRank > ((RoboticsTeam)opponent).LastCompRank)
			return true;
		else 
			return false;
	}
}
