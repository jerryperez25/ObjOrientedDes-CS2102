// Jerry Perez // username: jperez2
import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import java.util.LinkedList;

import org.junit.Test;

public class Examples
{
	Reading r1 = new Reading(new Time(5, 10), 10, 20);
	Reading r2 = new Reading(new Time(5, 10), 30, 40);
	Reading r3 = new Reading(new Time(5, 10), 50, 60);
	Reading r4 = new Reading(new Time(5, 10), 70, 70);
	Reading r5 = new Reading(new Time(5, 10), 0, 0);
	LinkedList<Double> list1 = new LinkedList<Double>();
	LinkedList<Double> list2 = new LinkedList<Double>();
	LinkedList<Double> list3 = new LinkedList<Double>();
	LinkedList<Double> empty = new LinkedList<Double>();
	LinkedList<Double> list5 = new LinkedList<Double>();
	GregorianCalendar date1 = new GregorianCalendar(2019, 01, 25);
	GregorianCalendar date2 = new GregorianCalendar(2019, 02, 25);
	GregorianCalendar date3 = new GregorianCalendar(2019, 03, 25);
	GregorianCalendar date4 = new GregorianCalendar(2019, 04, 25);
	GregorianCalendar date5 = new GregorianCalendar(2019, 05, 25);
	LinkedList<DailyWeatherReport> DWlist = new LinkedList<DailyWeatherReport>();
	LinkedList<DailyWeatherReport> tempzero = new LinkedList<DailyWeatherReport>();
	LinkedList<DailyWeatherReport> rainzero = new LinkedList<DailyWeatherReport>();
	LinkedList<Reading> readings = new LinkedList<Reading>();
	
	@Test
	public void testsforCorrectness()
	{
		list1.add(20.0);
		list1.add(30.0);
		list1.add(40.0);
		list1.add(50.0);
		list1.add(60.0);
		list2.add(10.0);
		list2.add(20.0);
		list2.add(30.0);
		list2.add(40.0);
		list2.add(50.0);
		list3.add(0.0);
		DailyWeatherReport dwr1 = new DailyWeatherReport(date1, list1, list2);
		DailyWeatherReport dwr2 = new DailyWeatherReport(date2, list2, list1);
		DailyWeatherReport dwr3 = new DailyWeatherReport(date1, list3, list1);
		DailyWeatherReport dwr4 = new DailyWeatherReport(date1, list1, list3);
		DailyWeatherReport dwr5 = new DailyWeatherReport(date1, empty, list3);
		DWlist.add(dwr1);
		DWlist.add(dwr2);
		DWRList combinedlist = new DWRList(DWlist);
		WeatherMonitor weathermonit = new WeatherMonitor(combinedlist);
		assertEquals(weathermonit.averageTempForMonth(01, 2019), 40.0, 0);
		assertEquals(weathermonit.totalRainfallForMonth(01, 2019), 30.0, 0);
		tempzero.add(dwr3);
		DWRList zeroTemp = new DWRList(tempzero);
		WeatherMonitor zeroTempforMonth = new WeatherMonitor(zeroTemp);
		assertEquals(zeroTempforMonth.averageTempForMonth(01, 2019), 0, 0);
		rainzero.add(dwr4);
		DWRList zeroRain = new DWRList(rainzero);
		WeatherMonitor zeroRainforMonth = new WeatherMonitor(zeroRain);
		assertEquals(zeroRainforMonth.totalRainfallForMonth(01, 2019), 0, 0);
		/*readings.add(r1);
		readings.add(r2);
		readings.add(r3);
		LinkedList<Double> tempmatcher = new LinkedList<Double>();
		tempmatcher.add(10.0);
		tempmatcher.add(30.0);
		tempmatcher.add(50.0);
		LinkedList<Double> rainfallmatcher = new LinkedList<Double>();
		rainfallmatcher.add(20.0);
		rainfallmatcher.add(40.0);
		rainfallmatcher.add(60.0);*/
		// wasn't sure how to test a function that just stores values, but I gave it a whirl
		//assertEquals(weathermonit.addDailyReport(new GregorianCalendar(2019,01,25), readings),tempmatcher,rainfallmatcher);
	}
}