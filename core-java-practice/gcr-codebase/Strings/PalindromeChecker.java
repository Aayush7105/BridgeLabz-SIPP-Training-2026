import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindromeUsingLoop(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeUsingRecursion(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeUsingRecursion(text, start + 1, end - 1);
    }

    public static char[] reverseUsingCharAt(String text) {
        char[] reverse = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            reverse[i] = text.charAt(text.length() - 1 - i);
        }
        return reverse;
    }

    public static boolean isPalindromeUsingArray(String text) {
        char[] original = text.toCharArray();
        char[] reverse = reverseUsingCharAt(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        System.out.println("Palindrome using loop: " + isPalindromeUsingLoop(text));
        System.out.println("Palindrome using recursion: " + isPalindromeUsingRecursion(text, 0, text.length() - 1));
        System.out.println("Palindrome using arrays: " + isPalindromeUsingArray(text));
    }
}
