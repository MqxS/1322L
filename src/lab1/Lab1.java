package lab1;

import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("[Budgeting System]");
        System.out.print("Enter your name: ");
        final String name = scanner.nextLine();
        System.out.printf("Hello %s. ", name);

        System.out.print("Please enter your monthly salary: ");
        final double salary = scanner.nextDouble();
        final double yearlySalary = salary * 12.0;
        System.out.println();

        System.out.print("What is the total amount of your loan? ");
        final double loanPrinciple = scanner.nextDouble();

        System.out.print("What is interest rate of your loan? ");
        final double loanInterest = scanner.nextDouble() / 100.0;

        final double newPrinciple = loanPrinciple * Math.pow(1 + (loanInterest / 12.0), 12);
        System.out.println();

        System.out.printf("Your yearly salary is $%.2f%n", yearlySalary);
        System.out.printf("In 12 months, your loan's principal will be $%.2f%n", newPrinciple);
        System.out.println();

        System.out.print("At the end of the year, you will have paid off your debt: ");
        System.out.println(yearlySalary >= newPrinciple);
        System.out.print("At the end of the year, your will still have some debt left: ");
        System.out.println(yearlySalary < newPrinciple);
        System.out.printf(
                "At the end of the year, you will have $%.2f of your salary left%n", yearlySalary - newPrinciple);
        System.out.println();

        System.out.println(
                "The government is offering loan relief for persons 25 and under, and for those 65 and over.");
        System.out.print("What is your age? ");
        final int age = scanner.nextInt();

        final boolean eligibleForRelief = (age <= 25) || (age >= 65);
        System.out.printf("The relief is $10000. You are eligible for the relief: %b%n", eligibleForRelief);

        final boolean loanPaidOff = (yearlySalary >= newPrinciple)
                || (eligibleForRelief && ((yearlySalary + 10000) >= newPrinciple));
        System.out.printf("With or without relief, you will be able to pay your loan in full: %b", loanPaidOff);
    }
}
