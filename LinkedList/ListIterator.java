
package list;

public class ListIterator<T> { 
	protected ListNode<T> curNode;  /* Current node (of type ListNode) */
	
        /* ListIterator constructor. Accepts the current node. */
	public ListIterator(ListNode<T> currentNode) { 
		this.curNode = currentNode;
	}
	
	/**
	 * These two methods tell us if the iterator has run off
	 * the list on either side
	 */
	public boolean isPastEnd() { // Returns true if past end
		return curNode == null || curNode.next == null;
	}
	
	public boolean isPastBeginning() { // Returns true if past beginning
		return curNode == null || curNode.prev == null;
	}
	
	/**
	 * Get the data at the current iterator position
	 * Return the data if appropriate, otherwise return null
	 */
	public T value() {
		if (curNode != null) {
			return curNode.getData();
		}
		return null;
		
		
	}
	
	/**
	 * These two methods move the cursor of the iterator
	 * forward / backward one position
	 */
	public void moveForward() { // moves cursor forward as long as not past end
		if (!isPastEnd()) {
			curNode = curNode.next;
		}
	}
	
	public void moveBackward() { // moves cursor forward as long as not past beginning
		if (!isPastBeginning()) {
			curNode = curNode.prev;
		}
	}
}


