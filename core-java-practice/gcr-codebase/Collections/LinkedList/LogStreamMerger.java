package LinkedList;

class LogStreamMerger {
    static class Node {
        int timestamp;
        Node next;

        Node(int timestamp) {
            this.timestamp = timestamp;
            this.next = null;
        }
    }

    // Scenario 6: Merge — Combining Two Sorted Log Streams
    public static Node mergeLogStreams(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;
        while (a != null && b != null) {
            if (a.timestamp <= b.timestamp) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
        return dummy.next;
    }

    public static void printStream(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.timestamp + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Stream A: 100 -> 105 -> 110
        Node a1 = new Node(100);
        Node a2 = new Node(105);
        Node a3 = new Node(110);
        a1.next = a2;
        a2.next = a3;

        // Stream B: 102 -> 107 -> 112
        Node b1 = new Node(102);
        Node b2 = new Node(107);
        Node b3 = new Node(112);
        b1.next = b2;
        b2.next = b3;

        System.out.print("Stream A: ");
        printStream(a1);
        System.out.print("Stream B: ");
        printStream(b1);

        Node mergedHead = mergeLogStreams(a1, b1);

        System.out.print("Merged Log Stream: ");
        printStream(mergedHead);
    }
}
