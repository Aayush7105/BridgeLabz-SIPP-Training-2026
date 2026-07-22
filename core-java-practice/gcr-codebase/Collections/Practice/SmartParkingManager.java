import java.util.ArrayList;
import java.util.Scanner;

public class SmartParkingManager {
    private ArrayList<String> parkedVehicles = new ArrayList<>();

    public void enter(String regNo) {
        if (parkedVehicles.contains(regNo)) {
            System.out.println("Vehicle is already parked.");
            return;
        }
        parkedVehicles.add(regNo);
        System.out.println("Vehicle added successfully.");
    }

    public void exit(String regNo) {
        if (parkedVehicles.remove(regNo)) {
            System.out.println("Vehicle removed successfully.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    public void search(String regNo) {
        if (parkedVehicles.contains(regNo)) {
            System.out.println("Vehicle is currently parked.");
        } else {
            System.out.println("Vehicle is not parked.");
        }
    }

    public void display() {
        System.out.println("Parked Vehicles: " + parkedVehicles);
        System.out.println("Total Occupied Slots: " + parkedVehicles.size());
    }

    public static void main(String[] args) {
        SmartParkingManager manager = new SmartParkingManager();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Vehicle Entry\n2. Vehicle Exit\n3. Search Vehicle\n4. Display Parked Vehicles\n5. Exit");
            System.out.print("Choose option: ");
            if (!sc.hasNextInt()) break;
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 5) break;
            switch (choice) {
                case 1:
                    System.out.print("Enter registration number: ");
                    String entryReg = sc.nextLine();
                    manager.enter(entryReg);
                    break;
                case 2:
                    System.out.print("Enter registration number: ");
                    String exitReg = sc.nextLine();
                    manager.exit(exitReg);
                    break;
                case 3:
                    System.out.print("Enter registration number: ");
                    String searchReg = sc.nextLine();
                    manager.search(searchReg);
                    break;
                case 4:
                    manager.display();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}
