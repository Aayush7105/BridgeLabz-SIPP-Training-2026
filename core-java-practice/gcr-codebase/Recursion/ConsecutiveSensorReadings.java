import java.util.Scanner;

public class ConsecutiveSensorReadings {

    static boolean isStrictlyIncreasing(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }
        if (arr[index] >= arr[index + 1]) {
            return false;
        }
        return isStrictlyIncreasing(arr, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(isStrictlyIncreasing(arr, 0));
        sc.close();
    }
}
