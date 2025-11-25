package org.example;
import java.util.ArrayList;
import java.util.List;

public class FindKLargest {
    public List<Integer> findKLargest(int[] arr, int k) {
        MinHeap heap = new MinHeap(k);

        for (int value : arr) {
            if (heap.size() < k) {
                heap.insert(value);
            } else if (value > heap.peek()) {
                heap.extractMin();
                heap.insert(value);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (heap.size() > 0) {
            result.add(heap.extractMin());
        }

        return result;
    }
}
