package Graph;

import java.util.*;

/**
 * Scenario 4: Connectivity — Auditing a Company Network for Isolated Segments
 * Context: Audit company network to count connected components and check full connectivity.
 */
public class NetworkConnectivity {

    public static int countNetworkSegments(Map<Integer, List<Integer>> network, int n) {
        Set<Integer> visited = new HashSet<>();
        int segments = 0;

        for (int server = 0; server < n; server++) {
            if (!visited.contains(server)) {
                segments++;
                dfsMark(network, server, visited);
            }
        }
        return segments;
    }

    private static void dfsMark(Map<Integer, List<Integer>> network, int node, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : network.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfsMark(network, neighbor, visited);
            }
        }
    }

    public static boolean isFullyConnected(Map<Integer, List<Integer>> network, int n) {
        return countNetworkSegments(network, n) == 1;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> network = new HashMap<>();
        // Component 1: servers 0, 1, 2
        network.put(0, Arrays.asList(1));
        network.put(1, Arrays.asList(0, 2));
        network.put(2, Arrays.asList(1));

        // Component 2: servers 3, 4
        network.put(3, Arrays.asList(4));
        network.put(4, Arrays.asList(3));

        int n = 5;
        int segments = countNetworkSegments(network, n);
        System.out.println("Total network segments: " + segments);
        System.out.println("Is network fully connected? " + isFullyConnected(network, n));
    }
}
