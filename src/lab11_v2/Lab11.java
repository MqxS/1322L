package lab11_v2;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab11 {
    private static ArrayList<BoxOfBooks> makeBoxOfBooks() {
        final ArrayList<BoxOfBooks> boxes = new ArrayList<>();

        final BoxOfBooks programmingBooks = new BoxOfBooks("Programming");
        programmingBooks.addBook("Databases made Simple");
        programmingBooks.addBook("Macros and Scripts");
        programmingBooks.addBook("Programming Basics");
        boxes.add(programmingBooks);

        final BoxOfBooks chemistryBooks = new BoxOfBooks("Chemistry");
        chemistryBooks.addBook("Organic Chemistry");
        chemistryBooks.addBook("Inorganic Chemistry");
        chemistryBooks.addBook("The Periodic Table of Elements");
        boxes.add(chemistryBooks);

        final BoxOfBooks mathBooks = new BoxOfBooks("Mathematics");
        mathBooks.addBook("Linear Algebra");
        mathBooks.addBook("Calculus I and II");
        mathBooks.addBook("Pre-Calculus");
        boxes.add(mathBooks);

        return boxes;
    }

    public static void main(String[] args) {
        final ArrayList<BoxOfBooks> boxes = makeBoxOfBooks();
        final QueueOfStudents queueOfStudents = new QueueOfStudents();
        final Scanner scanner = new Scanner(System.in);

        System.out.println("[Book Delivery Scheduler]");
        System.out.println();
        while (true) {
            System.out.println("1. Add student");
            System.out.println("2. Create box of books ");
            System.out.println("3. Deliver all boxes");
            System.out.print("Enter option: ");

            final int option = scanner.nextInt();
            scanner.nextLine();

            System.out.println();
            switch (option) {
                case 1 -> {
                    System.out.print("Enter name of student: ");
                    final String name = scanner.nextLine().trim();

                    for (int i = 0; i < boxes.size(); i++) {
                        final BoxOfBooks box = boxes.get(i);
                        System.out.printf("%d: %s%n", i, box.getBoxName());
                    }

                    System.out.print("Give them which box? ");
                    final int boxIndex = scanner.nextInt();
                    scanner.nextLine();

                    final Student student = new Student(name, boxes.get(boxIndex).copy());
                    queueOfStudents.registerForPickup(student);
                    System.out.println("Student added to queue.");
                }
                case 2 -> {
                    System.out.print("Enter box name: ");
                    final String boxName = scanner.nextLine().trim();
                    final BoxOfBooks boxOfBooks = new BoxOfBooks(boxName);

                    System.out.print("Enter name of book or '-done': ");
                    for (String bookName; !((bookName = scanner.nextLine().trim()).equals("-done"));) {
                        boxOfBooks.addBook(bookName);
                        System.out.println("Book added to box.");
                        System.out.print("Enter name of book or '-done': ");
                    }

                    boxes.add(boxOfBooks);
                    System.out.println("Box of Books registered for future use.");
                }
                case 3 -> {
                    System.out.println("Here are all the students and the contents of their boxes:");
                    for (Student student; (student = queueOfStudents.deliverBoxOfBooks()) != null;) {
                        System.out.println(student);
                    }
                    System.out.println("Shutting off...");
                    return;
                }
            }
            System.out.println();
        }
    }
}
