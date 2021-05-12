import java.util.LinkedList;

class DataSmooth1 
{
	DataSmooth1() 
	{

	}
/**
 * 
 * @param shows
 * @return LinkedList of doubles 
 *  create a list of the averages we'll be smoothing, then it creates a list to be returned, and adds
 *	the average runtime of first show to it... average runtime of each singular average, and runtime average
 *	of the last show.
 */
	public LinkedList<Double> dataSmooth(LinkedList<Show> shows) 
	{
		{
			if (shows.size() < 1) 
			{
				return new LinkedList<Double>(); // sends back an empty list since there are no values in the list
			}

			LinkedList<LinkedList<Show>> triples = new LinkedList<LinkedList<Show>>(); //modifiable list

			if (shows.size() > 2) 
			{
				for (int i = 0; i < shows.size() - 2; i++) 
				{
					LinkedList<Show> singavg = new LinkedList<Show>();
					singavg.add(shows.get(i));
					singavg.add(shows.get(i + 1));
					singavg.add(shows.get(i + 2));
					triples.add(singavg);
				}
			}

			LinkedList<Double> smoothed = new LinkedList<Double>();

			double firstlength = 0;
			
			if (shows.getFirst().episodes.size() == 0) 
			{
				smoothed.add(firstlength);
			} 
			else 
			{
				for (Episode ep : shows.getFirst().episodes) 
				{
					firstlength = firstlength + ep.runTime;
				}
				
				double avglength = firstlength / shows.getFirst().episodes.size();
				smoothed.add(avglength);
			}
			for (LinkedList<Show> elementoftriple : triples) 
			{
				double totalRun = 0;
				
				for (Show soloshow : elementoftriple)
			{
					double currshowlength = 0;
					
					if (soloshow.episodes.size() == 0) 
					{
						totalRun = totalRun + currshowlength;
					} 
					else 
					{
						for (Episode epi : soloshow.episodes) 
						{
							currshowlength = currshowlength + epi.runTime;
						}
						
						double thisShowavglength = currshowlength / soloshow.episodes.size();
						totalRun = totalRun + thisShowavglength;
					}
				}
				smoothed.add(totalRun / 3);
			}

			if (shows.size() > 1) 
			{
				double lastlength = 0;
				
				if (shows.getLast().episodes.size() == 0) 
				{
					smoothed.add(lastlength);
				}
				else
				{
					for (Episode epi : shows.getLast().episodes) 
					{
						lastlength = lastlength + epi.runTime;
					}
					double avgLengthLast = lastlength / shows.getLast().episodes.size();
					smoothed.add(avgLengthLast);
				}
			}

			return smoothed;
		}
	}
}