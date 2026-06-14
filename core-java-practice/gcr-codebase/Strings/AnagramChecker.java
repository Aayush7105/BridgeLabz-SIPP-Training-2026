import java.util.Scanner;

public class AnagramChecker {

    public static boolean areAnagrams(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        int[] firstFrequency = new int[256];
        int[] secondFrequency = new int[256];

        for (int i = 0; i < first.length(); i++) {
            char firstCharacter = first.charAt(i);
            char secondCharacter = second.charAt(i);

            if (firstCharacter < 256) {
                firstFrequency[firstCharacter]++;
            }
            if (secondCharacter < 256) {
                secondFrequency[secondCharacter]++;
            }
        }

        for (int i = 0; i < firstFrequency.length; i++) {
            if (firstFrequency[i] != secondFrequency[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first text: ");
        String first = scanner.nextLine();
        System.out.print("Enter second text: ");
        String second = scanner.nextLine();

        System.out.println("Anagram: " + areAnagrams(first, second));
    }
}
