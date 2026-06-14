import java.util.Scanner;

public class IllegalArgumentExceptionDemo {

    public static String generateIllegalArgumentException(String text) {
        int start = text.length();
        int end = 0;

        if (start > end) {
            throw new IllegalArgumentException("Start index cannot be greater than end index");
        }
        return text.substring(start, end);
    }

    public static void handleIllegalArgumentException(String text) {
        try {
            System.out.println(generateIllegalArgumentException(text));
        } catch (IllegalArgumentException exception) {
            System.out.println("Handled IllegalArgumentException: " + exception.getMessage());
        } catch (RuntimeException exception) {
            System.out.println("Handled RuntimeException: " + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.next();

        try {
            System.out.println(generateIllegalArgumentException(text));
        } catch (IllegalArgumentException exception) {
            System.out.println("Generated IllegalArgumentException: " + exception.getMessage());
        }

        handleIllegalArgumentException(text);
    }
}
