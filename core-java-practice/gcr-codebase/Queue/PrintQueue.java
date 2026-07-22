package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Scenario 2: Deque — Print Queue with Rush Job Support
 * Context: Office print server queue with support for regular and urgent print jobs.
 */
public class PrintQueue {
    private Deque<Integer> printQueue;

    public PrintQueue() {
        this.printQueue = new ArrayDeque<>();
    }

    public void submitJob(int jobId) {
        printQueue.addLast(jobId); // Normal job: joins the back of the line
    }

    public void submitUrgentJob(int jobId) {
        printQueue.addFirst(jobId); // Urgent job: jumps to the front
    }

    public int printNextJob() {
        if (printQueue.isEmpty()) throw new RuntimeException("No jobs in print queue");
        return printQueue.removeFirst(); // Printer takes from front
    }

    public boolean isEmpty() {
        return printQueue.isEmpty();
    }

    public static void main(String[] args) {
        PrintQueue queue = new PrintQueue();
        queue.submitJob(101); // Normal job
        queue.submitJob(102); // Normal job
        queue.submitUrgentJob(999); // Urgent job

        System.out.println("Printing next: " + queue.printNextJob()); // 999
        System.out.println("Printing next: " + queue.printNextJob()); // 101
        System.out.println("Printing next: " + queue.printNextJob()); // 102
    }
}
