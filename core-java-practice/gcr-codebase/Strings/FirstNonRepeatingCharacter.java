import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingCharacter(String text) {
        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (character < 256) {
                frequency[character]++;
            }
        }

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (character < 256 && frequency[character] == 1) {
                return character;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        char result = findFirstNonRepeatingCharacter(text);
        if (result == '\0') {
            System.out.println("No non-repeating character found");
        } else {
            System.out.println("First non-repeating character: " + result);
        }
    }
}
