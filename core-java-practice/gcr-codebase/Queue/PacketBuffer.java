package Queue;

/**
 * Scenario 1: Circular Queue — Fixed-Size Network Packet Buffer
 * Context: Fixed-capacity packet buffer reusing slots via modular arithmetic wraparound.
 */
public class PacketBuffer {
    private int[] data;
    private int front;
    private int count;

    public PacketBuffer(int capacity) {
        data = new int[capacity];
        front = 0;
        count = 0;
    }

    public boolean enqueue(int packetId) {
        if (count == data.length) return false; // Buffer full: reject
        data[(front + count) % data.length] = packetId;
        count++;
        return true;
    }

    public int dequeue() {
        if (count == 0) throw new RuntimeException("Buffer empty");
        int val = data[front];
        front = (front + 1) % data.length;
        count--;
        return val;
    }

    public boolean isFull() {
        return count == data.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
        PacketBuffer buffer = new PacketBuffer(3);
        System.out.println("Enqueue 101: " + buffer.enqueue(101)); // true
        System.out.println("Enqueue 102: " + buffer.enqueue(102)); // true
        System.out.println("Enqueue 103: " + buffer.enqueue(103)); // true
        System.out.println("Enqueue 104 (Full): " + buffer.enqueue(104)); // false

        System.out.println("Dequeued: " + buffer.dequeue()); // 101
        System.out.println("Enqueue 104 (After dequeue): " + buffer.enqueue(104)); // true
        System.out.println("Dequeued: " + buffer.dequeue()); // 102
        System.out.println("Dequeued: " + buffer.dequeue()); // 103
        System.out.println("Dequeued: " + buffer.dequeue()); // 104
    }
}
