package Collections.Tree;

public class FolderTreeDeleter {
    static class Node {
        String name;
        Node left, right;

        Node(String name) {
            this.name = name;
        }
    }

    public static void deleteNode(Node node) {
        System.out.println("Deleted folder: " + node.name);
    }

    public static void deleteFolderTree(Node node) {
        if (node == null) return;
        deleteFolderTree(node.left);
        deleteFolderTree(node.right);
        deleteNode(node);
    }

    public static void main(String[] args) {
        Node root = new Node("root");
        root.left = new Node("documents");
        root.right = new Node("photos");
        root.left.left = new Node("work");

        deleteFolderTree(root);
    }
}
