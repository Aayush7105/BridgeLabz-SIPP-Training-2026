
class PlaylistQueue {
    static class Node {
        int trackId;
        Node next;

        Node(int trackId) {
            this.trackId = trackId;
            this.next = null;
        }
    }

    public static void insertAfter(Node current, int trackId) {
        if (current == null) return;
        Node newNode = new Node(trackId);
        newNode.next = current.next; 
        current.next = newNode;      
    }

    public static void printQueue(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.trackId + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node track1 = new Node(101);
        Node track2 = new Node(102);
        Node track3 = new Node(103);
        track1.next = track2;
        track2.next = track3;

        System.out.print("Original Queue: ");
        printQueue(track1);

        System.out.println("Inserting Track 999 after Track 101...");
        insertAfter(track1, 999);

        System.out.print("Updated Queue: ");
        printQueue(track1);
    }
}
