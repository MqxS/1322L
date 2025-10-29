package lab10;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab10 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final ArrayList<Alarm> alarms = new ArrayList<>();

        System.out.println("[Alarm System]");
        while (true) {
            System.out.println("1. Create new alarm");
            System.out.println("2. View all alarms");
            System.out.println("3. Quit");

            System.out.print("Enter option: ");
            final int option = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (option) {
                case 1 -> {
                    System.out.print("Enter alarm name: ");
                    final String name = scanner.nextLine();
                    System.out.print("Enter alarm timer in seconds: ");
                    final String duration = scanner.nextLine();
                    final int durationSeconds;
                    try {
                        durationSeconds = Integer.parseInt(duration);
                    } catch (final NumberFormatException e) {
                        System.out.println("Invalid timer: Timer must be a whole number.");
                        System.out.println();
                        continue;
                    }

                    final Alarm alarm = new Alarm(name, durationSeconds);
                    alarm.start();
                    alarms.add(alarm);
                    System.out.println(alarm);
                    System.out.println();
                }
                case 2 -> {
                    System.out.println("Here are all the alarms still running:");
                    for (int i = 0; i < alarms.size(); i++) {
                        final Alarm alarm = alarms.get(i);
                        if (!alarm.isAlive()) {
                            alarms.remove(alarm);
                            continue;
                        }
                        System.out.println(alarm);
                    }
                    System.out.println();
                }
                case 3 -> {
                    System.out.println("Stopping all alarms...");
                    for (final Alarm alarm : alarms) {
                        alarm.interrupt();
                        try {
                            alarm.join();
                        } catch (final InterruptedException _) {}
                    }
                    System.out.println("All alarms have been stopped.");
                    System.out.println("Shutting off...");
                    return;
                }
            }
        }
    }
}
