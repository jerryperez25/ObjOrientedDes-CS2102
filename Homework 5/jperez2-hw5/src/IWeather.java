import java.util.GregorianCalendar;
import java.util.LinkedList;

public interface IWeather 
{
	public double findAverageTempForMonth(int month, int year);
	public double FindTotalRainfallForMonth(int month, int year);
	public void cleanReport (GregorianCalendar date, LinkedList<Reading> readings);
}
