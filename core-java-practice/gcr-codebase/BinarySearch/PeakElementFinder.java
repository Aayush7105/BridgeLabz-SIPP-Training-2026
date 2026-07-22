package BinarySearch;

public class PeakElementFinder {

    public static int findPeakElement(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean leftOk = (mid == 0 || arr[mid] > arr[mid - 1]);
            boolean rightOk = (mid == n - 1 || arr[mid] > arr[mid + 1]);

            if (leftOk && rightOk) {
                return mid;
            } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 5, 6, 4};
        int peakIndex = findPeakElement(arr);
        System.out.println("Peak element index: " + peakIndex + ", value: " + arr[peakIndex]);
    }
}
