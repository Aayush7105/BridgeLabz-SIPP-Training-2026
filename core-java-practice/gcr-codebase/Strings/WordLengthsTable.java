import java.util.Scanner;

public class WordLengthsTable {

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
        int wordCount = 0;
        boolean inWord = false;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (text.charAt(i) == ' ') {
                inWord = false;
            }
        }

        String[] words = new String[wordCount];
        int wordIndex = 0;
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char character = text.charAt(i);
            if (character == ' ') {
                if (currentWord.length() > 0) {
                    words[wordIndex] = currentWord.toString();
                    wordIndex++;
                    currentWord.setLength(0);
                }
            } else {
                currentWord.append(character);
            }
        }

        if (currentWord.length() > 0) {
            words[wordIndex] = currentWord.toString();
        }
        return words;
    }

    public static String[][] getWordLengths(String[] words) {
        String[][] wordLengths = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            wordLengths[i][0] = words[i];
            wordLengths[i][1] = String.valueOf(findLength(words[i]));
        }
        return wordLengths;
    }

    public static void displayTable(String[][] wordLengths) {
        System.out.printf("%-20s %10s%n", "Word", "Length");
        for (String[] row : wordLengths) {
            int length = Integer.parseInt(row[1]);
            System.out.printf("%-20s %10d%n", row[0], length);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] words = splitText(text);
        String[][] wordLengths = getWordLengths(words);
        displayTable(wordLengths);
    }
}
