import java.util.Scanner;

public class CompareStringsUsingCharAt {

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

        System.out.print("Enter first string: ");
        String first = scanner.next();
        System.out.print("Enter second string: ");
        String second = scanner.next();

        boolean userDefinedResult = compareUsingCharAt(first, second);
        boolean builtInResult = first.equals(second);

        System.out.println("Result using charAt(): " + userDefinedResult);
        System.out.println("Result using equals(): " + builtInResult);
        System.out.println("Both results are same: " + (userDefinedResult == builtInResult));
    }
}
