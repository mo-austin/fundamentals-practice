

package pq;

import java.util.ArrayList; // Import ArrayList class from java.util package
import java.util.List; // Import List interface from java.util package




public class MyPriorityQueue<T extends Comparable<T>> implements SimplePQ<T> { 

    private List<T> heap; // Declare a private instance variable heap of type List<T>

    public MyPriorityQueue() { // Constructor of the MyPriorityQueue class
        heap = new ArrayList<>(); // Initialize the heap variable as a new ArrayList
    }

    @Override
    public void add(T element) { // Method to add an element to the heap list
        heap.add(element); // Add the element to the heap list
        heapifyUp(heap.size() - 1); // Call the heapifyUp method to maintain the heap property
    }

    @Override
    public void clear() { // Method to clear all elements from the heap list
        heap.clear(); // Clear the heap list
    }

    @Override
    public boolean contains(Object o) { // Method to check if the heap list contains a specified object
        return heap.contains(o); // Return true if the heap list contains the object, otherwise return false
    }

    @Override
    public T peek() { // Method to get the top element of the heap
        if (heap.isEmpty()) { // Check if the heap is empty
            return null; // Return null if the heap is empty
        }
        return heap.get(0); // Return the top element of the heap
    }

    @Override
    public T remove() {// Method to remove an element from the heap
        if (heap.isEmpty()) { // check if heap empty, return null if it is
            return null;
        }

        T removedElement = heap.get(0);
        T lastElement = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }

        return removedElement;
    }

    @Override
    public int size() { // Method to get the size of the heap
        return heap.size(); // Return the size of the heap
    }

    private void heapifyUp(int index) { // Method to maintain the heap property by moving an element up the heap
        while (index > 0) { // Loop until the element reaches the root of the heap
            int parentIndex = (index - 1) / 2; // Calculate the index of the parent element
            if (heap.get(index).compareTo(heap.get(parentIndex)) > 0) { // Compare the element with its parent
                swap(index, parentIndex); // Swap the element with its parent if it is smaller
                index = parentIndex; // Update the index to the parent index
            } else {
                break; // Break the loop if the element is in the correct position
            }
        }
    }


private void heapifyDown(int index) {
    T task = heap.get(index);
    int childIndex;

    while ((childIndex = 2 * index + 1) < heap.size()) { // Loop until the index has a left child
        if (childIndex + 1 < heap.size() && heap.get(childIndex + 1).compareTo(heap.get(childIndex)) > 0) {
            childIndex++; // Choose the larger child
        }

        if (heap.get(childIndex).compareTo(task) <= 0) {
            break; // Break the loop if the child is smaller or equal to the task
        }

        heap.set(index, heap.get(childIndex)); // Move the larger child up
        index = childIndex; // Update the index to the child index
    }

    heap.set(index, task); // Set the task at the final index
}


    private void swap(int a, int b) { // Method to swap two elements in the heap
        T temp = heap.get(a); // Get the element at index i
        heap.set(a, heap.get(b)); // Replace the element at index i with the element at index j
        heap.set(b, temp); // Replace the element at index j with the temporary element
    }


}