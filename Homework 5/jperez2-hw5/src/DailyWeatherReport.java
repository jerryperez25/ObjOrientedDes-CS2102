import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DailyWeatherReport 
{
	private GregorianCalendar date;
	private LinkedList<Double> tempReadings; // question on forum says these probably shouldnt be of type reading
	private LinkedList<Double> rainfall;
	
	public DailyWeatherReport(GregorianCalendar date, LinkedList<Double> tempReadings, LinkedList<Double> rainfall) 
	{
		this.date = date;
		this.tempReadings = tempReadings;
		this.rainfall = rainfall;
	}
	/**
	 * 
	 * @param month
	 * @param year
	 * @return true if the date matches, false otherwise
	 */
	public boolean isitrightDate(int month, int year) 
	{
		 if(this.date.get(GregorianCalendar.MONTH) == month && (this.date.get(GregorianCalendar.YEAR) == year))
		 {
			 return true;
		 }
		 return false;
	}
// Getters
	public LinkedList<Double> getTemp()
	{
		return this.tempReadings;
	}
	public LinkedList<Double> getRainfall()
	{
		return this.rainfall;
	}
}
