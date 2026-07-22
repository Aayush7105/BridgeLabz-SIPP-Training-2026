package Graph;

import java.util.*;

/**
 * Scenario 3: DFS All Paths — Enumerating Every Delivery Route Between a Warehouse and a Store
 * Context: Logistics routing tool to find every distinct simple path between warehouse and store.
 */
public class AllDeliveryRoutes {

    public static List<List<Integer>> findAllRoutes(Map<Integer, List<Integer>> roads, int start, int target) {
        List<List<Integer>> allRoutes = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        allRoutesDFS(roads, start, target, path, visited, allRoutes);
        return allRoutes;
    }

    private static void allRoutesDFS(Map<Integer, List<Integer>> roads, int current, int target,
                                     List<Integer> path, Set<Integer> visited, List<List<Integer>> allRoutes) {
        path.add(current);
        visited.add(current);

        if (current == target) {
            allRoutes.add(new ArrayList<>(path));
        } else {
            for (int next : roads.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(next)) {
                    allRoutesDFS(roads, next, target, path, visited, allRoutes);
                }
            }
        }

        path.remove(path.size() - 1); // backtrack
        visited.remove(current);       // backtrack
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> roads = new HashMap<>();
        roads.put(1, Arrays.asList(2, 3));
        roads.put(2, Arrays.asList(1, 3, 4));
        roads.put(3, Arrays.asList(1, 2, 4));
        roads.put(4, Arrays.asList(2, 3));

        List<List<Integer>> routes = findAllRoutes(roads, 1, 4);
        System.out.println("All distinct delivery routes from 1 to 4:");
        for (List<Integer> route : routes) {
            System.out.println(route);
        }
    }
}
