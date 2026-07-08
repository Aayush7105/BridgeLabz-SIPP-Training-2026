import java.util.Scanner;

public class BubbleSortStudentMarks {
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
        
        int[] marks = new int[n];
        int count = 0;
        while (count < n && sc.hasNext()) {
            String token = sc.next();
            String cleaned = token.replaceAll("[^\n\r0-9-]", "");
            if (cleaned.isEmpty()) {
                continue;
            }
            try {
                marks[count++] = Integer.parseInt(cleaned);
            } catch (NumberFormatException e) {
            }
        }
        
        bubbleSort(marks);
        
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(marks[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");
        sc.close();
    }
    
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
