package list;

/**
 * 
 * A custom built linked list
 * T here is the type the list stores
 */
public class LinkedList<T> implements SimpleList<T>{

	/* Dummy head and tail */
	private ListNode<T> head, tail;
	private int size;
	
	public LinkedList() { // Constructor initializes dummy head and tail
		head = new ListNode<>(null);
        tail = new ListNode<>(null);
        head.next = tail;
		head.prev = null;
        tail.prev = head;
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
		head.next = tail;
        tail.prev = head;
        size = 0; 
	}
	
	/**
	 * Inserts new data at the end of the list (i.e., just before the dummy tail node)
	 * @param data
	 */
	public void insertAtTail(T data) { // Inserts data at the end of the list, modifies affected object attributes
		ListNode<T> newNode = new ListNode<>(data);
		
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;  

	}
	
	/**
	 * Inserts data at the front of the list (i.e., just after the dummy head node
	 * @param data
	 */
	public void insertAtHead(T data) {
		ListNode<T> newNode = new ListNode<>(data);
		newNode.prev = head;
		newNode.next = head.next;
		head.next.prev = newNode;
		head.next = newNode;
		size++;
	}
	
	/**
	 * Inserts node such that index becomes the position of the newly inserted data
	 * @param data
	 * @param index
	 */
	public void insertAt(int index, T data) { 
		if (index > size || index < 0) { // If index out of bounds, don't do anything
			return;
		}
		if (index == size) { // If index is at the end, put it at tail
			insertAtTail(data);
		} else {
			ListNode<T> newNode = new ListNode<>(data);
            ListNode<T> current = head.next;
			for (int i = 0; i < index; i++) { // Set current equal to the data at the given index 
				current = current.next;
			}
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
		}

	}
	
	/**
	 * Inserts data after the node pointed to by iterator
	 */
	public void insert(ListIterator<T> it, T data) {
		if (it != null) {
			ListNode<T> currentNode = it.curNode;
			if (currentNode != null) {
				ListNode<T> newNode = new ListNode<>(data);
				newNode.prev = currentNode; // Change necessary items
				newNode.next = currentNode.next;
				currentNode.next = newNode;
				newNode.next.prev = newNode;
				size++;
			}
		}
	}
	
	
	
	public T removeAtTail(){
		if (size == 0) { // If list empty, return null
            return null;
        }
        ListNode<T> removedNode = tail.prev; // Remove and return last element
        removedNode.prev.next = tail;
        tail.prev = removedNode.prev;
        size--;
        return removedNode.getData();
	}
	
	public T removeAtHead(){
		if (size == 0) { // If list empty, return null
            return null;
        }
        ListNode<T> removedNode = head.next; // Remove and return  first element
        head.next = removedNode.next;
        removedNode.next.prev = head;
        size--;
        return removedNode.getData();
    }

	
	
	/**
	 * Remove based on Iterator position
	 * Sets the iterator to the node AFTER the one removed
	 */
	public T remove(ListIterator<T> it) {
		if (it != null) {
			ListNode<T> currentNode = it.curNode;
			if (currentNode != null && currentNode != tail && currentNode != head) { // validators
				currentNode.prev.next = currentNode.next; // change necessary items
				currentNode.next.prev = currentNode.prev;
				it.curNode = currentNode.next;
				size--;
				return currentNode.getData();
			}
		}

		return null;
	}
	
	/**
	 * Returns index of first occurrence of the data in the list, or -1 if not present
	 * @param data
	 * @return
	 */
	public int find(T data) {
        ListNode<T> find = head.next;
        int index = 0;
        while (find != tail) { // Look at everything to check if anything equals current
            if (find.getData().equals(data)) {
                return index;
            }
            find = find.next;
            index++;
        }
        return -1; // If not found
    }
	
	/**
	 * Returns the data at the given index, null if anything goes wrong (index out of bounds, empty list, etc.)
	 * @param index
	 * @return
	 */
	public T get(int index) { 
		if (index < 0 || index >= size) { // if index out of bounds
            return null;
        }
		ListNode<T> get = head.next;
		for (int i = 0; i < index; i++) { // Set current equal to the data at the given index 
			get = get.next;
		}
		return get.getData();
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
		return new ListIterator<>(head.next);
	}

	public ListIterator<T> back(){
		return new ListIterator<>(tail.prev);
	}
	
	
}
