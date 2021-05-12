import java.util.LinkedList;

class Earthquake1 
{
	Earthquake1() 
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
			LinkedList<MaxHzReport> listofresult = new LinkedList<MaxHzReport>();

			boolean rightMonth = false; 
			double placeholder = 0; 
			double dateHolder = 00000000; 

			for (int i = 0; i < data.size(); i++) 
			{
				if ((data.size() == i + 1)  && (rightMonth && dateHolder != 00000000) && placeholder != 0) 
				{
					listofresult.add(new MaxHzReport(dateHolder, placeholder));
				}
				else if (this.isDate(data.get(i))) 
				{ 
					
					if (this.extractMonth(data.get(i)) == month) 
					{
						rightMonth = true;
						placeholder = 0;
						dateHolder = data.get(i); 
					}
					else 
					{
						rightMonth = false; 
											
					}
				} 
				else if (rightMonth) 
				{ 
					
					if (data.get(i) > placeholder) 
					{ 
						placeholder = data.get(i);
						if (i + 1 == data.size()) 
						{ 
							listofresult.add(new MaxHzReport(dateHolder, placeholder));
						}
						else if (this.isDate(data.get(i + 1))) 
						{ 
																	
							listofresult.add(new MaxHzReport(dateHolder, placeholder));
						}
					} 
					else if (this.isDate(data.get(i + 1))) 
					{ 
						
						listofresult.add(new MaxHzReport(dateHolder, placeholder));
					}
				}
			}
			return listofresult;
		}
	}
}
