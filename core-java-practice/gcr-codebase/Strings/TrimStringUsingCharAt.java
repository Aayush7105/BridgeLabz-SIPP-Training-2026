import java.util.Scanner;

public class TrimStringUsingCharAt {

    public static int[] getTrimIndexes(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end + 1};
    }

    public static String createSubstring(String text, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(text.charAt(i));
        }
        return result.toString();
    }

    public static boolean compareUsingCharAt(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        int[] indexes = getTrimIndexes(text);
        String userDefinedTrim = createSubstring(text, indexes[0], indexes[1]);
        String builtInTrim = text.trim();

        System.out.println("Trim using charAt(): '" + userDefinedTrim + "'");
        System.out.println("Trim using trim(): '" + builtInTrim + "'");
        System.out.println("Both results are same: " + compareUsingCharAt(userDefinedTrim, builtInTrim));
    }
}
