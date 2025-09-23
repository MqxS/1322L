package assignment2;

import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Shelf shelf = new Shelf();

        System.out.println("[Publication Database]");
        while (true) {
            System.out.println("1. Add publication");
            System.out.println("2. View all publications");
            System.out.println("3. Find by author");
            System.out.println("4. Find by keyword");
            System.out.println("5. Make publication available");
            System.out.println("6. Make publication unavailable");
            System.out.println("7. Remove publication");
            System.out.println("8. Exit");

            System.out.print("Enter option: ");
            final int option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println();
                    scanner.nextLine();
                    System.out.print("Enter title: ");
                    final String title = scanner.nextLine();
                    System.out.print("Enter name of author: ");
                    final String author = scanner.nextLine();
                    System.out.print("Enter year of publication: ");
                    final int year = scanner.nextInt();

                    final Publication publication = new Publication(title, author, year);
                    shelf.addPublication(publication);
                    System.out.println("Publication added");
                    System.out.println();
                }
                case 2 -> {
                    System.out.println();
                    System.out.println(shelf);
                    System.out.println();
                }
                case 3 -> {
                    System.out.println();
                    System.out.print("Enter name of author: ");
                    scanner.nextLine();
                    final String author = scanner.nextLine();
                    System.out.println();
                    System.out.println(shelf.listByAuthor(author));
                    System.out.println();
                }
                case 4 -> {
                    System.out.println();
                    System.out.print("Enter name keyword: ");
                    scanner.nextLine();
                    final String keyword = scanner.nextLine();
                    System.out.println();
                    System.out.println(shelf.listByKeyword(keyword));
                    System.out.println();
                }
                case 5 -> {
                    System.out.println();
                    System.out.print("Enter publication id: ");
                    final int id = scanner.nextInt();
                    final Publication publication = shelf.getPublication(id);

                    if (publication != null) {
                        if (!publication.isAvailable()) {
                            publication.setAvailable(true);
                            System.out.printf("Publication #%d has been made available.%n", id);
                        } else {
                            System.out.printf("ERROR: Publication #%d is already available.%n", id);
                        }
                    } else {
                        System.out.println("No publication with that id");
                    }
                    System.out.println();
                }
                case 6 -> {
                    System.out.println();
                    System.out.print("Enter publication id: ");
                    final int id = scanner.nextInt();
                    final Publication publication = shelf.getPublication(id);

                    if (publication != null) {
                        if (publication.isAvailable()) {
                            publication.setAvailable(false);
                            System.out.printf("Publication #%d has been made unavailable.%n", id);
                        } else {
                            System.out.printf("ERROR: Publication #%d is already unavailable.%n", id);
                        }
                    } else {
                        System.out.println("No publication with that id");
                    }
                    System.out.println();
                }
                case 7 -> {
                    System.out.println();
                    System.out.print("Enter publication id: ");
                    final int id = scanner.nextInt();
                    final Publication publication = shelf.getPublication(id);

                    if (publication != null) {
                        shelf.removePublication(publication);
                        System.out.printf("Publication #%d has been removed.%n", id);
                    } else {
                        System.out.println("No publication with that id");
                    }
                    System.out.println();
                }
                case 8 -> {
                    System.out.println();
                    System.out.println("Shutting off...");
                    return;
                }
            }
        }
    }
}
