package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendingMachineChangeMaker {

    public static List<List<Integer>> makeChange(int[] coins, int target) {
        Arrays.sort(coins);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(coins, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] coins, int target, int start, int sum, List<Integer> path, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < coins.length; i++) {
            if (sum + coins[i] > target) break;
            path.add(coins[i]);
            backtrack(coins, target, i, sum + coins[i], path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int target = 5;
        List<List<Integer>> result = makeChange(coins, target);
        System.out.println("Ways to make change for " + target + ":");
        for (List<Integer> combo : result) {
            System.out.println(combo);
        }
    }
}
