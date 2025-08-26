package lab5;

import java.util.Scanner;

public class Lab5 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Checking checking = new Checking(0);
    private static final Saving saving = new Saving(500);

    public static void main(String[] args) {
        System.out.println("[Banking System]");
        System.out.println();

        while(true) {
            System.out.println("1. Withdraw from Checking");
            System.out.println("2. Withdraw from Savings");
            System.out.println("3. Deposit to Checking");
            System.out.println("4. Deposit to Savings");
            System.out.println("5. Balance of Checking");
            System.out.println("6. Balance of Savings");
            System.out.println("7. Award Interest to Savings");
            System.out.println("8. Quit");

            System.out.print("Select option: ");
            final int option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println();
                    System.out.print("How much would you like to withdraw from Checking? $");
                    final double amount = scanner.nextDouble();
                    final double balance = checking.withdraw(amount);
                    System.out.printf("Current balance of Checking is $%.2f%n", balance);
                    System.out.println();
                }
                case 2 -> {
                    System.out.println();
                    System.out.print("How much would you like to withdraw from Savings? $");
                    final double amount = scanner.nextDouble();
                    final double balance = saving.withdraw(amount);
                    System.out.printf("Current balance of Savings is $%.2f%n", balance);
                    System.out.println();
                }
                case 3 -> {
                    System.out.println();
                    System.out.print("How much would you like to deposit to Checking? $");
                    final double amount = scanner.nextDouble();
                    final double balance = checking.deposit(amount);
                    System.out.printf("Current balance of Checking is $%.2f%n", balance);
                    System.out.println();
                }
                case 4 -> {
                    System.out.println();
                    System.out.print("How much would you like to deposit to Savings? $");
                    final double amount = scanner.nextDouble();
                    final double balance = saving.deposit(amount);
                    System.out.printf("Current balance of Savings is $%.2f%n", balance);
                    System.out.println();
                }
                case 5 -> System.out.printf("%n%s%n%n%n", checking);
                case 6 -> System.out.printf("%n%s%n%n%n", saving);
                case 7 -> {
                    System.out.println();
                    final double balance = saving.addInterest();
                    System.out.printf("Current balance of Savings is $%.2f%n", balance);
                    System.out.println();
                }
                case 8 -> {
                    System.out.println("\nShutting off...");
                    return;
                }
                default -> System.out.println("\nInvalid option.\n");
            }
        }
    }
}
