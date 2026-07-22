package Collections.BST;

import java.util.ArrayDeque;
import java.util.Deque;

public class LatencyPercentileFinder {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static int kthSmallest(Node root, int k) {
        Deque<Node> stack = new ArrayDeque<>();
        Node current = root;
        int count = 0;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            count++;
            if (count == k) return current.val;
            current = current.right;
        }
        throw new IllegalArgumentException("k out of range");
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.left.left = new Node(1);

        System.out.println(kthSmallest(root, 3));
    }
}
