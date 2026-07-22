package Queue;

import java.util.PriorityQueue;

/**
 * Scenario 3: Priority Queue (Min-Heap) — Hospital ER Triage
 * Context: Emergency room triage where lower priority number = higher urgency.
 */
public class HospitalERTriage {

    public static class Patient {
        public int priority;
        public String name;

        public Patient(int priority, String name) {
            this.priority = priority;
            this.name = name;
        }

        @Override
        public String toString() {
            return name + " (Priority " + priority + ")";
        }
    }

    private PriorityQueue<Patient> triageQueue;

    public HospitalERTriage() {
        // Min-heap ordering by priority number (1 = most critical)
        this.triageQueue = new PriorityQueue<>((a, b) -> Integer.compare(a.priority, b.priority));
    }

    public void admitPatient(Patient p) {
        triageQueue.offer(p);
    }

    public Patient callNextPatient() {
        if (triageQueue.isEmpty()) return null;
        return triageQueue.poll();
    }

    public static void main(String[] args) {
        HospitalERTriage er = new HospitalERTriage();
        er.admitPatient(new Patient(3, "John"));
        er.admitPatient(new Patient(1, "Alice")); // Critical
        er.admitPatient(new Patient(2, "Bob"));

        System.out.println("Calling patient: " + er.callNextPatient()); // Alice (Priority 1)
        System.out.println("Calling patient: " + er.callNextPatient()); // Bob (Priority 2)
        System.out.println("Calling patient: " + er.callNextPatient()); // John (Priority 3)
    }
}
