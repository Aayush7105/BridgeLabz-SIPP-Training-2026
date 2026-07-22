package Graph;

import java.util.*;

/**
 * Scenario 5: Undirected Cycle Detection — Flagging Redundant Loops in Circuit Wiring
 * Context: Circuit design validation tool to detect cycles (short-circuit risks) in undirected wiring graphs.
 */
public class CircuitWiringLoopDetector {

    public static boolean hasWiringLoop(Map<Integer, List<Integer>> circuit, int n) {
        Set<Integer> visited = new HashSet<>();
        for (int v = 0; v < n; v++) {
            if (!visited.contains(v)) {
                if (dfsCycleCheck(circuit, v, -1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsCycleCheck(Map<Integer, List<Integer>> circuit, int node, int parent, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : circuit.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                if (dfsCycleCheck(circuit, neighbor, node, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // Visited neighbor that is not parent -> Cycle detected!
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Graph with cycle: 0-1-2-0
        Map<Integer, List<Integer>> circuit1 = new HashMap<>();
        circuit1.put(0, Arrays.asList(1, 2));
        circuit1.put(1, Arrays.asList(0, 2));
        circuit1.put(2, Arrays.asList(0, 1));

        System.out.println("Circuit 1 has loop: " + hasWiringLoop(circuit1, 3)); // true

        // Tree structure without cycle: 0-1-2
        Map<Integer, List<Integer>> circuit2 = new HashMap<>();
        circuit2.put(0, Arrays.asList(1));
        circuit2.put(1, Arrays.asList(0, 2));
        circuit2.put(2, Arrays.asList(1));

        System.out.println("Circuit 2 has loop: " + hasWiringLoop(circuit2, 3)); // false
    }
}
