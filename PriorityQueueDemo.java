package programs;
import java.util.ArrayList;
import java.util.List;

class PriorityQueue {
    private List<Integer> heap;

    // Constructor to initialize the priority queue
    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    // Method to check if the priority queue is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Method to insert an element into the priority queue
    public void insert(int value) {
        // Add the new element to the end of the heap
        heap.add(value);
        // Restore the max-heap property by heapifying up
        heapifyUp(heap.size() - 1);
    }

    // Method to remove and return the maximum element from the priority queue
    public int deleteMax() {
        if (isEmpty()) {
            System.out.println("Priority queue is empty.");
            return -1; // Or handle it according to your logic (e.g., returning a sentinel value)
        }

        // The root is the maximum element
        int max = heap.get(0);
        
        // Move the last element to the root
        int last = heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            heap.set(0, last);
            // Restore the max-heap property by heapifying down
            heapifyDown(0);
        }

        return max;
    }

    // Method to move an element up the heap to restore the max-heap property
    private void heapifyUp(int index) {
        // Compare the element with its parent and swap if necessary
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index) > heap.get(parentIndex)) {
                // Swap the elements
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    // Method to move an element down the heap to restore the max-heap property
    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largest = index;

        // Check if left child exists and is larger than the current element
        if (leftChildIndex < heap.size() && heap.get(leftChildIndex) > heap.get(largest)) {
            largest = leftChildIndex;
        }

        // Check if right child exists and is larger than the current largest element
        if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(largest)) {
            largest = rightChildIndex;
        }

        // If the largest element is not the current element, swap and continue heapifying down
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    // Helper method to swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        
        // Insert elements into the priority queue
        pq.insert(5);
        pq.insert(10);
        pq.insert(3);
        pq.insert(15);

        // Delete and print the max elements
        System.out.println(pq.deleteMax()); // 15
        System.out.println(pq.deleteMax()); // 10
        System.out.println(pq.deleteMax()); // 5
        System.out.println(pq.deleteMax()); // 3

        // Attempting to delete from an empty queue
        System.out.println(pq.deleteMax()); // Will print "Priority queue is empty." and return -1
    }
}
