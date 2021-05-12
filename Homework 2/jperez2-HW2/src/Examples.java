// Jerry Perez // Username: jperez2
import static org.junit.Assert.*;

import org.junit.Test;

public class Examples 
{
	
	// Self-created classes to create test-cases and to test functions!

	RugbyTeam Warriors = new RugbyTeam ("United States","Red", true,10, 1);
	RugbyTeam Spooks = new RugbyTeam ("Asia", "blue", false, 5, 6);
	RugbyTeam Phantoms = new RugbyTeam ("Australia", "green", true, 3, 3);
	RugbyTeam Runners = new RugbyTeam ("Brazil", "yellow", true, 1, 2);
	RoboticsTeam Spartans = new RoboticsTeam ("WPI","Arm",1);
	RoboticsTeam Tomahawks = new RoboticsTeam ("Ohio State","Slingshot",10);
	RoboticsTeam SuperMen = new RoboticsTeam ("DreamVille High","Cannon",4);
	RoboticsTeam SuperWomen = new RoboticsTeam ("Ohio State","water gun",7);
	RugbyResult score1 = new RugbyResult(Warriors,Spooks,100,175);
	RugbyResult score2 = new RugbyResult(Phantoms,Runners,99,120);
	RugbyResult score3 = new RugbyResult(Spooks,Phantoms,150,150);
	RoboticsResult res1 = new RoboticsResult (Spartans,Tomahawks,12.0,5,true,13.0,7,false);
	RoboticsResult res2 = new RoboticsResult (SuperMen,SuperWomen,8.0,1,true,15.0,13,false);
	RoboticsResult res3 = new RoboticsResult (SuperMen,Tomahawks,9.0,1,false,18.0,13,true);
	RoboticsResult res4 = new RoboticsResult (Tomahawks,SuperWomen,17.0,9,true,18.0,10,true);
	RoboticsResult res5 = new RoboticsResult (Tomahawks,SuperWomen,16.0,8,true,16.0,8,true);
	Match robotmatch = new Match(Spartans, Tomahawks, res1);
	Match rugbymatch = new Match(Warriors, Spooks, score1);
	
	// tests below will check false, true, or edge cases 
	// for functions that do not return boolean, we will check the expected output
	
	@Test
	public void TestisValidRugby() 
	{
		assertFalse(score1.isValid()); //this tests our false case where at least one value is larger than 150
		assertTrue(score2.isValid()); // this tests our true case where both scores are less than 150
		assertFalse(score3.isValid()); //this tests our edge case with both teams scoring exactly 150 points
	}
	
	@Test
	public void TestisValidRobotics() 
	{
		assertTrue(res1.isValid()); // this tests our true where both teams have less than 8 tasks and less than 16 points
		assertFalse(res2.isValid()); // this tests our false where at least one team has more than 8 tasks but not more than 16 points
		assertFalse(res3.isValid()); // this tests another one of our cases where at least one team has both more than 8 tasks and more than 16 points
		assertFalse(res4.isValid()); // this tests another case where both teams both have higher than 8 tasks and higher than 16 points
		assertFalse(res5.isValid()); // this tests an edge case where both teams have equal to 8 tasks and equal to 16 points
	}
	@Test
	public void TestgetScore()
	{
		assertEquals(10,res1.getScore(10, 10, true),5); //the test checks for expected score on a robot that has fallen... it is meant to total the sum of the points with a 5 point deduction
		assertEquals(10,res1.getScore(10, 10, false),10); // the test checks for expected score on a robot that has not fallen and not given a penalty.
	}
	@Test
	public void TestGetWinner()
	{
		assertEquals(Tomahawks, res1.getWinner()); // standard function testing that tests a robotics contestant and its expected result
		assertEquals(Spooks, score1.getWinner()); // standard function testing that tests a rugby contestant and its expected result
	}
	@Test
	public void Testwinner()
	{
		assertEquals(Tomahawks, robotmatch.winner()); // tests a robot case for winner function, checks that the result is correct
		assertEquals(null, rugbymatch.winner()); // tests a rugby case for winner function, checks that the result is correct
	}
	@Test
	public void testexpectToBeat()
	{
		assertTrue(Warriors.expectToBeat(Spooks)); // tests one having a ritual and other not..checks expected winner
		assertTrue(Warriors.expectToBeat(Phantoms)); //tests both having rituals but the first having more points than second...checks expected winner
		assertFalse(Phantoms.expectToBeat(Warriors)); //tests both having rituals but the second having more points than first...checks expected winner
	}
}
