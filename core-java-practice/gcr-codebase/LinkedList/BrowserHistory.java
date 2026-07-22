package LinkedList;

class BrowserHistory {
    static class Node {
        String url;
        Node next;

        Node(String url) {
            this.url = url;
            this.next = null;
        }
    }

    // Scenario 3: Reverse — Reversing a Browser Back-Button History Stack
    public static Node reverseHistory(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printHistory(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print("[" + curr.url + "]" + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node page1 = new Node("google.com");
        Node page2 = new Node("github.com");
        Node page3 = new Node("stackoverflow.com");
        page1.next = page2;
        page2.next = page3;

        System.out.print("Original History (Most recent first): ");
        printHistory(page1);

        Node reversedHead = reverseHistory(page1);

        System.out.print("Reversed History (Oldest first): ");
        printHistory(reversedHead);
    }
}
