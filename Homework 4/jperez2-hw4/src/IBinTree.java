import java.lang.Math;
import java.util.LinkedList;

interface IBinTree {
	// determines whether element is in the tree
	boolean hasElt(int e);

	// returns number of nodes in the tree; counts duplicate elements as separate
	// items
	int size();

	// returns depth of longest branch in the tree
	int height();
	
	// returns true if the BST is a heap
	boolean isHeap();
	
	// returns true if the root is greater than or equal to the element passed in
	boolean isBigger(int element);
	
	// returns a sorted list for the binary tree
	LinkedList<Integer> makeSorted();
}


