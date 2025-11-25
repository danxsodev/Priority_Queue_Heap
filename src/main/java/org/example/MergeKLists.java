package org.example;
import java.util.ArrayList;
import java.util.List;

public class MergeKLists {

    private static class MergeNode {
        public int value;
        public int listIndex;
        public int elementIndex;

        public MergeNode(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }
    }

    private static class MergeMinHeap {

        private MergeNode[] data;
        private int size;

        public MergeMinHeap(int capacity) {
            this.data = new MergeNode[capacity];
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void insert(MergeNode node) {
            data[size] = node;
            siftUp(size);
            size++;
        }

        public MergeNode extractMin() {
            MergeNode min = data[0];
            data[0] = data[size - 1];
            size--;
            siftDown(0);
            return min;
        }

        private void siftUp(int index) {
            while (index > 0) {
                int parent = (index - 1) / 2;

                if (data[parent].value > data[index].value) {
                    swap(parent, index);
                    index = parent;
                } else break;
            }
        }

        private void siftDown(int index) {
            while (true) {
                int left = 2 * index + 1;
                int right = 2 * index + 2;
                int smallest = index;

                if (left < size && data[left].value < data[smallest].value) smallest = left;
                if (right < size && data[right].value < data[smallest].value) smallest = right;

                if (smallest != index) {
                    swap(smallest, index);
                    index = smallest;
                } else break;
            }
        }

        private void swap(int a, int b) {
            MergeNode temp = data[a];
            data[a] = data[b];
            data[b] = temp;
        }
    }

    public List<Integer> merge(List<List<Integer>> lists) {
        MergeMinHeap heap = new MergeMinHeap(lists.size());
        List<Integer> result = new ArrayList<>();

        // Insert first elements of each list
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                heap.insert(
                        new MergeNode(
                                lists.get(i).get(0),
                                i,
                                0
                        )
                );
            }
        }

        while (!heap.isEmpty()) {
            MergeNode node = heap.extractMin();
            result.add(node.value);

            int nextIndex = node.elementIndex + 1;

            if (nextIndex < lists.get(node.listIndex).size()) {
                heap.insert(
                        new MergeNode(
                                lists.get(node.listIndex).get(nextIndex),
                                node.listIndex,
                                nextIndex
                        )
                );
            }
        }

        return result;
    }
}
