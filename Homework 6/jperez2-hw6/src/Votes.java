import java.util.LinkedList;
import java.util.HashMap;


public class Votes 
{
		
	private LinkedList<String> candidates = new LinkedList<String>();
	private HashMap<String,Integer> firstChoices = new HashMap<String,Integer>();
	private HashMap<String,Integer> secondChoices = new HashMap<String,Integer>();
	private HashMap<String,Integer> thirdChoices = new HashMap<String,Integer>();	
	
	Votes()
	{
		
	}	
	
	/**
	 * 
	 * @param first
	 * @param second
	 * @param third
	 * @throws UnknownCandidateException
	 * @throws DuplicateVotesException
	 * processes the votes, but also determines whether or not there is a duplicate vote (exception).
	 */
	public void processVote(String first, String second, String third) throws UnknownCandidateException, 
		DuplicateVotesException 
	{
		if (candidates.contains(first) == false) 
		{
			throw new UnknownCandidateException(first);
		}
		else if (candidates.contains(second) == false) 
		{
			throw new UnknownCandidateException(second);
		}
		else if (candidates.contains(third) == false) 
		{
			throw new UnknownCandidateException(third);
		}
		else if (first.equals(second) || first.equals(third) || second.equals(third))
		{
			if(first.equals(second))
			{
				throw new DuplicateVotesException(first);
			}
			else 
			{
				throw new DuplicateVotesException(third);
			}
		}
		else 
		{
			addVoteTo(firstChoices, first);
			addVoteTo(secondChoices, second);
			addVoteTo(thirdChoices, third);
		}		
	}
	/**
	 * 
	 * @param votee
	 * @throws CandidateExistsException
	 * adds the candidate if the name is not already on the ballot 
	 */
	public void addCandidate(String votee) throws CandidateExistsException 
	{
			if(candidates.contains(votee) == false) 
			{
				candidates.add(votee);
				firstChoices.put(votee, 0);
				secondChoices.put(votee, 0);
				thirdChoices.put(votee, 0);	
			}
			else
			{
				throw new CandidateExistsException(votee);
			}
		}
	/**
	 * 
	 * @return string of the winner with the most first votes
	 */
	public String findWinnerMostFirstVotes()
	{
			String winner = "";
			double totalV = 0;
			double most = 0;
			for(String candidate : candidates) 
			{
				totalV = totalV + firstChoices.get(candidate);
				
				if (firstChoices.get(candidate) > most) 
				{
					winner = candidate;
					most = firstChoices.get(candidate);
				}
			}
			
			if (100 * (most/totalV) > 50) 
			{
				return winner;
			}
			else 
				return "Runoff required";
		}
	/**
	 * 
	 * @return String of the winner with the highest point total for votes.
	 */
	public String findWinnerMostPoints() 
	{
		String winner = "";
		int most = 0;
		for (String candidate : candidates) 
		{
			if (getPoints(candidate) > most) 
			{
				winner = candidate;
				most = getPoints(candidate);
			}
		}
		return winner;
	}
	/**
	 * 
	 * @param votee
	 * @return an integer of the total number of points achieved by the candidate.
	 */
	private int getPoints(String votee) 
	{
		return (3 * firstChoices.get(votee)
				+ 2 * secondChoices.get(votee)
				+ thirdChoices.get(votee));
	}
	/**
	 * 
	 * @param Votes
	 * @param votee
	 * adds votee to the HashMap
	 */
	private void addVoteTo(HashMap<String,Integer> Votes, String votee)
	{
		Votes.put(votee, Votes.get(votee) + 1);
	}	
	
	// Getters
	public HashMap<String,Integer> getFirst() 
	{
		return firstChoices;
	}
	
	public HashMap<String,Integer> getSecond() 
	{
		return secondChoices;
	}	
	
	public HashMap<String,Integer> getThird() 
	{
		return thirdChoices;
	}
}
