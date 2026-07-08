

import java.util.Scanner;

public class MergeSortPatientIDs {
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
        
        int[] patientIDs = new int[n];
        int count = 0;
        while (count < n && sc.hasNext()) {
            String token = sc.next();
            String cleaned = token.replaceAll("[^\n\r0-9-]", "");
            if (cleaned.isEmpty()) {
                continue;
            }
            try {
                patientIDs[count++] = Integer.parseInt(cleaned);
            } catch (NumberFormatException e) {
            }
        }
        
        mergeSort(patientIDs, 0, n - 1);
        
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(patientIDs[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");
        sc.close();
    }
    
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);
        
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        
        while (i < n1) {
            arr[k++] = L[i++];
        }
        
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }
}
