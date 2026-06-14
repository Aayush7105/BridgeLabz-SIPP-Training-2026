import java.util.Arrays;
import java.util.Scanner;

public class CharactersUsingMethod {

    public static char[] getCharacters(String text) {
        char[] characters = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            characters[i] = text.charAt(i);
        }
        return characters;
    }

    public static boolean compareCharArrays(char[] first, char[] second) {
        if (first.length != second.length) {
            return false;
        }

        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.next();

        char[] userDefinedCharacters = getCharacters(text);
        char[] builtInCharacters = text.toCharArray();

        System.out.println("Characters using charAt(): " + Arrays.toString(userDefinedCharacters));
        System.out.println("Characters using toCharArray(): " + Arrays.toString(builtInCharacters));
        System.out.println("Both arrays are same: " + compareCharArrays(userDefinedCharacters, builtInCharacters));
    }
}
