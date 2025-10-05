package algorithms;

import metrics.PerformanceTracker;

import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;
    private PerformanceTracker tracker;

    public MaxHeap(int capacity, PerformanceTracker tracker) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
        this.tracker = tracker;
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }

    private void swap(int i, int j) {
        tracker.incrementSwaps();
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int key) {
        if (size == capacity) {
            capacity *= 2;
            heap = Arrays.copyOf(heap, capacity);
        }
        heap[size] = key;
        size++;
        tracker.incrementArrayAccesses();
        siftUp(size - 1);
    }

    private void siftUp(int i) {
        while (i > 0 && heap[parent(i)] < heap[i]) {
            tracker.incrementComparisons();
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void siftDown(int i) {
        int maxIndex = i;

        int l = left(i);
        if (l < size && heap[l] > heap[maxIndex]) {
            tracker.incrementComparisons();
            maxIndex = l;
        }

        int r = right(i);
        if (r < size && heap[r] > heap[maxIndex]) {
            tracker.incrementComparisons();
            maxIndex = r;
        }

        if (i != maxIndex) {
            swap(i, maxIndex);
            siftDown(maxIndex);
        }
    }

    public int extractMax() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        int result = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return result;
    }

    public void increaseKey(int i, int newVal) {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException("Invalid index");
        if (newVal < heap[i]) throw new IllegalArgumentException("New value is smaller");

        heap[i] = newVal;
        siftUp(i);
    }

    public int getMax() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        return heap[0];
    }

    public int getSize() { return size; }

    public boolean isEmpty() { return size == 0; }
}
