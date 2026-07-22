package Collections.BST;

public class PricingIndexValidator {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(Node root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(Node node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
        Node validRoot = new Node(10);
        validRoot.left = new Node(5);
        validRoot.right = new Node(15);

        Node invalidRoot = new Node(10);
        invalidRoot.left = new Node(5);
        invalidRoot.right = new Node(15);
        invalidRoot.right.left = new Node(6);

        System.out.println(isValidBST(validRoot));
        System.out.println(isValidBST(invalidRoot));
    }
}
