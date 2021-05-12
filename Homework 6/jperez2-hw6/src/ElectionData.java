import java.util.LinkedList;
import java.util.Scanner;

class ElectionData 
{
  private LinkedList<String> ballot = new LinkedList<String>();
  private Votes vote = new Votes();
  Scanner keyboard = new Scanner(System.in);
  
  ElectionData() 
  {
    this.ballot.add("Gompei");
    this.ballot.add("Husky");
  }
  /**
   * 
   * @param first
   * @param second
   * @param third
   * @throws UnknownCandidateException
   * @throws DuplicateVotesException
   *  this is supposed to store one voters choice in Votes.
   */
  public void processVote(String first, String second, String third) throws UnknownCandidateException, 
  																		DuplicateVotesException 
  {
	  vote.processVote(first, second, third);
  }
  /**
   * 
   * @return a string
   * finds the candidate with the most first votes 
   */
  public String findWinnerMostFirstVotes()
  {
	  return vote.findWinnerMostFirstVotes();
  }
  /**
   * 
   * @return a string
   * finds the candidate with the most points
   */
  public String findWinnerMostPoints()
  {
	  return vote.findWinnerMostPoints();
  }
  /**
   * 
   * @param cand
   * @throws CandidateExistsException
   *  Determines if the candidate was already on the ballot, otherwise add.
   */
  public void addCandidate(String candidate) throws CandidateExistsException 
  {
		ballot.add(candidate);
		vote.addCandidate(candidate);
  }

  
  
  // Getters
  public LinkedList<String> getBallots()
  {
	  return this.ballot;
  }
  public Votes getVotes()
  {
	  return this.vote;
  }
  }
