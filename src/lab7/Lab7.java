package lab7;

import java.util.Scanner;

public class Lab7 {
    private static final Scanner scanner = new Scanner(System.in);

    private static int multiply(final int a, final int b) {
        if (b == 0 || a == 0) {
            return 0;
        }

        if (b < 0) {
            return -multiply(a, -b);
        }

        return a + multiply(a, b - 1);
    }

    private static int divide(final int a, final int b) {
        if (b == 0) {
            return 0;
        }

        if (a < b) {
            return 0;
        }

        return 1 + divide(a - b, b);
    }

    private static int mod(final int a, final int b) {
        if (b == 0) {
            return 0;
        }

        if (a < b) {
            return a;
        } else {
            return mod(a - b, b);
        }
    }

    private static String echo(final String s, final int b) {
        if (b == 0) {
            return "";
        }
        return s + echo(s, b - 1);
    }

    private static boolean isReverse(final String s1, final String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.isEmpty()) {
            return true;
        }

        if (s1.charAt(0) != s2.charAt(s2.length() - 1)) {
            return false;
        }

        return isReverse(s1.substring(1), s2.substring(0, s2.length() - 1));

    }

    private static void menu() {
        System.out.println("1. Multiply 2 numbers");
        System.out.println("2. Divide 2 numbers");
        System.out.println("3. Mod 2 numbers");
        System.out.println("5. Determine if reverse");
        System.out.println("6. Quit");

        System.out.print("Enter option: ");
        final int option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                System.out.print("Enter the first number: ");
                final int a = scanner.nextInt();
                System.out.print("Enter the second number: ");
                final int b = scanner.nextInt();
                System.out.println("Your product is " + multiply(a, b));
                System.out.println();
            }
            case 2 -> {
                System.out.print("Enter the first number: ");
                final int a = scanner.nextInt();
                System.out.print("Enter the second number: ");
                final int b = scanner.nextInt();
                System.out.println("Your quotient is " + divide(a, b));
                System.out.println();
            }
            case 3 -> {
                System.out.print("Enter the first number: ");
                final int a = scanner.nextInt();
                System.out.print("Enter the second number: ");
                final int b = scanner.nextInt();
                System.out.println("Your modulus is " + mod(a, b));
                System.out.println();
            }
            case 4 -> {
                System.out.print("Enter your sentence: ");
                scanner.nextLine();
                final String s = scanner.nextLine();
                System.out.print("Repeat how many times? ");
                final int b = scanner.nextInt();
                System.out.printf("Your sentence repeated %d times is%n", b);
                System.out.println(echo(s, b));
                System.out.println();
            }
            case 5 -> {
                System.out.print("Enter a sentence: ");
                scanner.nextLine();
                final String s1 = scanner.nextLine().toLowerCase();
                System.out.print("Enter another sentence: ");
                final String s2 = scanner.nextLine().toLowerCase();
                final boolean result = isReverse(s1, s2);
                if (result) {
                    System.out.println("The sentences are the opposite of each other.");
                } else {
                    System.out.println("The sentences are NOT the opposite of each other.");
                }
                System.out.println();
            }
            case 6 -> {
                System.out.println("Shutting off...");
                System.exit(0);
            }
        }

        menu();
    }

    public static void main(String[] args) {
        menu();
    }
}
