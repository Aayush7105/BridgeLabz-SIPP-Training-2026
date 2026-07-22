package Collections.BST;

public class EmployeeIDDirectoryInserter {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node insert(Node node, int id) {
        if (node == null) {
            return new Node(id);
        }
        if (id < node.val) {
            node.left = insert(node.left, id);
        } else if (id > node.val) {
            node.right = insert(node.right, id);
        }
        return node;
    }

    public static void printInorder(Node node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 105);
        root = insert(root, 102);
        root = insert(root, 108);
        root = insert(root, 101);

        printInorder(root);
        System.out.println();
    }
}
