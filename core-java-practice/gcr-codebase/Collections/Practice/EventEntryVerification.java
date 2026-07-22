import java.util.HashSet;
import java.util.Scanner;

public class EventEntryVerification {
    private HashSet<String> registeredEmails = new HashSet<>();

    public void register(String email) {
        if (registeredEmails.contains(email)) {
            System.out.println("Duplicate registration rejected for: " + email);
            return;
        }
        registeredEmails.add(email);
        System.out.println("Registration successful for: " + email);
    }

    public void display() {
        System.out.println("Registered Participants: " + registeredEmails);
        System.out.println("Total Attendees: " + registeredEmails.size());
    }

    public static void main(String[] args) {
        EventEntryVerification system = new EventEntryVerification();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Register Participant\n2. Display Registered Participants\n3. Exit");
            System.out.print("Choose option: ");
            if (!sc.hasNextInt()) break;
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 3) break;
            switch (choice) {
                case 1:
                    System.out.print("Enter email ID: ");
                    String email = sc.nextLine();
                    system.register(email);
                    break;
                case 2:
                    system.display();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}
