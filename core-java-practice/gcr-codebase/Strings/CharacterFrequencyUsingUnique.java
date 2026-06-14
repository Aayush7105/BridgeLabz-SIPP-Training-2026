import java.util.Scanner;

public class CharacterFrequencyUsingUnique {

    public static char[] findUniqueCharacters(String text) {
        char[] uniqueCharacters = new char[text.length()];
        int uniqueCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                uniqueCharacters[uniqueCount] = current;
                uniqueCount++;
            }
        }

        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = uniqueCharacters[i];
        }
        return result;
    }

    public static String[][] findFrequencyUsingUniqueCharacters(String text) {
        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (character < 256) {
                frequency[character]++;
            }
        }

        char[] uniqueCharacters = findUniqueCharacters(text);
        String[][] result = new String[uniqueCharacters.length][2];
        for (int i = 0; i < uniqueCharacters.length; i++) {
            char character = uniqueCharacters[i];
            result[i][0] = String.valueOf(character);
            result[i][1] = character < 256 ? String.valueOf(frequency[character]) : "1";
        }
        return result;
    }

    public static void displayFrequency(String[][] frequencies) {
        System.out.printf("%-12s %-10s%n", "Character", "Frequency");
        for (String[] row : frequencies) {
            System.out.printf("%-12s %-10s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        displayFrequency(findFrequencyUsingUniqueCharacters(text));
    }
}
