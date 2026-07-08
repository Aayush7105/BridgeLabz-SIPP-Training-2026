
public class FindMax {
    public static <T extends Comparable<T>> T findMax(T[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] intArr = {1, 5, 3, 9, 2};
        System.out.println("Max integer: " + findMax(intArr));

        String[] strArr = {"apple", "orange", "banana", "grape"};
        System.out.println("Max string: " + findMax(strArr));
    }
}
