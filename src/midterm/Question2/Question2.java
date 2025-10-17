package midterm.Question2;

import java.util.ArrayList;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final ArrayList<Artist> artists = new ArrayList<>();

        System.out.println("[Artist Tracker]");
        while (true) {
            System.out.println("1. Add artist");
            System.out.println("2. View following");
            System.out.println("3. View subscribed");
            System.out.println("4. Quit");

            System.out.print("Enter option: ");
            final int option = scanner.nextInt();
            scanner.nextLine();

            System.out.println();
            switch (option) {
                case 1 -> {
                    System.out.print("Enter artist name: ");
                    final String name = scanner.nextLine();
                    System.out.print("Enter monthly amount: $");
                    final double contribution = scanner.nextDouble();
                    scanner.nextLine();

                    final Artist artist = new Artist(name, contribution);
                    artists.add(artist);
                    System.out.println("Artist Added to list.");
                }
                case 2 -> {
                    System.out.println("Here are the artists you are following:");
                    for (final Artist artist : artists) {
                        if (artist.getMonthlyFee() == 0) {
                            System.out.println(artist);
                        }
                    }
                }
                case 3 -> {
                    double totalContribution = 0;
                    System.out.println("Here are the artists you are subscribed to:");
                    for (final Artist artist : artists) {
                        if (artist.getMonthlyFee() > 0) {
                            System.out.println(artist);
                            totalContribution += artist.getMonthlyFee();
                        }
                    }
                    System.out.printf("Your total expense on artists is $%.2f%n", totalContribution);
                }
                case 4 -> {
                    System.out.println("Shutting off...");
                    return;
                }
            }
            System.out.println();
        }
    }
}
