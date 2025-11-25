package org.example;

public class MedianFinder {
    private MaxHeap lower; // lower half
    private MinHeap upper; // upper half

    public MedianFinder(int capacity) {
        this.lower = new MaxHeap(capacity);
        this.upper = new MinHeap(capacity);
    }

    public void addNumber(int num) {
        if (lower.size() == 0 || num <= lower.peek()) {
            lower.insert(num);
        } else {
            upper.insert(num);
        }

        balanceHeaps();
    }

    private void balanceHeaps() {
        if (lower.size() > upper.size() + 1) {
            upper.insert(lower.extractMax());
        } else if (upper.size() > lower.size()) {
            lower.insert(upper.extractMin());
        }
    }

    public double findMedian() {
        if (lower.size() == upper.size()) {
            return (lower.peek() + upper.peek()) / 2.0;
        }
        return lower.peek();
    }
}
