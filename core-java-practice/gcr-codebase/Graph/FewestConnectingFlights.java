package Graph;

import java.util.*;

/**
 * Scenario 2: BFS Shortest Path — Fewest Connecting Flights Between Two Cities
 * Context: Airline route map modeled as an unweighted graph, finding minimum flights.
 */
public class FewestConnectingFlights {

    public static List<Integer> fewestFlights(Map<Integer, List<Integer>> routes, int origin, int destination) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(origin);
        visited.add(origin);
        parent.put(origin, null);

        while (!queue.isEmpty()) {
            int city = queue.poll();
            if (city == destination) break;

            for (int next : routes.getOrDefault(city, Collections.emptyList())) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    parent.put(next, city);
                    queue.offer(next);
                }
            }
        }

        if (!visited.contains(destination)) return Collections.emptyList();

        LinkedList<Integer> path = new LinkedList<>();
        Integer node = destination;
        while (node != null) {
            path.addFirst(node);
            node = parent.get(node);
        }
        return path;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> routes = new HashMap<>();
        routes.put(1, Arrays.asList(2, 3));
        routes.put(2, Arrays.asList(1, 4));
        routes.put(3, Arrays.asList(1, 4, 5));
        routes.put(4, Arrays.asList(2, 3, 6));
        routes.put(5, Arrays.asList(3, 6));
        routes.put(6, Arrays.asList(4, 5));

        List<Integer> path = fewestFlights(routes, 1, 6);
        System.out.println("Shortest path from city 1 to 6: " + path);
    }
}
