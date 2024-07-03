package queue;
import list.LinkedList;
/**
 * A Linked-List based Queue
 * @param <T>
 */
public class Queue<T> implements IQueue<T>{
	private LinkedList<T> list;
	/**
	 * Constructor: Initialize the inner list 
	 */
	public Queue(){
		list = new LinkedList<T>();
	}
	
	/**
	 * Return the size by invoking the size of the list
	 */
	public int size() { 
		return list.size();
	}
	
	/**
	 * Simply add the data to the tail of the linked list
	 */
	public void enqueue(T data) {
		list.insertAtTail(data);
	}
	
	/**
	 * Simply remove data from the head of the list, throw exception if list is empty.
	 */
	public T dequeue() throws EmptyQueueException {		
		if (list.size() == 0) {
			throw new EmptyQueueException("Queue is empty");
		} 
		return list.removeAtHead();

	}

	/**
	 * Simply return the value from the head of the list, list should remain unchanged 
         * throw exception if list is empty.
	 */
	public T peek() throws EmptyQueueException {		
		if (list.size() == 0) {
			throw new EmptyQueueException("Queue is empty");
		} 
		return list.get(0);
	}
}
