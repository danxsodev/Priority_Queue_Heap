package org.example;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== EXERCÍCIO 1: K Maiores Elementos ===");

        FindKLargest ex1 = new FindKLargest();
        int[] arr = {3, 10, 5, 6, 20, 1, 7};
        List<Integer> kLargest = ex1.findKLargest(arr, 3);
        System.out.println("Top 3 maiores valores: " + kLargest);


        System.out.println("\n=== EXERCÍCIO 2: Mesclar K Listas Ordenadas ===");

        MergeKLists ex2 = new MergeKLists();
        List<List<Integer>> lists = new ArrayList<>();

        lists.add(Arrays.asList(1, 5, 8));
        lists.add(Arrays.asList(2, 3, 7));
        lists.add(Arrays.asList(0, 4, 9));

        List<Integer> merged = ex2.merge(lists);
        System.out.println("Lista mesclada: " + merged);


        System.out.println("\n=== EXERCÍCIO 3: Fila de Prioridade Dupla ===");

        DualPriorityQueue dpq = new DualPriorityQueue(20);
        dpq.insert(10);
        dpq.insert(4);
        dpq.insert(25);
        dpq.insert(1);

        System.out.println("Mínimo atual: " + dpq.getMin());
        System.out.println("Máximo atual: " + dpq.getMax());
        System.out.println("Removendo o maior:" + dpq.removeMax());
        System.out.println("Removendo o menor: " + dpq.removeMin());


        System.out.println("\n=== EXERCÍCIO 4: Verificar Min-Heap ===");

        IsMinHeap ex4 = new IsMinHeap();
        int[] heapCandidate = {1, 3, 5, 7, 9, 8};

        System.out.println("O array é um Min-Heap válido? " + ex4.isMinHeap(heapCandidate));


        System.out.println("\n=== EXERCÍCIO 5: Calculadora de Mediana ===");

        MedianFinder mf = new MedianFinder(50);
        int[] stream = {5, 2, 10, 3, 8};

        for (int num : stream) {
            mf.addNumber(num);
            System.out.println("Número adicionado: " + num + " | Mediana atual = " + mf.findMedian());
        }
    }
}
