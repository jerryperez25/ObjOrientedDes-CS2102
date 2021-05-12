
public class RugbyTeam implements IContestant

{
	// this class represents a specific Rugby team that has a specific country (String)
	// Jersey color (String), Intimidation Ritual (Bool), wins and losses (ints).
	
	String Country;
	String JerseyColor;
	boolean Ritual;
	int Wins;
	int Losses;
	
	public RugbyTeam (String Country, String JerseyColor, boolean Ritual, int Wins, int Losses)
	
	{
		this.Country = Country;
		this.JerseyColor = JerseyColor;
		this.Ritual = Ritual;
		this.Wins = Wins;
		this.Losses = Losses;
	}
	public boolean expectToBeat (IContestant opponent) // takes in a contestant and returns a boolean statement determining who the expected winner is against the given input
	{
		// ((RugbyTeam)opponent).Ritual must be used in order for this to work
		// for Rugby, the expected winner is the one who has an intimidation ritual
		// if neither or both teams have intimidation rituals then we need to check which team has the greater difference between wins and losses 
		if (this.Ritual == true && ((RugbyTeam)opponent).Ritual == true) // both teams have intimidation rituals
		{
			if (this.Wins - this.Losses > ((RugbyTeam)opponent).Wins - ((RugbyTeam)opponent).Losses) //check difference in wins/losses...first team greater return true
			{
				return true; 
			}
			else  // second team greater difference, return false
				return false;
		}
		if (this.Ritual == false && ((RugbyTeam)opponent).Ritual == false) // both teams don't have intimidation rituals so check points again
		{
			if (this.Wins - this.Losses > ((RugbyTeam)opponent).Wins - ((RugbyTeam)opponent).Losses)
			{
				return true;
			}
			else 
				return false;
		}
		if (this.Ritual == true) //checks if the first has, then return true because whichever team has the intimidation ritual is the winner
		{
			return true;
		}
		else    				// if the second has then return false because it will be the winner 
			return false;
	}
}
