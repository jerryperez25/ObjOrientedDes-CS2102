import java.util.LinkedList;

class ShowManager1 extends ShowSummary
{	
	ShowManager1() 
	{
		
	}
/**
 * 
 * @param shows
 * @return ShowSummary
 * unlike ShowManager2, we will do all of our work inside of the function this time.
 * However, we will use a element-based for-loop to do so.
 * The element based for loop allows us to scan through each show in our list of shows and check each of their properties
 * the properties we will use for each show is the isSpecial, to make sure it is not a special and broadCast time to determine what kind of show it is
 * we have 3 conditionals:
 * 
 *  if the time is between the hours of 600 and 1700 then it is a daytime show 
 *  if the time is between the hours of 1700 and 2200 then it is a primetime show
 *  if the time is between the hours of 2200 and 100 then it is a latenight show 
 *  
 * depending on where each show lies, we will add it to the appropriate list
 * this will continue on for every element in our list of shows
 * once we have populated the list that we need, we can return it! 
 * 
 */
	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		ShowSummary allshows = new ShowSummary(); // creates a new ShowSummary to hold a modified version of our list
		
		for (Show these : shows) //for each show in my list of shows 
		{
			if (these.isSpecial == false && these.broadcastTime>=600 && these.broadcastTime<=1700) // daytime show
			{
				allshows.daytime.add(these);
			}
			if (these.isSpecial == false && these.broadcastTime>=1700 && these.broadcastTime<=2200) // primetime show
			{
				allshows.primetime.add(these);
			}
			if (these.isSpecial == false && these.broadcastTime>=2200 && these.broadcastTime<=100) // latenight show
			{
				allshows.latenight.add(these);
			}
		}
		return allshows;
	}	
}
