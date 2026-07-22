package Recursion;

import java.util.ArrayList;
import java.util.List;

public class FeatureFlagCombinations {

    public static List<List<String>> generateFlagCombinations(String[] flags) {
        List<List<String>> result = new ArrayList<>();
        backtrack(flags, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String[] flags, int index, List<String> current, List<List<String>> result) {
        if (index == flags.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(flags[index]);
        backtrack(flags, index + 1, current, result);
        current.remove(current.size() - 1);
        backtrack(flags, index + 1, current, result);
    }

    public static void main(String[] args) {
        String[] flags = {"dark_mode", "new_checkout", "beta_search"};
        List<List<String>> combinations = generateFlagCombinations(flags);
        System.out.println("Total combinations: " + combinations.size());
        for (List<String> combo : combinations) {
            System.out.println(combo);
        }
    }
}
