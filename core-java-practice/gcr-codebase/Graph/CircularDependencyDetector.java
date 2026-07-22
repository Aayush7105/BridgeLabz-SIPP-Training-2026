package Graph;

import java.util.*;

/**
 * Scenario 6: Directed Cycle Detection — Catching Circular Dependencies in a Build System
 * Context: Build system dependency graph checking for circular dependencies using 3-color DFS state representation.
 */
public class CircularDependencyDetector {

    // States: 0 = WHITE (unvisited), 1 = GRAY (currently visiting in active recursion stack), 2 = BLACK (fully processed)
    public static boolean hasCircularDependency(Map<Integer, List<Integer>> tasks, int n) {
        int[] state = new int[n];
        for (int v = 0; v < n; v++) {
            if (state[v] == 0) {
                if (dfsCycleCheck(tasks, v, state)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsCycleCheck(Map<Integer, List<Integer>> tasks, int node, int[] state) {
        state[node] = 1; // Mark GRAY (in active recursion stack)

        for (int dep : tasks.getOrDefault(node, Collections.emptyList())) {
            if (state[dep] == 1) {
                return true; // Cycle found: back-edge to a node currently in active stack!
            }
            if (state[dep] == 0 && dfsCycleCheck(tasks, dep, state)) {
                return true;
            }
        }

        state[node] = 2; // Mark BLACK (completely processed)
        return false;
    }

    public static void main(String[] args) {
        // Cyclic graph: 0 -> 1 -> 2 -> 0
        Map<Integer, List<Integer>> cyclicTasks = new HashMap<>();
        cyclicTasks.put(0, Arrays.asList(1));
        cyclicTasks.put(1, Arrays.asList(2));
        cyclicTasks.put(2, Arrays.asList(0));

        System.out.println("Cyclic dependencies detected: " + hasCircularDependency(cyclicTasks, 3)); // true

        // Acyclic graph (Diamond shape): 0 -> 1, 0 -> 2, 1 -> 3, 2 -> 3
        Map<Integer, List<Integer>> acyclicTasks = new HashMap<>();
        acyclicTasks.put(0, Arrays.asList(1, 2));
        acyclicTasks.put(1, Arrays.asList(3));
        acyclicTasks.put(2, Arrays.asList(3));

        System.out.println("Acyclic dependencies detected: " + hasCircularDependency(acyclicTasks, 4)); // false
    }
}
