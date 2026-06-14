import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    public static void generateArrayIndexOutOfBoundsException(String[] names) {
        System.out.println(names[names.length]);
    }

    public static void handleArrayIndexOutOfBoundsException(String[] names) {
        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Handled ArrayIndexOutOfBoundsException: " + exception.getMessage());
        } catch (RuntimeException exception) {
            System.out.println("Handled RuntimeException: " + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of names: ");
        int size = scanner.nextInt();
        String[] names = new String[size];

        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.next();
        }

        try {
            generateArrayIndexOutOfBoundsException(names);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Generated ArrayIndexOutOfBoundsException: " + exception.getMessage());
        }

        handleArrayIndexOutOfBoundsException(names);
    }
}
