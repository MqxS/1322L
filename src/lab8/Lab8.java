package lab8;

import java.util.Scanner;

public class Lab8 {
    public static int differenceInSeconds(final String time1, final String time2) {
        final String[] splitTime1 = time1.split(":");
        final String[] splitTime2 = time2.split(":");

        if (splitTime1.length != 3 || splitTime2.length != 3) {
            throw new InvalidTimeException("Timestamp must be in format HH:MM:SS");
        }

        final int hours1 = Integer.parseInt(splitTime1[0]);
        final int minutes1 = Integer.parseInt(splitTime1[1]);
        final int seconds1 = Integer.parseInt(splitTime1[2]);

        final int hours2 = Integer.parseInt(splitTime2[0]);
        final int minutes2 = Integer.parseInt(splitTime2[1]);
        final int seconds2 = Integer.parseInt(splitTime2[2]);

        if (hours1 < 0 || hours2 < 0) {
            throw new InvalidTimeException("Hours must be greater than or equal to 0");
        }
        if (hours1 > 23 || hours2 > 23) {
            throw new InvalidTimeException("Hours must be less than 24");
        }

        if (minutes1 < 0 || minutes2 < 0) {
            throw new InvalidTimeException("Minutes must be greater than or equal to 0");
        }
        if (minutes1 > 59 || minutes2 > 59) {
            throw new InvalidTimeException("Minutes must be less than 60");
        }

        if (seconds1 < 0 || seconds2 < 0) {
            throw new InvalidTimeException("Seconds must be greater than or equal to 0");
        }
        if (seconds1 > 59 || seconds2 > 59) {
            throw new InvalidTimeException("Seconds must be less than 60");
        }

        final int totalSeconds1 = hours1 * 3600 + minutes1 * 60 + seconds1;
        final int totalSeconds2 = hours2 * 3600 + minutes2 * 60 + seconds2;

        return Math.abs(totalSeconds1 - totalSeconds2);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("[Time Calculator]");

        while (true) {
            System.out.println("1. Calculate difference in seconds");
            System.out.println("2. Exit");

            System.out.print("Enter your option: ");
            final int option = scanner.nextInt();
            scanner.nextLine();

            System.out.println();
            switch (option) {
                case 1 -> {
                    System.out.print("Enter the start timestamp: ");
                    final String startTime = scanner.nextLine();
                    System.out.print("Enter the end timestamp: ");
                    final String endTime = scanner.nextLine();
                    try {
                        final int difference = differenceInSeconds(startTime, endTime);
                        System.out.printf(
                                "The difference between %s and %s is %d seconds%n", startTime, endTime, difference);
                    } catch (final InvalidTimeException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println();
                }
                case 2 -> {
                    System.out.println("Shutting off...");
                    return;
                }
            }
        }
    }
}
