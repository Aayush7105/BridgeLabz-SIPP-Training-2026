import java.util.Scanner;

public class SelectionSortExamScores {
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
        
        int[] scores = new int[n];
        int count = 0;
        while (count < n && sc.hasNext()) {
            String token = sc.next();
            String cleaned = token.replaceAll("[^\n\r0-9-]", "");
            if (cleaned.isEmpty()) {
                continue;
            }
            try {
                scores[count++] = Integer.parseInt(cleaned);
            } catch (NumberFormatException e) {
            }
        }
        
        selectionSort(scores);
        
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(scores[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");
        sc.close();
    }
    
    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}
