import java.util.Scanner;

public class CharacterFrequency {

    public static String[][] findCharacterFrequency(String text) {
        int[] frequency = new int[256];
        boolean[] added = new boolean[256];
        int uniqueCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (character < 256) {
                if (frequency[character] == 0) {
                    uniqueCount++;
                }
                frequency[character]++;
            }
        }

        String[][] result = new String[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (character < 256 && !added[character]) {
                result[index][0] = String.valueOf(character);
                result[index][1] = String.valueOf(frequency[character]);
                added[character] = true;
                index++;
            }
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

        displayFrequency(findCharacterFrequency(text));
    }
}
