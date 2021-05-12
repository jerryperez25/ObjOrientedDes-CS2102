import java.util.LinkedList;

class MtBT implements IBinTree {
	MtBT() {
	}

	// returns false since empty tree has no elements
	public boolean hasElt(int e) {
		return false;
	}

	// returns 0 since empty tree has no elements
	public int size() {
		return 0;
	}

	// returns 0 since empty tree has no branches
	public int height() {
		return 0;
	}
	/**
	 * default to return true when it is called
	 */
	public boolean isHeap()
	{
		return true;
	}
	/**
	 * default to return true whenever it is called
	 */
	public boolean isBigger(int element)
	{
		return true;
	}
	/**
	 * default to return a new linked list whenever it is called
	 */
	 public LinkedList<Integer> makeSorted() 
	 {
		 return new LinkedList<Integer>();
	 }

}