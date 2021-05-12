import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class DataSmoothExamples 
{  
  LinkedList<Show> shows = new LinkedList<Show>();
  LinkedList<Show> showstester = new LinkedList<Show>();
  LinkedList<Show> showstesternext = new LinkedList<Show>();
  LinkedList<Double> showResults = new LinkedList<Double>();
  LinkedList<Double> showResults2 = new LinkedList<Double>();
  LinkedList<Double> showResultstester = new LinkedList<Double>();
  LinkedList<Double> showResultstesternext = new LinkedList<Double>();
  DataSmooth1 D1 = new DataSmooth1();
  DataSmooth1 D2 = new DataSmooth1();
  
  public DataSmoothExamples() 
  {
		LinkedList<Episode> eps1 = new LinkedList<Episode>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));		
		shows.add(new Show("Star Trek", 1800, eps1, false));
		
		LinkedList<Episode> eps2 = new LinkedList<Episode>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));
		shows.add(new Show("Futurama", 1900, eps2, false));
		
		LinkedList<Episode> eps3 = new LinkedList<Episode>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		shows.add(new Show("Animaniacs", 1630, eps3, false));
		
		LinkedList<Episode> eps4 = new LinkedList<Episode>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		shows.add(new Show("Sesame Street", 900, eps4, false));

	    showResults.add(60.0);
	    showResults.add(29.75);
	    showResults.add(29.08333);
	    showResults.add(58.0);
	    showResults2.add(60.0);
	    showResults2.add(29.75);
	    showResults2.add(29.08333);
	    showResults2.add(58.0);
	    
	    Show showw = new Show("Supernatural", 2350, eps4,false);
	    showstesternext.add(new Show("Animaniacs", 1630, eps3,true));
		showstesternext.add(showw);
		showstesternext.add(new Show("Futurama", 1900, eps2,true));
		showstesternext.add(new Show("Animaniacs", 1630, eps3,true));
		showstesternext.add(new Show("Star Trek", 1800, eps1,true));
		showstesternext.add(new Show("Sesame Street", 900, eps4,true));
  }
  
  @Test
  public void instructorTestDS() 
  
  {
	  LinkedList<Double> runtimes = D1.dataSmooth(shows);
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults.get(i), .01);
	  }
	  
	  LinkedList<Episode> epii = new LinkedList<Episode>();
	  Show thisone = new Show("Hello World",1000,epii,true);
	  showstester.add(thisone);
	  showstester.add(thisone);
	  showstester.add(thisone);
	  showResultstester.add(0.0);
	  showResultstester.add(0.0);
	  showResultstester.add(0.0);
	  LinkedList<Double> runtimes2 = D1.dataSmooth(showstester);
	  
	  for(int i = 0; i < runtimes2.size(); i++)
	  {
		  assertEquals(runtimes2.get(i), showResultstester.get(i), .01); //tests a list of shows with no episodes gives us 0 
	  }
	  
/*	  LinkedList<Double> runtimes3 = D1.dataSmooth(showstesternext);
	  showResultstesternext.add(7.0);
	  showResultstesternext.add(51.4166666666);
	  showResultstesternext.add(51.4166666666);
	  showResultstesternext.add(29.75);
	  showResultstesternext.add(41.666666);
	  showResultstesternext.add(58.0);
	  
	  for(int i = 0; i < runtimes3.size(); i++)
	  {
		  assertEquals(runtimes3.get(i), showResultstesternext.get(i), .01); // tests more in depth 
	  }
	  // TEST CASE PASSES BUT PARENTHESIS SHOW AN ERROR, NOT SURE WHY
	  */
  }
  
  @Test
  public void instructorTestDS2() 
  {
	// we will use the same test case as before just to make sure the second is correct, just modify the code a bit 
	  LinkedList<Double> runtimes = D2.dataSmooth(shows); 
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults2.get(i), .01);
	  }
  }
  
  // Subtasks:
  
  // Separate data into triples so we can average
  // For every show, find the average runtime 
  // Compute the average runtime across 3 shows in each triple
  // create a new list of the first shows average runtime, the average runtime of each element of the triple, and the last show 
  // return this modified list
  
}