
public class DuplicateVotesException extends Exception
{
	private String name;
	
	public DuplicateVotesException(String name)
	{
		this.name = name;
	}
	
	// Getter
	public String getName()
	{
		return this.name;
	}
}
