package Collections.Hashing;

import java.util.HashSet;
import java.util.Set;

public class DuplicateSessionTokenDetector {
    public static boolean hasDuplicateToken(String[] tokens) {
        Set<String> seen = new HashSet<>();
        for (String token : tokens) {
            if (!seen.add(token)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] tokens1 = {"tok_abc", "tok_xyz", "tok_123", "tok_abc"};
        String[] tokens2 = {"tok_1", "tok_2", "tok_3"};

        System.out.println(hasDuplicateToken(tokens1));
        System.out.println(hasDuplicateToken(tokens2));
    }
}
