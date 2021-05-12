
public class UnknownCandidateException extends Exception
{
	private String name;
	
	public UnknownCandidateException(String name)
	{
		this.name = name;
	}
	
	// Getter
	public String getName()
	{
		return this.name;
	}
}
