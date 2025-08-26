package lab6;

import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final FindFib fibIteration = new FibIteration();
        final FindFib fibFormula = new FibFormula();

        System.out.print("Find which position in the Fibonacci Sequence? ");
        final int position = scanner.nextInt();

        System.out.printf("Fib of %d using iteration is %d%n", position, fibIteration.calculateFib(position));
        System.out.printf("Fib of %d using Binet's formula is %d%n", position, fibFormula.calculateFib(position));
        System.out.println("Program complete.");
    }
}
