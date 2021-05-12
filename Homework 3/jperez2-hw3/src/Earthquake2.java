import java.util.LinkedList;

class Earthquake2 
{
	Earthquake2() 
	{

	}

	// checks whether a datum is a date
	boolean isDate(double anum) 
	{
		return (int) anum > 10000000;
	}

	// extracts the month from an 8-digit date
	int extractMonth(double dateNum) 
	{
		return ((int) dateNum % 10000) / 100;
	}
/**
 * 
 * @param data
 * @param month
 * @return LinkedList of MaxHzReports
 *  creates a list of dates that are applicable, then goes through each one of them looking at what 
 *  comes after the applicable list and creating/returning a list of MaxHZReports where each 
 *  one is one of the applicable dates and its maximum frequency.
 */
	public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) 
	{
		{
			LinkedList<MaxHzReport> resultlist = new LinkedList<MaxHzReport>();
			LinkedList<Double> goodDates = new LinkedList<Double>();

			for (double singdata : data) 
			{
				if (this.isDate(singdata)) 
				{
					if (this.extractMonth(singdata) == month) 
					{
						goodDates.add(singdata);
					}
				}
			}

			for (int i = 0; i < data.size(); i++) 
			{
				// we will use a special if statement to allow comparison for doubles
				
				if (this.isDate(data.get(i)) && goodDates.size() > 0 && (Double.doubleToLongBits(data.get(i)) == Double.doubleToLongBits(goodDates.getFirst()))) 
				{
					double max = 0; 
					
					for (int j = 1; j + 2 < data.size(); j++) 
					{
						if (i + j == data.size()) //reached end of the list
						{ 
							max = data.get(i + j - 1);
							break;
						} 
						else if (this.isDate(data.get(i + j))) // reach next date
						{ 
							break; // break because there can't be a higher value associated with the last date 
						} 
						else if (data.get(i + j) > max) // compares with max
						{ 
							max = data.get(i + j);
						}
					}
					resultlist.add(new MaxHzReport(goodDates.getFirst(), max)); // add a new MaxHzReport with goodDates
					goodDates.remove(goodDates.getFirst()); // remove the date we used from the list 																
				} 
			}

			return resultlist;
		}
	}
}