
package hash;
import java.util.ArrayList;

public class HashTable<K,V> implements SimpleMap<K,V> {

    // Initial capacity of the hash table
    private static final int INITIAL_CAP = 5;

    // ArrayList of ArrayLists to represent the hash table
    private ArrayList<ArrayList<HashNode<K,V>>> table;

    // Track the number of elements in the hash table
    private int size;

    // Constructor to initialize the hash table with default capacity
    public HashTable() {
        this(INITIAL_CAP);
    }

    // Constructor allowing custom initial capacity
    public HashTable(int capacity) {
        // Initialize the ArrayList to hold the hash table
        table = new ArrayList<>(capacity);

        // Populate the table with empty buckets (inner ArrayLists)
        for (int i = 0; i < capacity; i++) {
            table.add(new ArrayList<>());
        }
    }

    // Retrieve the current size of the hash table
    public int getSize() {
        return size;
    }

    // Method to insert a key-value pair into the hash table
    @Override
    public void insert(K key, V value) {
        // Get the index in the table where the node will be inserted
        int index = getIndex(key);
        // Retrieve the bucket (ArrayList) at the calculated index
        ArrayList<HashNode<K,V>> bucket = table.get(index);

        // Check if the key already exists in the bucket and update its value
        for (HashNode<K,V> node : bucket) {
            if (node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
        }

        // Add a new node if the key doesn't already exist in the bucket
        bucket.add(new HashNode<>(key, value));
        size++;
    }

    // Retrieve the value associated with a given key
    @Override
    public V retrieve(K key) {
        // Calculate the index in the table for the given key
        int index = getIndex(key);
        // Retrieve the bucket at the calculated index
        ArrayList<HashNode<K,V>> bucket = table.get(index);

        // Search for the key in the bucket and return its value
        for (HashNode<K,V> node : bucket) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }

        // Return null if the key is not found in the table
        return null;
    }

    // Check if a key exists in the hash table
    @Override
    public boolean contains(K key) {
        // Calculate the index in the table for the given key
        int index = getIndex(key);
        // Retrieve the bucket at the calculated index
        ArrayList<HashNode<K,V>> bucket = table.get(index);

        // Search for the key in the bucket and return true if found
        for (HashNode<K,V> node : bucket) {
            if (node.getKey().equals(key)) {
                return true;
            }
        }

        // Return false if the key is not found in the table
        return false;
    }

    // Remove a key-value pair from the hash table
    @Override
    public void remove(K key) {
        // Calculate the index in the table for the given key
        int index = getIndex(key);
        // Retrieve the bucket at the calculated index
        ArrayList<HashNode<K,V>> bucket = table.get(index);

        // Search for the key in the bucket and remove it if found
        for (HashNode<K,V> node : bucket) {
            if (node.getKey().equals(key)) {
                bucket.remove(node);
                size--;
                return;
            }
        }
    }

    // Helper method to calculate the index for a given key
    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % table.size();
    }



}

