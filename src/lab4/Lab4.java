package lab4;

import java.util.Scanner;

public class Lab4 {
    private static class Prize {
        private final String name;
        private final int tickets;

        public Prize(final String name, final int tickets) {
            this.name = name;
            this.tickets = tickets;
        }

        public String getName() {
            return name;
        }

        public int tickets(final boolean holiday) {
            return holiday ? tickets / 2 : tickets;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);
    private static final Prize[] prizes = {
        new Prize("T-shirt", 150),
        new Prize("Sun hat", 350),
        new Prize("Sneakers", 600)
    };

    private static void addTickets(final ParkWallet wallet) {
        System.out.println();
        System.out.print("Add how many tickets? ");
        final int tickets = scanner.nextInt();
        wallet.addTickets(tickets);
        System.out.println();
    }

    private static void setTickets(final ParkWallet wallet) {
        System.out.println();
        System.out.print("Set ticket balance to: ");
        final int tickets = scanner.nextInt();
        wallet.setTickets(tickets);
        System.out.println();
    }

    private static void buyPrize(final ParkWallet wallet) {
        System.out.println();
        for (int i = 0; i < prizes.length; i++) {
            final Prize prize = prizes[i];
            System.out.printf("%d. %s (%d tickets)%n", i+1, prize.getName(), prize.tickets(ParkWallet.getHoliday()));
        }

        System.out.print("Buy which prize? ");
        final int option = scanner.nextInt();
        final Prize selectedPrize = prizes[option - 1];
        final boolean success = wallet.removeTickets(selectedPrize.tickets(ParkWallet.getHoliday()));
        if (success) {
            System.out.printf(
                    "Bought a %s for %d tickets%n",
                    selectedPrize.getName(),
                    selectedPrize.tickets(ParkWallet.getHoliday())
            );
        } else {
            System.out.printf("Not enough tickets to buy a %s%n", selectedPrize.getName());
        }
        System.out.println();
    }

    private static void toggleHoliday() {
        ParkWallet.setHoliday(!ParkWallet.getHoliday());
        System.out.println();
        if (ParkWallet.getHoliday()) {
            System.out.println("It is now on holiday.");
        } else {
            System.out.println("It is no longer a holiday.");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        final ParkWallet wallet = new ParkWallet(100);
        System.out.println("[Theme Park Wallet Manager]");

        while(true) {
            System.out.println("1. Add Tickets");
            System.out.println("2. Set Tickets");
            System.out.println("3. Buy Prize");
            System.out.println("4. Set Holiday");
            System.out.println("5. Quit");
            System.out.printf("Your wallet has %d tickets%n", wallet.getTickets());

            System.out.print("Enter option: ");
            final int option = scanner.nextInt();

            switch (option) {
                case 1 -> addTickets(wallet);
                case 2 -> setTickets(wallet);
                case 3 -> buyPrize(wallet);
                case 4 -> toggleHoliday();
                case 5 -> {
                    System.out.println("\nShutting off...");
                    return;
                }
            }
        }
    }
}
