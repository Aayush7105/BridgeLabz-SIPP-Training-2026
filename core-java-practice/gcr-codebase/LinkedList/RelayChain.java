package LinkedList;

class RelayChain {
    static class Node {
        int serverId;
        Node next;

        Node(int serverId) {
            this.serverId = serverId;
            this.next = null;
        }
    }

    // Scenario 4: Find the Middle — Picking a Midpoint Server in a Relay Chain
    public static Node findMiddleServer(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void printChain(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print("Server(" + curr.serverId + ")" + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node s1 = new Node(101);
        Node s2 = new Node(102);
        Node s3 = new Node(103);
        Node s4 = new Node(104);
        Node s5 = new Node(105);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;

        System.out.print("Relay Chain: ");
        printChain(s1);

        Node mid = findMiddleServer(s1);
        System.out.println("Midpoint Server: Server(" + (mid != null ? mid.serverId : "null") + ")");
    }
}
