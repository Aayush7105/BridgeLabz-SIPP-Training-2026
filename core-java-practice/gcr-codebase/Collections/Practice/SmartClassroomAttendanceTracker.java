import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SmartClassroomAttendanceTracker {
    private HashMap<String, ArrayList<String>> attendance = new HashMap<>();

    public void markAttendance(String subject, String student) {
        attendance.putIfAbsent(subject, new ArrayList<>());
        ArrayList<String> students = attendance.get(subject);
        if (students.contains(student)) {
            System.out.println("Attendance already marked for: " + student + " in " + subject);
            return;
        }
        students.add(student);
        System.out.println("Attendance marked for: " + student + " in " + subject);
    }

    public void display() {
        if (attendance.isEmpty()) {
            System.out.println("No attendance records found.");
            return;
        }
        for (Map.Entry<String, ArrayList<String>> entry : attendance.entrySet()) {
            System.out.println("Subject: " + entry.getKey());
            System.out.println("Students Present: " + entry.getValue());
            System.out.println("Total Count: " + entry.getValue().size());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SmartClassroomAttendanceTracker tracker = new SmartClassroomAttendanceTracker();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Mark Attendance\n2. Display Attendance\n3. Exit");
            System.out.print("Choose option: ");
            if (!sc.hasNextInt()) break;
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 3) break;
            switch (choice) {
                case 1:
                    System.out.print("Enter subject name: ");
                    String subject = sc.nextLine();
                    System.out.print("Enter student name: ");
                    String student = sc.nextLine();
                    tracker.markAttendance(subject, student);
                    break;
                case 2:
                    tracker.display();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}
