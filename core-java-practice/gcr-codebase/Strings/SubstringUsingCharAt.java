import java.util.Scanner;

public class SubstringUsingCharAt {

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
        String text = scanner.next();
        System.out.print("Enter start index: ");
        int start = scanner.nextInt();
        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        if (start < 0 || end > text.length() || start > end) {
            System.out.println("Invalid start or end index");
            return;
        }

        String userDefinedSubstring = createSubstring(text, start, end);
        String builtInSubstring = text.substring(start, end);

        System.out.println("Substring using charAt(): " + userDefinedSubstring);
        System.out.println("Substring using substring(): " + builtInSubstring);
        System.out.println("Both results are same: " + compareUsingCharAt(userDefinedSubstring, builtInSubstring));
    }
}
