import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collections;
import java.util.Scanner;

class Contact implements Comparable<Contact> {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public int compareTo(Contact other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class AddressBook {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private HashMap<String, Contact> nameLookup = new HashMap<>();
    private HashSet<String> phoneNumbers = new HashSet<>();

    public void addContact(String name, String phone, String email) {
        if (phoneNumbers.contains(phone)) {
            System.out.println("Duplicate phone number. Contact not added.");
            return;
        }
        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);
        nameLookup.put(name.toLowerCase(), contact);
        phoneNumbers.add(phone);
        System.out.println("Contact added successfully.");
    }

    public void searchContact(String name) {
        Contact contact = nameLookup.get(name.toLowerCase());
        if (contact != null) {
            System.out.println(contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void deleteContact(String name) {
        Contact contact = nameLookup.remove(name.toLowerCase());
        if (contact != null) {
            contacts.remove(contact);
            phoneNumbers.remove(contact.phone);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void displaySorted() {
        if (contacts.isEmpty()) {
            System.out.println("Address book is empty.");
            return;
        }
        Collections.sort(contacts);
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public static void main(String[] args) {
        AddressBook book = new AddressBook();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Contact\n2. Search Contact\n3. Delete Contact\n4. Display Sorted\n5. Exit");
            System.out.print("Choose option: ");
            if (!sc.hasNextInt()) break;
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 5) break;
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    book.addContact(name, phone, email);
                    break;
                case 2:
                    System.out.print("Enter name to search: ");
                    String sName = sc.nextLine();
                    book.searchContact(sName);
                    break;
                case 3:
                    System.out.print("Enter name to delete: ");
                    String dName = sc.nextLine();
                    book.deleteContact(dName);
                    break;
                case 4:
                    book.displaySorted();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}
