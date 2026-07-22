package TwoPointer;

public class CpuSpikeDetector {
    public static int maxSubarrayOfSizeK(int[] cpuLoad, int k) {
        int windowSum = 0, maxSum = Integer.MIN_VALUE;
        int start = 0;
        for (int end = 0; end < cpuLoad.length; end++) {
            windowSum += cpuLoad[end];
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= cpuLoad[start];
                start++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] cpuLoad = {20, 45, 80, 95, 90, 30, 40};
        int k = 5;
        System.out.println(maxSubarrayOfSizeK(cpuLoad, k));
    }
}
