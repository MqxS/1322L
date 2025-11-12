package assignment7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Assignment7 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Warehouse warehouse = new Warehouse();
        final Collection<Future<?>> futures = new ArrayList<>();
        final ExecutorService executor = Executors.newFixedThreadPool(5);

        System.out.println("[GoodFortune Warehouse]");
        System.out.println();

        System.out.print("Store how many boxes of tomatoes: ");
        final int tomatoBoxes = scanner.nextInt();
        System.out.print("What is the price of tomatoes? $");
        final double tomatoPrice = scanner.nextDouble();
        final Produce tomato = new Produce("tomatoes", tomatoPrice);
        final FarmHand tomatoFarmHand = new FarmHand(warehouse, tomato, tomatoBoxes);

        System.out.print("Store how many boxes of lettuce: ");
        final int lettuceBoxes = scanner.nextInt();
        System.out.print("What is the price of lettuce? $");
        final double lettucePrice = scanner.nextDouble();
        final Produce lettuce = new Produce("lettuce", lettucePrice);
        final FarmHand lettuceFarmHand = new FarmHand(warehouse, lettuce, lettuceBoxes);

        System.out.print("Store how many boxes carrots: ");
        final int carrotsBoxes = scanner.nextInt();
        System.out.print("What is the price of carrots? $");
        final double carrotsPrice = scanner.nextDouble();
        final Produce carrots = new Produce("carrots", carrotsPrice);
        final FarmHand carrotFarmHand = new FarmHand(warehouse, carrots, carrotsBoxes);
        scanner.nextLine();

        System.out.println();
        System.out.println("Farm hands are ready to start working.");
        System.out.println("Press any key to start the work...");
        scanner.nextLine();

        futures.add(executor.submit(tomatoFarmHand));
        futures.add(executor.submit(lettuceFarmHand));
        futures.add(executor.submit(carrotFarmHand));

        System.out.println("Work has started. Waiting for farm hands to finish...");

        for (final Future<?> future : futures) {
            try {
                future.get();
            } catch (final Exception _) {}
        }

        System.out.println("Warehouse is fully loaded.");
        System.out.println();

        System.out.print("Assign how many workers at the warehouse? ");
        final int workers = scanner.nextInt();
        scanner.nextLine();

        System.out.println("All workers are at their stations.");
        System.out.println("Press any key to start charity event...");
        scanner.nextLine();

        for (int i = 0; i < workers; i++) {
            futures.add(executor.submit(new CharityWorker(warehouse)));
        }

        System.out.println("Charity event started...");
        executor.shutdown();
        for (final Future<?> future : futures) {
            try {
                future.get();
            } catch (final Exception _) {}
        }

        System.out.println();
        System.out.println("The event was a success!");
        System.out.printf("A total of %d boxes of %s were given away.%n", warehouse.tomatoesSold, tomato.getProduceName());
        System.out.printf("A total of %d boxes of %s were given away.%n", warehouse.lettuceSold, lettuce.getProduceName());
        System.out.printf("A total of %d boxes of %s were given away.%n", warehouse.carrotsSold, carrots.getProduceName());
        System.out.printf("A total of $%.2f was made in tax savings.%n", warehouse.getTaxSavings());
        executor.close();
    }
}
