import java.util.Scanner;

public class InsertionSortEmployeeIDs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                break;
            } else {
                String token = sc.next();
                String cleaned = token.replaceAll("[^0-9-]", "");
                if (!cleaned.isEmpty()) {
                    try {
                        n = Integer.parseInt(cleaned);
                        break;
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
        
        if (n <= 0) {
            sc.close();
            return;
        }
        
        int[] ids = new int[n];
        int count = 0;
        while (count < n && sc.hasNext()) {
            String token = sc.next();
            String cleaned = token.replaceAll("[^\n\r0-9-]", "");
            if (cleaned.isEmpty()) {
                continue;
            }
            try {
                ids[count++] = Integer.parseInt(cleaned);
            } catch (NumberFormatException e) {
            }
        }
        
        insertionSort(ids);
        
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(ids[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");
        sc.close();
    }
    
    private static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
