package Collections.Heap;

import java.util.PriorityQueue;

public class ERTriageQueue {
    static class Patient {
        String name;
        int severity;

        Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }
    }

    private PriorityQueue<Patient> triageQueue = new PriorityQueue<>((a, b) -> b.severity - a.severity);

    public void addPatient(Patient p) {
        triageQueue.offer(p);
    }

    public Patient treatNext() {
        return triageQueue.poll();
    }

    public static void main(String[] args) {
        ERTriageQueue queue = new ERTriageQueue();
        queue.addPatient(new Patient("John", 3));
        queue.addPatient(new Patient("Alice", 9));
        queue.addPatient(new Patient("Bob", 5));

        System.out.println(queue.treatNext().name);
        System.out.println(queue.treatNext().name);
    }
}
