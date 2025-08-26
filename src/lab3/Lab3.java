package lab3;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab3 {
    private static final ArrayList<String[]> phoneBook = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    private static void addContact() {
        System.out.print("Enter the contact's name: ");
        scanner.nextLine();
        final String name = scanner.nextLine();
        System.out.print("Enter the contact's phone number: ");
        final String phoneNumber = scanner.nextLine();
        final String[] contact = {name, phoneNumber};
        phoneBook.add(contact);
        System.out.println("Contact added.");
        System.out.println();
    }

    private static void removeContact() {
        System.out.print("Enter contact to remove: ");
        scanner.nextLine();
        final String nameToRemove = scanner.nextLine();
        for (final String[] contact : phoneBook) {
            if (contact[0].equals(nameToRemove)) {
                phoneBook.remove(contact);
                System.out.println("Contact deleted.");
                System.out.println();
                return;
            }
        }
        System.out.println("No contact with that name.");
        System.out.println();
    }

    private static void printContacts() {
        if (phoneBook.isEmpty()) {
            System.out.println("The phonebook is empty.");
            System.out.println();
            return;
        }

        System.out.println("Listing all contacts...");
        for (final String[] contact : phoneBook) {
            System.out.printf("Name: %s | Phone: %s%n", contact[0], contact[1]);
        }
        System.out.println("Done listing contacts.");
        System.out.println();
    }

    private static void searchContact() {
        System.out.print("Enter keyword to search: ");
        scanner.nextLine();
        final String keyword = scanner.nextLine();
        System.out.println("Searching all contacts for keyword...");
        boolean found = false;
        for (final String[] contact : phoneBook) {
            if (contact[0].contains(keyword)) {
                found = true;
                System.out.printf("Name: %s | Phone: %s%n", contact[0], contact[1]);
            }
        }
        if (found) {
            System.out.println("Done searching keyword.");
        } else {
            System.out.println("No contacts contained the keyword.");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("[Phonebook]");

        while (true) {
            System.out.println("1. Add contact");
            System.out.println("2. Remove contact");
            System.out.println("3. List contacts");
            System.out.println("4. Search contacts");
            System.out.println("5. Quit");

            System.out.print("Enter option: ");
            final int option = scanner.nextInt();

            switch (option) {
                case 1 -> addContact();
                case 2 -> removeContact();
                case 3 -> printContacts();
                case 4 -> searchContact();
                case 5 -> {
                    System.out.println("Shutting off...");
                    return;
                }
            }
        }
    }
}
