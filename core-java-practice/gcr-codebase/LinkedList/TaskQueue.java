package LinkedList;

class TaskQueue {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Scenario 2: Deletion — Removing a Completed Task from a Task Queue
    public static Node removeTask(Node head, int taskId) {
        if (head == null) return null;
        if (head.val == taskId) return head.next; // removing the first task
        
        Node prev = head;
        Node curr = head.next;
        while (curr != null && curr.val != taskId) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            prev.next = curr.next;
        }
        return head;
    }

    public static void printQueue(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print("Task " + curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node task1 = new Node(1);
        Node task2 = new Node(2);
        Node task3 = new Node(3);
        Node task4 = new Node(4);
        task1.next = task2;
        task2.next = task3;
        task3.next = task4;

        System.out.print("Initial Task Queue: ");
        printQueue(task1);

        System.out.println("Removing Task 3...");
        task1 = removeTask(task1, 3);
        System.out.print("Queue after removing Task 3: ");
        printQueue(task1);

        System.out.println("Removing head Task 1...");
        task1 = removeTask(task1, 1);
        System.out.print("Queue after removing Task 1: ");
        printQueue(task1);
    }
}
