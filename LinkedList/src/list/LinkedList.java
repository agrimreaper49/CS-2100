package list;

/**
 * 
 * A custom built linked list
 * T here is the type the list stores
 */
public class LinkedList<T> implements List<T>{

	/* Dummy head and tail */
	private ListNode<T> head, tail;
	private int size;
	
	public LinkedList() {
		head = new ListNode<T>(null);
		tail = new ListNode<T>(null);
		head.next = tail;
		tail.prev = head;
		head.prev = null;
		tail.next = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	/**
	 * Clears out the entire list
	 */
	public void clear() {
		head = new ListNode<T>(null);
		tail = new ListNode<T>(null);
		head.next = tail;
		tail.prev = head;
		head.prev = null;
		tail.next = null;
		size = 0;
	}
	
	/**
	 * Inserts new data at the end of the list (i.e., just before the dummy tail node)
	 * @param data
	 */
	public void insertAtTail(T data) {
		ListNode<T> newNode = new ListNode<T>(data);
		newNode.next = tail;
		newNode.prev = tail.prev;
		tail.prev.next = newNode;
		tail.prev = newNode;	
		size++;
	}
	
	/**
	 * Inserts data at the front of the list (i.e., just after the dummy head node
	 * @param data
	 */
	public void insertAtHead(T data) {
		ListNode<T> newNode = new ListNode<T>(data);
		newNode.next = head.next;
		head.next.prev = newNode;
		head.next = newNode;
		newNode.prev = head;
		size++;
		
	}
	
	/**
	 * Inserts node such that index becomes the position of the newly inserted data
	 * @param data
	 * @param index
	 */
	public void insertAt(int index, T data) {
		if (index == 0) {
			insertAtHead(data);
			return;
		} else if (index == size) {
 			insertAtTail(data);
			return;
		}
		int i = 0;
		ListNode<T> val = new ListNode<T>(data);
		ListNode<T> temp = head;
		while (i != index) {
			temp = temp.next;
			i++;
		}
		temp.next.prev = val;
		val.next = temp.next;
		temp.next = val;
		val.prev = temp;
		size++;
	}
	
	/**
	 * Inserts data after the node pointed to by iterator
	 */
	public void insert(ListIterator<T> it, T data) {
		ListNode<T> val = new ListNode<T>(data);
		it.curNode.next.prev = val;
		val.next = it.curNode.next;
		val.prev = it.curNode;
		it.curNode.next = val;
		size++;
		
	}
	
	
	
	public T removeAtTail(){
		ListNode<T> n = tail.prev;
		ListNode<T> beforeN = n.prev;
		beforeN.next = tail;
		tail.prev = beforeN;
		size--;
		return n.getData();
		
	}
	
	public T removeAtHead(){
		ListNode<T> n = head.next;
		ListNode<T> afterN = n.next;
		afterN.prev = head;
		head.next = afterN;
		size--;
		return n.getData();
		
	}
	
	/**
	 * Remove based on Iterator position
	 * Sets the iterator to the node AFTER the one removed
	 */
	public T remove(ListIterator<T> it) {
		/* TODO: Implement this method */  
		T index = it.curNode.getData();
		it.curNode.prev.next = it.curNode.next;
		it.curNode.next.prev = it.curNode.prev;
		size--;
		return index;
	}
	
	/**
	 * Returns index of first occurrence of the data in the list, or -1 if not present
	 * @param data
	 * @return
	 */
	public int find(T data) {
		ListNode<T> temp = head.next;
		int i = 0;
		while (temp.next != null) {
			if (temp.getData().equals(data)) {
				return i;
			}
			temp = temp.next;
			i++;
		}
		return -1;
	}
	
	/**
	 * Returns the data at the given index, null if anything goes wrong (index out of bounds, empty list, etc.)
	 * @param index
	 * @return
	 */
	public T get(int index) {
		 int counter = 0;
	     ListNode<T> temp = head;
	     if (index == 0) {
	    	 return head.next.getData();
	     } else if (index == size) {
	    	 return tail.prev.getData();
	     }
	     while (temp != null) {
	    	 if (counter == index) {
	    		 return temp.next.getData();
	    	 }
	    	 temp = temp.next;
	    	 counter++;
	     }
	     return null;
	}
	
	/**
	 * Returns the list as space separated values
	 */
	public String toString() {
		String toRet = "[";
		
		ListNode<T> curNode = head.next;
		while(curNode != tail) {
			toRet += curNode.getData() + ", ";
			curNode = curNode.next;
		}
		
		return toRet + "]";
	}
	
	/* Return iterators at front and end of list */
	public ListIterator<T> front(){ 
		return new ListIterator<T>(head.next);

	}

	public ListIterator<T> back(){
		return new ListIterator<T>(tail.prev);

	}
	
	
}
