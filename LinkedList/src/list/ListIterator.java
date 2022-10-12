package list;

public class ListIterator<T> {
	
	/* Current node (of type ListNode) */
	protected ListNode<T> curNode; 
	
	/* ListIterator constructor. Accepts the current node. */
	public ListIterator(ListNode<T> currentNode) { 
		this.curNode = currentNode;
	}
	
	/**
	 * These two methods tell us if the iterator has run off
	 * the list on either side
	 */
	public boolean isPastEnd() { 
		/* Hint: How do you know if you’re at the dummy tail node? */
		if (curNode.next == null) {
			return true;
		}
		return false;
	}
	
	public boolean isPastBeginning() { 
		/* TODO: Implement this method */
		/* Hint: How do you know if you’re at the dummy head node? */
		if (curNode.prev == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Get the data at the current iterator position
	 * Return the data if appropriate, otherwise return null
	 */
	public T value() {
		return curNode.getData();
	}
	
	/**
	 * These two methods move the cursor of the iterator
	 * forward / backward one position
	 */
	public void moveForward() { 
		if (!isPastEnd()) {
			curNode = curNode.next;
		}

	}
	
	public void moveBackward() { 
		if (!isPastBeginning()) {
			curNode = curNode.prev;
		}
	}
}


