import java.util.Scanner;

public class LowercaseConversionComparison {

    public static String convertToLowercase(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (character >= 'A' && character <= 'Z') {
                character = (char) (character + 32);
            }
            result.append(character);
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

        String userDefinedLowercase = convertToLowercase(text);
        String builtInLowercase = text.toLowerCase();

        System.out.println("Lowercase using charAt(): " + userDefinedLowercase);
        System.out.println("Lowercase using toLowerCase(): " + builtInLowercase);
        System.out.println("Both results are same: " + compareUsingCharAt(userDefinedLowercase, builtInLowercase));
    }
}
