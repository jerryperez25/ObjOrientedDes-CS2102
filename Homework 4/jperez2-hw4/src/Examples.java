import static org.junit.Assert.*;

import org.junit.Test;

public class Examples 
{
	HeapChecker tester = new HeapChecker();
	
	@Test
	public void testAdd() 
	{
		assertTrue(tester.addEltTester(new DataHeap(2, new DataHeap(4, new MtHeap(), new MtHeap()), 
        		new DataHeap(7, new MtHeap(), new MtHeap())), 
        		5, new DataBT(2, new DataBT(4, new MtBT(), new MtBT()), new DataBT(5, new MtBT(), 
        				new DataBT(7, new MtBT(), new MtBT())))));
	}
	
	@Test
	public void testAddwDiffStructure()
	{
		assertTrue(tester.addEltTester(new DataHeap(2, new DataHeap(4, new MtHeap(), new MtHeap()), 
        		new DataHeap(7, new MtHeap(), new MtHeap())), 
        		6, new DataBT(2, new DataBT(4, new DataBT(6, new MtBT(), new MtBT()), new MtBT()), 
        				new DataBT(7, new MtBT(), new MtBT()))));
	}
	
	@Test
	public void notHeapAdd()
	{
		assertFalse(tester.addEltTester(new DataHeap(2, new DataHeap(4, new MtHeap(), new MtHeap()), 
        		new DataHeap(7, new MtHeap(), new MtHeap())), 
        		6, new DataBT(4, new DataBT(2, new MtBT(), new MtBT()), new DataBT(6, new MtBT(), 
        				new DataBT(7, new MtBT(), new MtBT()))))); 
	}
	@Test
	public void emptyHeapAdd()
	{
		 assertTrue(tester.addEltTester(new MtHeap(), 
	        		57, new DataBT(57, new MtBT(), new MtBT()))); 
	}
	@Test
	public void DuplicateAdder()
	{
		 assertTrue(tester.addEltTester(new DataHeap(2, new DataHeap(2, new DataHeap(6, new MtHeap(), 
	        	new MtHeap()), new MtHeap()), new DataHeap(7, new MtHeap(), new MtHeap())), 2, 
	        	new DataBT(2, new DataBT(2, new DataBT(6, new MtBT(), new MtBT()), new MtBT()), 
	        			new DataBT(2, new MtBT(), new DataBT(7, new MtBT(), new MtBT()))))); 
	}
	@Test
	public void testAddWDuplicates()
	{
        assertTrue(tester.addEltTester(new DataHeap(2, new DataHeap(2, new DataHeap(6, new MtHeap(), 
        		new MtHeap()), new MtHeap()), new DataHeap(7, new MtHeap(), new MtHeap())), 2, 
        		new DataBT(2, new DataBT(2, new DataBT(6, new MtBT(), new MtBT()), new MtBT()), 
        				new DataBT(2, new MtBT(), new DataBT(7, new MtBT(), new MtBT()))))); 
    }   
	@Test
    public void testRemove() 
	{
    	assertTrue(tester.remMinEltTester(new DataHeap(3, new DataHeap(7, new MtHeap(), new DataHeap(11, 
    			new MtHeap(), new MtHeap())), new DataHeap(10, new MtHeap(), new MtHeap())), 
    			new DataBT(7, new DataHeap(11, new MtHeap(), new MtHeap()), new DataHeap(10, new MtHeap(), 
    					new MtHeap()))));
    }
	@Test
	public void testRemovewDiffStructure() 
	{
		assertTrue(tester.remMinEltTester(new DataHeap(3, new DataHeap(7, new MtHeap(), new DataHeap(11, 
				new MtHeap(), new MtHeap())), new DataHeap(10, new MtHeap(), new MtHeap())), 
				new DataBT(7, new MtBT(), new DataBT(10, new DataBT(11, new MtBT(), new MtBT()), 
						new MtBT()))));
	}
	@Test
	public void testRemoveSmall() 
	{
		assertTrue(tester.remMinEltTester(new DataHeap(8, new MtHeap(), new MtHeap()), new MtBT()));
	}

	@Test
	public void testEmptyRemove() 
	{
		assertTrue(tester.remMinEltTester(new MtHeap(), new MtBT()));
	}
	@Test
	public void testNotHeapRem() 
	{
	   	assertFalse(tester.remMinEltTester(new DataHeap(27, new DataHeap(66, new MtHeap(), new MtHeap()), 
				new DataHeap(100, new MtHeap(), new MtHeap())), new DataBT(100, new MtBT(), 
						new DataBT(66, new MtBT(), new MtBT()))));    
	}

	@Test
	public void wrongElementRemoval() 
	{
	    assertFalse(tester.remMinEltTester(new DataHeap(27, new DataHeap(66, new MtHeap(), new MtHeap()), 
				new DataHeap(100, new MtHeap(), new MtHeap())), new DataBT(27, new MtBT(), 
						new DataBT(100, new MtBT(), new MtBT()))));
	 }
}
