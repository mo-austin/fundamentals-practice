
public class SortingAlgorithms {

	/*
	 * Swaps the elements and indices i and j in list
	 * */
	private static <T> void swap(T[] list, int i, int j) { // Swaps elements at indices i and j in the list array
		if (i < 0 || i >= list.length)
			return;
		if (j < 0 || j >= list.length)
			return;
		T temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	
// Insertion sort
	public static <T extends Comparable<T>> void insertionSort(T[] list) { // use insertion sort algorithm to sort the list array 
		for (int i = 1; i < list.length; i++) {
			T val = list[i];
			int j = i - 1;
			while (j >= 0 && val.compareTo(list[j]) < 0) {
				list[j+1] = list[j];
				j--;
			}
			list[j+1] = val;
		}
	}

// Mergesort
	public static<T extends Comparable<T>> void mergeSort(T[] list) { // Implement merge sort algorithm to sort the list array
		mergeSort(list, 0, list.length - 1);
	}
	public static <T extends Comparable<T>> void mergeSort(T[] list, int i, int j) { // Recursively divide list array into smaller sub arrays merges them using the merge method
		if (i < j) {
			int mid = (i + j) / 2;
			mergeSort(list, i, mid);
			mergeSort(list, mid + 1, j);
			merge(list, i, mid, j);
		}
	}

	/**
	 * Merge method for Merge Sort algorithm.
	 * Your mergeSort algorithm will call this method as appropriate to do the merging.
	 * @param list - An array of items
	 * @param i - lower bound index
	 * @param mid - middle index
	 * @param j - upper bound index 
	 */
	public static <T extends Comparable<T>> void merge(T[] list, int i, int mid, int j) { // merges two subarrays into a single sorted array
		int leftSize = mid - i + 1;
		int rightSize = j - mid;

		@SuppressWarnings("unchecked")
		T[] left = (T[]) new Comparable[leftSize];
		@SuppressWarnings("unchecked")
		T[] right = (T[]) new Comparable[rightSize];

		for (int k = 0; k < leftSize; k++) {
			left[k] = list[i + k];
		}
		for (int k = 0; k < rightSize; k++) {
			right[k] = list[mid + 1 + k];
		}

		int leftIndex = 0;
		int rightIndex = 0;
		int mergedIndex = i;

		while (leftIndex < leftSize && rightIndex < rightSize) {
			if (left[leftIndex].compareTo(right[rightIndex]) <= 0) {
				list[mergedIndex] = left[leftIndex];
				leftIndex++;
			} else {
				list[mergedIndex] = right[rightIndex];
				rightIndex++;
			}
			mergedIndex++;
		}

		while (leftIndex < leftSize) {
			list[mergedIndex] = left[leftIndex];
			leftIndex++;
			mergedIndex++;
		}

		while (rightIndex < rightSize) {
			list[mergedIndex] = right[rightIndex];
			rightIndex++;
			mergedIndex++;
		}
	}
	


//Hybrid Merge Sort
	public static <T extends Comparable<T>> void mergeSortHybrid(T[] list) { // Hybrid implementation of merge sort and insertion sort
    mergeSortHybrid(list, 0, list.length - 1);
}

	public static <T extends Comparable<T>> void mergeSortHybrid(T[] list, int i, int j) { // Use merge sort for larger subarrays and insertion for smaller subarrays
		if (j - i + 1 < 100) {
			insertionSort(list, i, j);
		} else {
			mergeSort(list, i, j);
		}
	}

	private static <T extends Comparable<T>> void insertionSort(T[] list, int i, int j) { // Overloaded insertion sort, sort portion of list array specificed by indices i and j
		for (int k = i + 1; k <= j; k++) {
			T val = list[k];
			int l = k - 1;
			while (l >= i && val.compareTo(list[l]) < 0) {
				list[l + 1] = list[l];
				l--;
			}
			list[l + 1] = val;
		}
	}

// Quicksort
	public static <T extends Comparable<T>> void quickSort(T[] list) { // implement quicksort algorithm to sort list array
		quickSort(list, 0, list.length - 1);
	}

	public static <T extends Comparable<T>> void quickSort(T[] list, int low, int high) { // Recursively partitions list array and sorts subarrays using quicksort algorithm
		if (low < high) {
			int pivotIndex = Partition(list, low, high);
			quickSort(list, low, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, high);
		}
	}


	private static <T extends Comparable<T>> int Partition(T[] list, int low, int high) { // partitions list based on a pivot element and return index of pivot element
		T pivot = list[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (list[j].compareTo(pivot) <= 0) {
				i++;
				swap(list, i, j);
			}
		}
		swap(list, i + 1, high);
		return i + 1;
	}
	


// Hybrid Quicksort
	public static <T extends Comparable<T>> void quickSortHybrid(T[] list) { // hybrid implementation of quicksort and insertion sort
		quickSortHybrid(list, 0, list.length - 1);
	}

	public static <T extends Comparable<T>> void quickSortHybrid(T[] list, int low, int high) { // USe quicksort for larger subarrays and insertion sort for smaller arrays
		if (low < high) {
			if (high - low + 1 < 100) {
				insertionSort(list, low, high);
			} else {
				int pivotIndex = partitionHybrid(list, low, high);
				quickSortHybrid(list, low, pivotIndex - 1);
				quickSortHybrid(list, pivotIndex + 1, high);
			}
		}
	}

	/**
	 * Partition method for Quicksort - Use any valid partition algorithm that you like.
	 * Your quickSort algorithm will call this method as appropriate to do the partitioning.
	 * @param list - An array of items
	 * @param i - lower bound
	 * @param j - upper bound
	 */
	private static <T extends Comparable<T>> int partitionHybrid(T[] list, int low, int high) { // partition list array based on a pivot element for hybrid quicksort algorithm
		T pivot = list[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (list[j].compareTo(pivot) <= 0) {
				i++;
				swap(list, i, j);
			}
		}
		swap(list, i + 1, high);
		return i + 1;
	}

}