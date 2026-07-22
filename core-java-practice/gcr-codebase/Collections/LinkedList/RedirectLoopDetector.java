package LinkedList;

class RedirectLoopDetector {
    static class Node {
        String url;
        Node next;

        Node(String url) {
            this.url = url;
            this.next = null;
        }
    }

    // Scenario 5: Cycle Detection — Catching an Infinite Redirect Loop
    public static boolean hasRedirectLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node urlA = new Node("https://example.com/a");
        Node urlB = new Node("https://example.com/b");
        Node urlC = new Node("https://example.com/c");

        // Linear chain: A -> B -> C
        urlA.next = urlB;
        urlB.next = urlC;
        System.out.println("Linear chain has redirect loop? " + hasRedirectLoop(urlA));

        // Create cycle: C -> B
        urlC.next = urlB;
        System.out.println("Cyclic chain has redirect loop? " + hasRedirectLoop(urlA));
    }
}
