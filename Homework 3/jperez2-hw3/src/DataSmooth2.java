import java.util.LinkedList;

class DataSmooth2 
{
	DataSmooth2() 
	{

	}
/**
 * 
 * @param shows
 * @return LinkedList of Doubles 
 * This time, we are going to run through the list, if show is the first one then we are going to add the average runtime
 *  to the modifiable list that is created, which is a list of doubles. We are going to do the same thing for all of the 
 *  shows that need to be smoothed, adding each of them to our list of doubles. If it doesn't fall into the data smoothing case 
 *  then we create a solo average list, where this will stay. 
 */
	public LinkedList<Double> dataSmooth(LinkedList<Show> shows) 
	{
		{
			LinkedList<Double> SmoothDta = new LinkedList<Double>();

			for (int i = 0; i < shows.size() - 1; i++) 
			{
				if (i == 0) 
				{
					double LengthFirst = 0;
					
					if (shows.get(i).episodes.size() == 0) 
					{
						SmoothDta.add(LengthFirst);
					} 
					else 
					{
						for (Episode epi : shows.get(i).episodes) 
						{
							LengthFirst = LengthFirst + epi.runTime;
						}
						
						SmoothDta.add(LengthFirst / shows.get(i).episodes.size());
					}
				}
				if (i == shows.size() - 1) 
				{
					double LengthLast = 0;
					
					if (shows.get(i).episodes.size() == 0) 
					{
						SmoothDta.add(LengthLast);
					} 
					else 
					{
						for (Episode epi : shows.get(i + 1).episodes) 
						{
							LengthLast = LengthLast + epi.runTime;
						}
						
						SmoothDta.add(LengthLast / shows.get(i + 1).episodes.size());
					}
				} 
				else if (i < shows.size() - 2) 
				{
					LinkedList<Show> solo = new LinkedList<Show>();
					
					solo.add(shows.get(i));
					solo.add(shows.get(i + 1));
					solo.add(shows.get(i + 2));
			
					double totalAvgLengthOfAllThree = 0;
					
					for (Show s : solo) 
					{
						double totalLength = 0;
						
						if (s.episodes.size() == 0) 
						{
							totalAvgLengthOfAllThree = totalAvgLengthOfAllThree + totalLength;
						}
						else
						{
							for (Episode epi : s.episodes) 
							{
								totalLength = totalLength + epi.runTime;
							}
							
							totalAvgLengthOfAllThree = totalAvgLengthOfAllThree + (totalLength / s.episodes.size());
						}
					}
					
					SmoothDta.add(totalAvgLengthOfAllThree / 3);
				}
			}
			return SmoothDta;
		}
	}
}