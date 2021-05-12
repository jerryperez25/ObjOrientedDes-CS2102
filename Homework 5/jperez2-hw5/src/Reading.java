
public class Reading 
{
	private Time t1;
	private double tempInDegrees;
	private double rainfall;
	public Reading (Time t1, double tempInDegrees, double rainfall)
	{
		this.t1 = t1;
		this.tempInDegrees = tempInDegrees;
		this.rainfall = rainfall;
	}
	
	// Getters: dont need them, but thought i'd show i knew how to make getters lol ;)
	
	public Time getTime()
	{
		return this.t1;
	}
	public double getTempinDegrees()
	{
		return this.tempInDegrees;
	}
	public double getRainfall()
	{
		return this.rainfall;
	}
}
