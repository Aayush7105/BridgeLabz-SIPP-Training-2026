import java.util.Scanner;

public class UppercaseConversionComparison {

    public static String convertToUppercase(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (character >= 'a' && character <= 'z') {
                character = (char) (character - 32);
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

        String userDefinedUppercase = convertToUppercase(text);
        String builtInUppercase = text.toUpperCase();

        System.out.println("Uppercase using charAt(): " + userDefinedUppercase);
        System.out.println("Uppercase using toUpperCase(): " + builtInUppercase);
        System.out.println("Both results are same: " + compareUsingCharAt(userDefinedUppercase, builtInUppercase));
    }
}
