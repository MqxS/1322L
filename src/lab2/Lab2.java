package lab2;

import java.util.Scanner;

public class Lab2 {
    private static final Scanner scanner = new Scanner(System.in);

    private static void countToNumber() {
        System.out.println();
        System.out.print("Enter the start point: ");
        final int startCount = scanner.nextInt();
        System.out.print("Enter the end point: ");
        final int endCount = scanner.nextInt();

        System.out.printf("Counting from %s to %s...%n", startCount, endCount);
        if (startCount == endCount) {
            System.out.println("Start and end are the same!");
        } else {
            for (int i = startCount;
                 startCount < endCount ? i <= endCount : i >= endCount;
                 i += (startCount < endCount) ? 1 : -1
            ) {
                System.out.println(i);
            }
        }
        System.out.println("Done counting.");
        System.out.println();
    }

    private static void largestNumber() {
        System.out.println();
        System.out.println("This option will display the largest number entered. Enter 0 when done.");
        int largest = 0;
        int number;
        do {
            System.out.printf("Enter a number (current largest is %s): ", largest);
            number = scanner.nextInt();
            if (number > largest) {
                largest = number;
            }
        } while (number != 0);
        System.out.println("The largest number entered was " + largest);
        System.out.println();
    }

    private static void typeInComputer() {
        System.out.println();
        String word;
        System.out.print("Type in the word 'Computer': ");
        scanner.nextLine();
        word = scanner.nextLine();
        while (!word.equals("Computer")) {
            System.out.print("Incorrect. You must type 'Computer': ");
            word = scanner.nextLine();
        }
        System.out.println("Correct!");
        System.out.println();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Count from a number to another");
            System.out.println("2. Determine largest number");
            System.out.println("3. Type in word");
            System.out.println("4. Quit");
            System.out.print("Enter option: ");

            switch (scanner.nextInt()) {
                case 1 -> countToNumber();
                case 2 -> largestNumber();
                case 3 -> typeInComputer();
                case 4 -> {
                    System.out.printf("%nShutting off...");
                    return;
                }
            }
        }
    }
}
