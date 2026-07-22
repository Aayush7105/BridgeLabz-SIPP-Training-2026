package Recursion;

import java.util.ArrayList;
import java.util.List;

public class OnCallRotationScheduler {

    public static List<List<String>> generateSchedules(String[] engineers) {
        List<List<String>> result = new ArrayList<>();
        boolean[] used = new boolean[engineers.length];
        backtrack(engineers, used, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String[] engineers, boolean[] used, List<String> path, List<List<String>> result) {
        if (path.size() == engineers.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < engineers.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(engineers[i]);
            backtrack(engineers, used, path, result);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        String[] engineers = {"Alice", "Bob", "Charlie"};
        List<List<String>> schedules = generateSchedules(engineers);
        System.out.println("Total rotations: " + schedules.size());
        for (List<String> rotation : schedules) {
            System.out.println(rotation);
        }
    }
}
