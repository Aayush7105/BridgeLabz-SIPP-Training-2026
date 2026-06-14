import java.util.Scanner;

public class StringLengthWithoutLength {

    public static int findLength(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException exception) {
                return count;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.next();

        System.out.println("Length without length(): " + findLength(text));
        System.out.println("Length using length(): " + text.length());
    }
}
