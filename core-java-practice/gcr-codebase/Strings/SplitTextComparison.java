import java.util.Arrays;
import java.util.Scanner;

public class SplitTextComparison {

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

    public static String[] splitText(String text) {
        int length = findLength(text);
        if (length == 0) {
            return new String[]{""};
        }

        int spaces = 0;
        int trailingSpaces = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaces++;
            }
        }
        for (int i = length - 1; i >= 0 && text.charAt(i) == ' '; i--) {
            trailingSpaces++;
        }

        int wordCount = spaces + 1 - trailingSpaces;
        if (wordCount <= 0) {
            return new String[0];
        }

        String[] words = new String[wordCount];
        int wordIndex = 0;
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < length && wordIndex < wordCount; i++) {
            char character = text.charAt(i);
            if (character == ' ') {
                words[wordIndex] = currentWord.toString();
                wordIndex++;
                currentWord.setLength(0);
            } else {
                currentWord.append(character);
            }
        }

        if (wordIndex < wordCount) {
            words[wordIndex] = currentWord.toString();
        }
        return words;
    }

    public static boolean compareStringArrays(String[] first, String[] second) {
        if (first.length != second.length) {
            return false;
        }

        for (int i = 0; i < first.length; i++) {
            if (!first[i].equals(second[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] userDefinedWords = splitText(text);
        String[] builtInWords = text.split(" ");

        System.out.println("Words using charAt(): " + Arrays.toString(userDefinedWords));
        System.out.println("Words using split(): " + Arrays.toString(builtInWords));
        System.out.println("Both arrays are same: " + compareStringArrays(userDefinedWords, builtInWords));
    }
}
