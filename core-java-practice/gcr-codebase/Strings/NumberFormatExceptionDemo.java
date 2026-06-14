import java.util.Scanner;

public class NumberFormatExceptionDemo {

    public static int generateNumberFormatException(String text) {
        return Integer.parseInt(text);
    }

    public static void handleNumberFormatException(String text) {
        try {
            System.out.println("Parsed number: " + Integer.parseInt(text));
        } catch (NumberFormatException exception) {
            System.out.println("Handled NumberFormatException: " + exception.getMessage());
        } catch (RuntimeException exception) {
            System.out.println("Handled RuntimeException: " + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.next();

        try {
            System.out.println("Parsed number: " + generateNumberFormatException(text));
        } catch (NumberFormatException exception) {
            System.out.println("Generated NumberFormatException: " + exception.getMessage());
        }

        handleNumberFormatException(text);
    }
}
