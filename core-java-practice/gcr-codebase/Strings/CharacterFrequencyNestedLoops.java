import java.util.Scanner;

public class CharacterFrequencyNestedLoops {

    public static String[] findCharacterFrequency(String text) {
        char[] characters = text.toCharArray();
        int[] frequencies = new int[characters.length];
        int resultCount = 0;

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == '0') {
                continue;
            }

            frequencies[i] = 1;
            for (int j = i + 1; j < characters.length; j++) {
                if (characters[i] == characters[j]) {
                    frequencies[i]++;
                    characters[j] = '0';
                }
            }
            resultCount++;
        }

        String[] result = new String[resultCount];
        int index = 0;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != '0') {
                result[index] = characters[i] + " : " + frequencies[i];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] frequencies = findCharacterFrequency(text);
        for (String frequency : frequencies) {
            System.out.println(frequency);
        }
    }
}
