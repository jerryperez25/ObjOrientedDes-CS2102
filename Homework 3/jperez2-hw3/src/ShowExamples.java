import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;
import java.util.Arrays;

public class ShowExamples 
{
	ShowManager1 sm1 = new ShowManager1();
	LinkedList<Show> shows = new LinkedList<Show>();
	LinkedList<Show> empty = new LinkedList<Show>();
	ShowSummary report1 = new ShowSummary();
	ShowSummary report2 = new ShowSummary();
	
	public ShowExamples()
	{
		LinkedList<Episode> eps1 = new LinkedList<Episode>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));		
		Show s1 = new Show("Star Trek", 1800, eps1, false);
		shows.add(s1);
		report1.primetime.add(s1);
		report2.primetime.add(s1);
		
		LinkedList<Episode> eps2 = new LinkedList<Episode>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));
		Show s2 = new Show("Futurama", 1900, eps2, false);
		shows.add(s2);
		report1.primetime.add(s2);
		report2.primetime.add(s2);
		
		LinkedList<Episode> eps3 = new LinkedList<Episode>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		Show s3 = new Show("Animaniacs", 1630, eps3, false);
		shows.add(s3);
		report1.daytime.add(s3);
		report2.daytime.add(s3);
		
		LinkedList<Episode> eps4 = new LinkedList<Episode>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		Show s4 = new Show("Sesame Street", 900, eps4, false);
		shows.add(s4);
		report1.daytime.add(s4);
		report2.daytime.add(s4);
	}
	
	@Test
	public void instructorTestOrganizeShows() 
	{
		ShowSummary report2 = sm1.organizeShows(shows);
		assertEquals(report1, report2);		// regular case
		ShowSummary report3 = sm1.organizeShows(empty);
		ShowSummary emptyreport = new ShowSummary();
		assertEquals(emptyreport, report3);		// tests an empty case
		LinkedList<Episode> eps1 = new LinkedList<Episode>();
		Show special = new Show("Star Trek", 1800, eps1, true);
		LinkedList<Show> specialshow = new LinkedList<Show>();
		ShowSummary report4 = sm1.organizeShows(specialshow);
		assertEquals(emptyreport, report4);	// special show
	}
	
	@Test
	public void instructorTestOrganizeShows2() 
	{
		ShowSummary report3 = sm1.organizeShows(shows); // has the same show manager and sends in the same shows as the created list to determine if the second way is correct
		assertEquals(report2, report3); // passes, second method is properly formed
	}
	
	// Subtasks:
	
	// - organize into only “daytime” “primetime” “latenight” shows
	
	// - we need to create a ShowSummary list to hold our values (allshows)
	
	// - we will check through our list of shows, ensuring the folllowing:
	
	//     - daytime shows have start time at or after 6:00 am (600) and 5:00pm (1700)
	// 			- if we see a show where this is the case then add it to the allshows.daytime list
	//     - Primetime shows have a start time at or after 5:00 pm (1700)  and before 10:00 pm (2200)
	//			- if we see a show where this is the case then add it to the allshows.primetime list
	//     - Late night shows have a start time at or after 10:00 pm(2200) and before 1:00 am. (100)
	//			- if we see a show where this is the case then add it to the allshows.latenight list
	
	// - we are not to concern ourselves with specials, and to do this, we must make sure the isSpecial call is false for our shows
	// - and so, if we've got a special then it is not going to be added to the list anyway
	// - we are going to return our fully populated allshows list that contains all of the shows with our conditionals

}

