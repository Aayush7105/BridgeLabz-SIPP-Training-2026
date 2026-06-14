import java.util.Scanner;

public class VowelConsonantCount {

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

    public static int[] countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            String type = getCharacterType(text.charAt(i));
            if (type.equals("Vowel")) {
                vowels++;
            } else if (type.equals("Consonant")) {
                consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        int[] counts = countVowelsAndConsonants(text);
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
    }
}
