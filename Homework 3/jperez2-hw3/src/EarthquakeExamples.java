import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples {
  Earthquake1 E1 = new Earthquake1();
  Earthquake2 E2 = new Earthquake2();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();  
  LinkedList<Double> createddates = new LinkedList<Double>();
  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> NovReports2 = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> thesereports = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport>empty = new LinkedList<MaxHzReport>();
  
  public EarthquakeExamples() {
    threeDates.add(20151013.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(20151020.0);
    threeDates.add(40.0);
    threeDates.add(50.0);
    threeDates.add(45.0);
    threeDates.add(20151101.0);
    threeDates.add(6.0);
    NovReports.add(new MaxHzReport(20151101.0,6.0));
    NovReports2.add(new MaxHzReport(20151101.0,6.0));
  }

  @Test
  public void instructorTestEQ() 
  { 
    assertEquals(NovReports, 
                 E1.dailyMaxForMonth(threeDates, 11));
    createddates.add(20190125.0); //ignore
    createddates.add(18.0);
    createddates.add(20190802.0);
    createddates.add(9.0);
    createddates.add(3.2);
    createddates.add(20190823.0);
    createddates.add(54.9);
    createddates.add(55.0);
    createddates.add(18.0);
    createddates.add(20190824.0);
    createddates.add(100.0);
    createddates.add(20191223.0); //ignore
    createddates.add(58.0);
    createddates.add(20190804.0);
    createddates.add(105.0);
    createddates.add(20190909.0); //ignore
    createddates.add(18.6);
    thesereports.add(new MaxHzReport(20190802.0, 9.0));
    thesereports.add(new MaxHzReport(20190823.0, 55.0));
    thesereports.add(new MaxHzReport(20190824.0, 100.0));
    thesereports.add(new MaxHzReport(20190804.0, 105.0));
    assertEquals(thesereports, E1.dailyMaxForMonth(createddates, 8)); // returns only the months with 8 and their max frequency
    assertEquals(empty, E1.dailyMaxForMonth(noData, 10)); //empty test
  }
  @Test
  public void instructorTestEQ2() 
  { 
    assertEquals(NovReports2, 
                 E2.dailyMaxForMonth(threeDates, 11));
  }
  
  // 8 digit numbers are associated with the dates, numbers between 0 and 500 are the vibration frequencies
  
  // Subtasks:
  
  //	create a list of MaxHZReports
  //	for every item in our inputted list, make sure that the month is correct  
  //	for the next piece of data, whatever follows the correct month that we just checked, figure out the max frequency
  //	add to the list of MaxHZReports made from that date with the correct month with its max frequency
  //	return the modified MaxHZReports list
}
