package Collections.Heap;

import java.util.PriorityQueue;

public class KthLargestAdmissionScore {

    public static int findKthLargest(int[] scores, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int score : scores) {
            if (minHeap.size() < k) {
                minHeap.offer(score);
            } else if (score > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(score);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 88, 70, 99};
        int cutoffRank = 3;
        System.out.println(findKthLargest(scores, cutoffRank));
    }
}
