
public class CandidateExistsException extends Exception
{
	private String name;
	
	public CandidateExistsException(String name)
	{
		this.name = name;
	}
	
	// Getter
	public String getName()
	{
		return this.name;
	}
}
