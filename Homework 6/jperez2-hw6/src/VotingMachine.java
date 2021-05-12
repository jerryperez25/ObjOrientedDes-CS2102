import java.util.Scanner;

public class VotingMachine 
{
	private ElectionData data;
	Scanner keyboard = new Scanner(System.in);
	
	public VotingMachine(ElectionData data)
	{
		this.data = data;
	}
	
	public void printBallot() 
	  {
	    System.out.println("The candidates are ");
	    for (String str : data.getBallots()) 
	    {
	      System.out.println(str);
	    }
	  }
	
	public void screen() 
	  {
		this.printBallot();
		System.out.println("Which candidate is your first choice?");
	    String first = keyboard.next();
	    System.out.println("Which candidate is your second choice?");
	    String second = keyboard.next();
	    System.out.println("Which candidate is your third choice?");
	    String third = keyboard.next();
	    try {
				data.getVotes().processVote(first, second, third);
			} 
	    catch (UnknownCandidateException e) 
	    	{
				System.out.println("One of your votes was an unknown candidate.");
			}
		catch (DuplicateVotesException e) 
	    	{
				System.out.println("You can only vote for a candidate once.");
			} 
	    		System.out.println("You successfully voted for " + first + ", " + second + ", and " + third);
		  }	
	  }
