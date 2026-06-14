import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    public static void generateStringIndexOutOfBoundsException(String text) {
        System.out.println(text.charAt(text.length()));
    }

    public static void handleStringIndexOutOfBoundsException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException exception) {
            System.out.println("Handled StringIndexOutOfBoundsException: " + exception.getMessage());
        } catch (RuntimeException exception) {
            System.out.println("Handled RuntimeException: " + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.next();

        try {
            generateStringIndexOutOfBoundsException(text);
        } catch (StringIndexOutOfBoundsException exception) {
            System.out.println("Generated StringIndexOutOfBoundsException: " + exception.getMessage());
        }

        handleStringIndexOutOfBoundsException(text);
    }
}
