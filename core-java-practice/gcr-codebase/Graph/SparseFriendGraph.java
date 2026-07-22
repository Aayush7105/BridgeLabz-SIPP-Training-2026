package Graph;

import java.util.*;

/**
 * Scenario 1: Representation — Choosing a Structure for a Sparse Friend Graph
 * Context: Social platform with millions of users, sparse friendship graph.
 */
public class SparseFriendGraph {
    private Map<Integer, Set<Integer>> friendGraph;

    public SparseFriendGraph() {
        this.friendGraph = new HashMap<>();
    }

    public void addFriendship(int u, int v) {
        friendGraph.computeIfAbsent(u, k -> new HashSet<>()).add(v);
        friendGraph.computeIfAbsent(v, k -> new HashSet<>()).add(u);
    }

    public boolean isFriend(int u, int v) {
        return friendGraph.getOrDefault(u, Collections.emptySet()).contains(v);
    }

    public static void main(String[] args) {
        SparseFriendGraph graph = new SparseFriendGraph();
        graph.addFriendship(1, 2);
        graph.addFriendship(1, 3);
        graph.addFriendship(2, 4);

        System.out.println("Is 1 friend of 2? " + graph.isFriend(1, 2)); // true
        System.out.println("Is 1 friend of 4? " + graph.isFriend(1, 4)); // false
        System.out.println("Is 3 friend of 1? " + graph.isFriend(3, 1)); // true
    }
}
