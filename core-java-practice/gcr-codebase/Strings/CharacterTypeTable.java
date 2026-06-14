import java.util.Scanner;

public class CharacterTypeTable {

    public static String getCharacterType(char character) {
        if (character >= 'A' && character <= 'Z') {
            character = (char) (character + 32);
        }

        if (character < 'a' || character > 'z') {
            return "Not a Letter";
        }

        if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
            return "Vowel";
        }
        return "Consonant";
    }

    public static String[][] getCharacterTypes(String text) {
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            result[i][0] = String.valueOf(text.charAt(i));
            result[i][1] = getCharacterType(text.charAt(i));
        }
        return result;
    }

    public static void displayTable(String[][] characterTypes) {
        System.out.printf("%-12s %-15s%n", "Character", "Type");
        for (String[] row : characterTypes) {
            System.out.printf("%-12s %-15s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        displayTable(getCharacterTypes(text));
    }
}
