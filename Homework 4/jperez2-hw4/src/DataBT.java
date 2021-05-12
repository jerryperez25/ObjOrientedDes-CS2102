import java.util.Collections;
import java.util.LinkedList;

class DataBT implements IBinTree {
	int data;
	IBinTree left;
	IBinTree right;

	DataBT(int data, IBinTree left, IBinTree right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	// an alternate constructor for when both subtrees are empty
	DataBT(int data) {
		this.data = data;
		this.left = new MtBT();
		this.right = new MtBT();
	}

	// determines whether this node or node in subtree has given element
	public boolean hasElt(int e) {
		return this.data == e || this.left.hasElt(e) || this.right.hasElt(e);
	}

	// adds 1 to the number of nodes in the left and right subtrees
	public int size() {
		return 1 + this.left.size() + this.right.size();
	}

	// adds 1 to the height of the taller subtree
	public int height() {
		return 1 + Math.max(this.left.height(), this.right.height());
	}
	/**
	 * returns true if it is a heap and false if it is not
	 */
	public boolean isHeap() 
	{
		 if (this.left.isBigger(this.data) && this.right.isBigger(this.data)) 
		 {
			 return this.left.isHeap() && this.right.isHeap();
		 }
		 else
		 {
			 return false;
		 }
	 }
	/**
	 * returns true if the data passed in is greater than the chosen element value
	 */
	public boolean isBigger(int element) 
	{
		 return this.data >= element;
	}
	/**
	 * sorts a linked list
	 */
	public LinkedList<Integer> makeSorted()
	{
		LinkedList<Integer> creater = new LinkedList<Integer>();
		
		creater.add(this.data);
		creater.addAll(this.left.makeSorted());
		creater.addAll(this.right.makeSorted());
		
		Collections.sort(creater);
		
		return creater;
	}
}