package Collections.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKCustomersTracker {

    public static List<Integer> topKLargest(int[] transactions, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int amount : transactions) {
            if (minHeap.size() < k) {
                minHeap.offer(amount);
            } else if (amount > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(amount);
            }
        }
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] transactions = {50, 1200, 300, 4500, 800, 9500, 200, 6000};
        System.out.println(topKLargest(transactions, 3));
    }
}
