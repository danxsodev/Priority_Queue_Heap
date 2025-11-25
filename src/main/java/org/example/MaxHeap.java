package org.example;

public class MaxHeap {

    private int[] data;
    private int size;

    public MaxHeap(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public int peek() {
        return data[0];
    }

    public void insert(int value) {
        data[size] = value;
        siftUp(size);
        size++;
    }

    public int extractMax() {
        int max = data[0];
        data[0] = data[size - 1];
        size--;
        siftDown(0);
        return max;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (data[parent] < data[index]) {
                swap(parent, index);
                index = parent;
            } else break;
        }
    }

    private void siftDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;

            if (left < size && data[left] > data[largest]) largest = left;
            if (right < size && data[right] > data[largest]) largest = right;

            if (largest != index) {
                swap(largest, index);
                index = largest;
            } else break;
        }
    }

    private void swap(int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
