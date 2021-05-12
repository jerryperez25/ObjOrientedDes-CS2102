import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Examples
{
	ElectionData Setup1()
	{
		ElectionData ED = new ElectionData();
		
		try
		{
			ED.addCandidate("gompei");
			ED.addCandidate("husky");
			ED.addCandidate("ziggy");
			ED.processVote("gompei", "husky", "ziggy");
			ED.processVote("gompei", "ziggy", "husky");
			ED.processVote("husky", "gompei", "ziggy");
		}
		catch (Exception e)
		{
			
		}
		return (ED);
		
	}
	@Test
	public void testMostFirstWinner()
	{
		assertEquals("gompei",Setup1().findWinnerMostFirstVotes());
	}
	
	ElectionData Setup2()
	{
		ElectionData ED = new ElectionData();
		
		try
		{
			ED.addCandidate("jerry");
			ED.addCandidate("maida");
			ED.addCandidate("woo");
			ED.processVote("jerry", "maida", "woo");
			ED.processVote("jerry", "woo", "maida");
			ED.processVote("jerry", "maida", "woo");
		}
		catch (Exception e)
		{
			
		}
		return (ED);
		
	}
	@Test
	public void testMostPoints()
	{
		assertEquals("jerry",Setup2().findWinnerMostPoints());
	}
	ElectionData Setup3()
	{
		ElectionData ED = new ElectionData();
		
		try
		{
			ED.addCandidate("jerry");
			ED.addCandidate("maida");
			ED.addCandidate("woo");
			ED.processVote("jerry", "jerry", "woo");
			ED.processVote("jerry", "woo", "maida");
			ED.processVote("jerry", "maida", "woo");
		}
		catch (Exception e)
		{
			
		}
		return (ED);
		
	}
	@Test
	public void testDuplicateVote()
	{
		assertEquals("Runoff required",Setup3().findWinnerMostFirstVotes());
	}
	ElectionData Setup4()
	{
		ElectionData ED = new ElectionData();
		
		try
		{
			ED.addCandidate("jerry");
			ED.addCandidate("maida");
			ED.addCandidate("woo");
			ED.processVote("thershouldbenofinal", "jerry", "woo");
			ED.processVote("jerry", "woo", "maida");
			ED.processVote("jerry", "maida", "woo");
		}
		catch (Exception e)
		{
			
		}
		return (ED);
		
	}
	@Test
	public void testUnknownCandidate()
	{
		assertEquals("Runoff required",Setup4().findWinnerMostFirstVotes());
	}
	ElectionData Setup5()
	{
		ElectionData ED = new ElectionData();
		
		try
		{
			ED.addCandidate("jerry");
			ED.addCandidate("jerry");
			ED.addCandidate("woo");
			ED.processVote("jerry", "luis", "polar");
			ED.processVote("luis", "polar", "jerry");
			ED.processVote("jerry", "luis", "polar");
			
		}
		catch (Exception e)
		{
			
		}
		return (ED);
		
	}
	@Test
	public void testAlreadyExists()
	{
		assertEquals("Runoff required",Setup5().findWinnerMostFirstVotes());
	}
}