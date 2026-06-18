import java.util.Scanner;

public class GenerateAllSubsets {

    static void generateSubsets(int[] arr, int index, int[] subset, int subsetSize) {
        if (index == arr.length) {
            System.out.print("[");
            for (int i = 0; i < subsetSize; i++) {
                System.out.print(subset[i]);
                if (i < subsetSize - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
            return;
        }
        generateSubsets(arr, index + 1, subset, subsetSize);
        subset[subsetSize] = arr[index];
        generateSubsets(arr, index + 1, subset, subsetSize + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] subset = new int[n];
        generateSubsets(arr, 0, subset, 0);
        sc.close();
    }
}
