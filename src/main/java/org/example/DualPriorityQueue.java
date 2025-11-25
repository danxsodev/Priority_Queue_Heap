package org.example;

public class DualPriorityQueue {
    private MinHeap minHeap;
    private MaxHeap maxHeap;

    public DualPriorityQueue(int capacity) {
        this.minHeap = new MinHeap(capacity);
        this.maxHeap = new MaxHeap(capacity);
    }

    public void insert(int value) {
        minHeap.insert(value);
        maxHeap.insert(value);
    }

    public int getMin() {
        return minHeap.peek();
    }

    public int getMax() {
        return maxHeap.peek();
    }

    public int removeMin() {
        return minHeap.extractMin();
    }

    public int removeMax() {
        return maxHeap.extractMax();
    }
}
