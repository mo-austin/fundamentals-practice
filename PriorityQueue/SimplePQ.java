
package pq;


public interface SimplePQ<T> {
    /**
     * Add the given element to the priority queue
     * @param element
     */
    public void add(T t);

    /**
     * Remove all elements from the priority queue; clear it
     * @param element
     */
    public void clear();

    /**
     * return true iff this value is already in the priority queue
     * @param element
     */
    public boolean contains(Object o);

    /**
     * returns item with highest priority; null if priority queue is empty; no change to priority queue
     * @return element
     */
    public T peek();

    /**
     * removes and returns item with highest priority; null if priority queue is empty
     * @return element
     */
    public T remove();

    /**
     * return the number of elements in the priority queue
     * @return number of elements
     */
    public int size();
}
