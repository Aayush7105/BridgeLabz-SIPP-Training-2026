package Collections.Heap;

import java.util.Arrays;

public class SensorReadingHeapSort {

    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDownMax(arr, i, n);
        }
        for (int end = n - 1; end > 0; end--) {
            int tmp = arr[0]; arr[0] = arr[end]; arr[end] = tmp;
            siftDownMax(arr, 0, end);
        }
    }

    private static void siftDownMax(int[] arr, int i, int size) {
        int largest = i;
        int left = 2 * i + 1, right = 2 * i + 2;
        if (left < size && arr[left] > arr[largest]) largest = left;
        if (right < size && arr[right] > arr[largest]) largest = right;
        if (largest != i) {
            int tmp = arr[i]; arr[i] = arr[largest]; arr[largest] = tmp;
            siftDownMax(arr, largest, size);
        }
    }

    public static void main(String[] args) {
        int[] readings = {102, 98, 105, 88, 92, 110, 95};
        heapSort(readings);
        System.out.println(Arrays.toString(readings));
    }
}
