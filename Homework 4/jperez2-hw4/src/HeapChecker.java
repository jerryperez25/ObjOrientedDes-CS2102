import java.util.LinkedList;

public class HeapChecker 
{
	/**
	 * 
	 * @param hOrig
	 * @param elt
	 * @param hAdded
	 * @return boolean
	 * this should check to see if the binary tree is indeed a heap
	 * addelt must keep all of the elements that were in the original heap
	 * 
	 */
	boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) 
	{

		// check that the BT is a heap
		boolean ishAddedHeap = hAdded.isHeap();
		// stores true or false in ishAddedHeap

		// add the new element to hOrig to test later
		IHeap hOrigwNewElt = hOrig.addElt(elt);

		// create two linked lists to see if they both have the exact same elements
		LinkedList<Integer> hOrigwUpdatedElts = hOrigwNewElt.makeSorted();
		LinkedList<Integer> hAddedElts = hAdded.makeSorted();

		boolean aretheySame = false;

		if (hAddedElts.size() == hOrigwUpdatedElts.size()) 
		{
			for (int i = 0; i < hAddedElts.size(); i++) 
			{
				if (hAddedElts.get(i) != hOrigwUpdatedElts.get(i)) 
				{
					break;
				} 
				else if (i + 1 == hAddedElts.size()) 
				{
					aretheySame = true;
				}
			}
		}
		return ishAddedHeap && aretheySame;
	}
	/**
	 * 
	 * @param hOrig
	 * @param hRemoved
	 * @return boolean
	 *  this should check to see if the binary tree is indeed a heap
	 *  must retain all elements that were in the original heap, 
	 *  other than removing one instance of the smallest element.
	 */
	boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved) 
	{
		if ((hOrig.size() == 0 || hOrig.size() == 1) && hRemoved.size() == 0) 
		{
			return true;
		}

		// check that the BT is a heap
		boolean IShRemovedHeap = hRemoved.isHeap();

		// remove element from hOrig
		IHeap hOrigwRem = hOrig.remMinElt();

		// create two linked lists to see if they both have the exact same elements
		LinkedList<Integer> UpdatedhOrig = hOrigwRem.makeSorted();
		LinkedList<Integer> hOrigwRemovedElts = hRemoved.makeSorted();

		boolean aretheysame = false;

		if (hOrigwRemovedElts.size() == UpdatedhOrig.size()) 
		{
			for (int i = 0; i < hOrigwRemovedElts.size(); i++) 
			{
				if (hOrigwRemovedElts.get(i) != UpdatedhOrig.get(i)) 
				{
					break;
				}
				else if (i + 1 == hOrigwRemovedElts.size()) 
				{
					aretheysame = true;
				}
			}
		}
		return IShRemovedHeap && aretheysame;
	}
}
