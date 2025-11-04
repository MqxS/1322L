package lab11_v1;

import java.util.Scanner;

public class Lab11 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final BlueRayCollection collection = new BlueRayCollection();

        System.out.println("[BlueRay Disk Collection]");
        while (true) {
            System.out.println("1. Add to collection");
            System.out.println("2. See collection");
            System.out.println("3. Quit");

            System.out.print("Enter option: ");
            final int option = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch(option) {
                case 1 -> {
                    System.out.print("Enter disk title: ");
                    final String title = scanner.nextLine();
                    System.out.print("Enter director name: ");
                    final String director = scanner.nextLine();
                    System.out.print("Enter year of release: ");
                    final String yearString = scanner.nextLine();

                    final int year;
                    try {
                        year = Integer.parseInt(yearString);
                    } catch (final NumberFormatException e) {
                        System.out.println("Error: Year of release must be a whole number!");
                        System.out.println();
                        continue;
                    }

                    System.out.print("Enter price of disk: $");
                    final String costString = scanner.nextLine();

                    final double cost;
                    try {
                        cost = Double.parseDouble(costString);
                    } catch (final NumberFormatException e) {
                        System.out.println("Error: Price must be a number!");
                        System.out.println();
                        continue;
                    }

                    collection.addDisk(title, director, year, cost);
                    System.out.println("BlueRay Disk added to collection.");
                    System.out.println();
                }
                case 2 -> {
                    System.out.println("Here's your current collection: ");
                    System.out.print(collection.showAll());
                    System.out.println();
                }
                case 3 -> {
                    System.out.println("Shutting off...");
                    return;
                }
            }
        }
    }
}
