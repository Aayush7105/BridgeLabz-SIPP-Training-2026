import java.util.Scanner;

public class ShortestLongestWords {

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

    public static int[] findShortestAndLongest(String[][] wordLengths) {
        if (wordLengths.length == 0) {
            return new int[]{-1, -1};
        }

        int shortestIndex = 0;
        int longestIndex = 0;
        for (int i = 1; i < wordLengths.length; i++) {
            int currentLength = Integer.parseInt(wordLengths[i][1]);
            int shortestLength = Integer.parseInt(wordLengths[shortestIndex][1]);
            int longestLength = Integer.parseInt(wordLengths[longestIndex][1]);

            if (currentLength < shortestLength) {
                shortestIndex = i;
            }
            if (currentLength > longestLength) {
                longestIndex = i;
            }
        }
        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[][] wordLengths = getWordLengths(splitText(text));
        int[] indexes = findShortestAndLongest(wordLengths);

        if (indexes[0] == -1) {
            System.out.println("No words found");
            return;
        }

        System.out.println("Shortest word: " + wordLengths[indexes[0]][0] + " (" + wordLengths[indexes[0]][1] + ")");
        System.out.println("Longest word: " + wordLengths[indexes[1]][0] + " (" + wordLengths[indexes[1]][1] + ")");
    }
}
