import java.util.LinkedList;

class ShowManager2 
{
	
	ShowManager2() 
	{
		
	}
/**
 * 
 * @param shows
 * @return ShowSummary
 * does all of the work in a helper function, and just uses the function to intialize and return
 */
	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		ShowSummary done = organizerhelp(shows); // initializes variable to answer of helper function
		return done; // returns our modified list
	}
	/**
	 * 
	 * @param whichshows
	 * @return ShowSummary
	 *  this function will approach the problem a bit differently:
	 *  I will use an accumulator-style for loop that starts at 0, increments by one up until it reaches the size of the list we give it
	 *  during this loop, we will check the first element (0 because of the for loop, we could have started it at one and adjusted accordingly)
	 *  for a series of conditionals:
	 *  the first being if it is a daytime show (between the hours of 600 and 1700)
	 *  the second being if it is a primetime show (between the hours of 1700 and 2200)
	 *  the third being if it is a latenight show (between the hours of 2200 and 100)
	 *  we will add the show to the appropriate list based on whichever properties it possesses
	 *  once we are satisifed with the conditionals and the list is populated then we can return that list 
	 */
	public ShowSummary organizerhelp(LinkedList<Show> whichshows)
	{
		ShowSummary accumstyle = new ShowSummary(); // creates a new ShowSummary to hold a modified version of our list 
		
		for (int i = 0; i < whichshows.size(); i++) // uses accumulator style for loop to iterate through our list
		{
			if (whichshows.get(i).isSpecial==false && whichshows.get(i).broadcastTime>=600 && whichshows.get(i).broadcastTime<=1700) // the current element i is the one that we want the properties for
			{
				accumstyle.daytime.add(whichshows.get(i));
			}
			if (whichshows.get(i).isSpecial==false && whichshows.get(i).broadcastTime>=1700 && whichshows.get(i).broadcastTime<=2200)
			{
				accumstyle.primetime.add(whichshows.get(i));
			}
			if (whichshows.get(i).isSpecial==false && whichshows.get(i).broadcastTime>=2200 && whichshows.get(i).broadcastTime<=100)
			{
				accumstyle.latenight.add(whichshows.get(i));
			}
		}
		return accumstyle; // returns modified list
	}
	
}
