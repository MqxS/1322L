package assignment1;

import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int availableSeats = 50;
        double ticketPrice = 30.0;
        double popcornPrice = 25.0;
        double sodaPrice = 10.0;
        double candyPrice = 15.0;
        double theaterBalance = 0.0;

        System.out.println("[Movie Theater Manager]");
        while(true) {
            System.out.println("1. Sell tickets");
            System.out.println("2. End movie session");
            System.out.println("3. Change ticket price");
            System.out.println("4. Sell confection");
            System.out.println("5. Change price of confection");
            System.out.println("6. View Balance");
            System.out.println("7. View prices");
            System.out.println("8. Quit");

            System.out.print("Enter option: ");
            final int option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println();
                    System.out.print("Sell How many tickets? ");
                    final int ticketsToSell = scanner.nextInt();
                    if (ticketsToSell > availableSeats) {
                        System.out.printf(
                                "Unable to sell %d tickets: Only %d seats available.%n",
                                ticketsToSell,
                                availableSeats
                        );
                    } else {
                        availableSeats -= ticketsToSell;
                        final double saleAmount = ticketsToSell * ticketPrice;
                        theaterBalance += saleAmount;
                        System.out.printf(
                                "Sold %d tickets at $%.2f for a total of $%.2f%n",
                                ticketsToSell,
                                ticketPrice,
                                saleAmount
                        );
                    }
                    System.out.println();
                }
                case 2 -> {
                    availableSeats = 50;
                    System.out.println();
                    System.out.println("All seats have been vacated and cleaned.");
                    System.out.println();
                }
                case 3 -> {
                    System.out.println();
                    System.out.print("Enter new ticket price: $");
                    ticketPrice = scanner.nextDouble();
                    System.out.println("Ticket price updated.");
                    System.out.println();
                }
                case 4 -> {
                    System.out.println();
                    System.out.println("Sell what confection?");
                    System.out.printf("Popcorn: $%.2f%n", popcornPrice);
                    System.out.printf("Soda: $%.2f%n", sodaPrice);
                    System.out.printf("Candy: $%.2f%n", candyPrice);

                    final int confectionOption = scanner.nextInt();
                    final String confectionName;
                    final double price;
                    switch (confectionOption) {
                        case 1 -> {
                            confectionName = "Popcorn";
                            price = popcornPrice;
                        }
                        case 2 -> {
                            confectionName = "Soda";
                            price = sodaPrice;
                        }
                        case 3 -> {
                            confectionName = "Candy";
                            price = candyPrice;
                        }
                        default -> {
                            confectionName = "";
                            price = 0.0;
                        }
                    }
                    theaterBalance += price;
                    System.out.printf(
                            "Sold %s for $%.2f%n",
                            confectionName.toUpperCase(),
                            price
                    );
                    System.out.println();
                }
                case 5 -> {
                    System.out.println();
                    System.out.println("Change price of which confection?");
                    System.out.printf("Popcorn: $%.2f%n", popcornPrice);
                    System.out.printf("Soda: $%.2f%n", sodaPrice);
                    System.out.printf("Candy: $%.2f%n", candyPrice);

                    final int confectionOption = scanner.nextInt();
                    switch (confectionOption) {
                        case 1 -> {
                            System.out.print("Enter new POPCORN price: $");
                            popcornPrice = scanner.nextDouble();
                            System.out.println("POPCORN price updated.");
                        }
                        case 2 -> {
                            System.out.print("Enter new SODA price: $");
                            sodaPrice = scanner.nextDouble();
                            System.out.println("SODA price updated.");
                        }
                        case 3 -> {
                            System.out.print("Enter new CANDY price: $");
                            candyPrice = scanner.nextDouble();
                            System.out.println("CANDY price updated.");
                        }
                    }
                    System.out.println();
                }
                case 6 -> {
                    System.out.println();
                    System.out.printf("Current balance is $%.2f%n", theaterBalance);
                    System.out.println();
                }
                case 7 -> {
                    System.out.println();
                    System.out.println("Current Prices:");
                    System.out.printf("Ticket: $%.2f%n", ticketPrice);
                    System.out.printf("Popcorn: $%.2f%n", popcornPrice);
                    System.out.printf("Soda: $%.2f%n", sodaPrice);
                    System.out.printf("Candy: $%.2f%n", candyPrice);
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
