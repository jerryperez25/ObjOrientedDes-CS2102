import java.util.GregorianCalendar;
import java.util.LinkedList;

public class WeatherMonitor
{
	private IWeather weather;
	
	public WeatherMonitor(IWeather weather)
	{
		this.weather = weather;
	}
	
	/**
	 * 
	 * @param month
	 * @param year
	 * @return average temperature over all days in that month (double just in case we get some decimals in data)
	 */
	public double averageTempForMonth(int month, int year) // this call's name was listed as "average..." in the beginnning of HW and then changed to "avg..." at the end, wasn't sure which to use
	{
		return weather.findAverageTempForMonth(month, year);
	}
	
	/**
	 * 
	 * @param month
	 * @param year
	 * @return the total rainfall over all days that month (double just in case we get some decimals in data)
	 */
	public double totalRainfallForMonth(int month, int year)
	{
		return weather.FindTotalRainfallForMonth(month, year);
	}
	/**
	 * 
	 * @param date
	 * @param tempReadings
	 * @param rainfall
	 * this is meant to store updated daily weather reports 
	 */
	public void addDailyReport (GregorianCalendar date, LinkedList<Reading> readings)
	{
		 weather.cleanReport(date, readings);
	}
}
