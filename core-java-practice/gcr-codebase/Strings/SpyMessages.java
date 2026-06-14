
import java.util.Arrays;
import java.util.Scanner;

public class SpyMessages {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        String message2 = sc.nextLine();
        System.out.println(isPal(message));
        System.out.println(countVowel(message));

    }

    public static boolean isPal(String s) {
        int st = 0;
        int e = s.length() - 1;
        while (st < e) {
            if (s.charAt(st) != s.charAt(e)) {
                return false;
            }
        }
        return true;
    }

    public static int countVowel(String s) {
        int count = 0;
        String vowels = "AEIOUaeiou";
        for (char i : s.toCharArray()) {
            if (vowels.indexOf(i) == -1) {
                continue;
            } else {
                count++;
            }
        }
        return count;
    }

    public static int countConsonants(String s) {
        int count = 0;
        String vowels = "AEIOUaeiou";
        for (char i : s.toCharArray()) {
            if (vowels.indexOf(i) == -1) {
                count++;
            }
        }
        return count;
    }

    public static boolean Anagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}
