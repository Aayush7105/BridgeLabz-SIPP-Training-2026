package Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Scenario 4: Sliding Window Maximum — Real-Time Network Throughput Alerting
 * Context: Computes max throughput reading within every trailing k-second window using a monotonic deque.
 */
public class SlidingWindowMaxThroughput {

    public static int[] maxThroughputWindow(int[] readings, int k) {
        if (readings == null || readings.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = readings.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // stores indices with values in decreasing order

        for (int i = 0; i < n; i++) {
            // Evict indices that fall outside the trailing window of size k
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Evict indices from back whose values are smaller than or equal to current reading
            while (!deque.isEmpty() && readings[deque.peekLast()] <= readings[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // Record maximum for window ending at index i
            if (i >= k - 1) {
                result[i - k + 1] = readings[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] readings = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] maxes = maxThroughputWindow(readings, k);
        System.out.println("Readings: " + Arrays.toString(readings));
        System.out.println("Window size k: " + k);
        System.out.println("Trailing window maximums: " + Arrays.toString(maxes));
    }
}
