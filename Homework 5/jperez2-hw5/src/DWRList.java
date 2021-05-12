import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DWRList implements IWeather
{
		private LinkedList<DailyWeatherReport> report;

		public DWRList(LinkedList<DailyWeatherReport> report) 
		{
			this.report = report;
		}
/**
 * @param takes in a month 
 * @param takes in a year
 * @return the average temp for the month that is given with the same year 
 *  if the date and year match, then we're going to add that report to a new linked list and then average
 */
		public double findAverageTempForMonth(int month, int year) 
		{
			double runningSum=0;
			double counter=0;
			LinkedList <Double> adder = new LinkedList<Double>();
			LinkedList <Double> tempList = new LinkedList<Double>();
			
			for(DailyWeatherReport dailyreports: report) 
			{
				if(dailyreports.isitrightDate(month, year))
				{
					adder = dailyreports.getTemp();
					tempList.addAll(adder);
				}
			}
			for(Double tempreadings : tempList)
			{
				if(tempList == null)
				{
					return 0;
				}
				else
				{
					runningSum = runningSum + tempreadings;
					counter++;
				}
			}
			return runningSum/counter;
		}

/**
* @param takes in a month 
* @param takes in a year
* @return the average rainfall for the month that is given with the same year 
*  if the date and year match, then we're going to add that report to a new linked list and then average
		 */
		public double FindTotalRainfallForMonth(int month, int year) 
		{
			double runningSum=0;
			double counter=0;
			LinkedList <Double> adder = new LinkedList<Double>();
			LinkedList <Double> rainfallList = new LinkedList<Double>();
			
			for(DailyWeatherReport dailyreports: report) 
			{
				if(dailyreports.isitrightDate(month, year)==true)
				{
					adder=dailyreports.getRainfall();
					rainfallList.addAll(adder);
				}
			}
			for(Double rainfall : rainfallList)
			{
				if(rainfall == null)
				{
					return 0;
				}
				else
				{
					runningSum = runningSum + rainfall;
					counter++;
				}
			}
			if(counter == 0)
			{
				return 0;
			}
			
			return runningSum/counter;
		}
/**
* @param date
* @param LinkedList of readings
* stores 2 separate LinkedList's, each of which has its corresponding field. temp list has temps, rainfall list has rainfall.
*/

		public void cleanReport(GregorianCalendar date, LinkedList<Reading> readings) 
		{
			LinkedList<Double> temperatures = new LinkedList<Double>();
			LinkedList<Double> rainfall = new LinkedList<Double>();
			
			for (Reading thisone: readings)
			{
				temperatures.add(thisone.getTempinDegrees());
				rainfall.add(thisone.getRainfall());
			}
		}

	}
