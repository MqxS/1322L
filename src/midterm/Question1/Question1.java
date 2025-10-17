package midterm.Question1;

import java.util.Random;
import java.util.Scanner;

public class Question1 {
    private static char[] placeDucks() {
        final char[] ducks = new char[8];
        final Random random = new Random();

        int set = 0;
        while (set < 3) {
            final int i = random.nextInt(ducks.length);
            if (ducks[i] != 'd') {
                ducks[i] = 'd';
                set++;
            }
        }

        return ducks;
    }

    private static boolean checkForDucks(final char[] ducks) {
        for (final char duck : ducks) {
            if (duck == 'd') {
                return true;
            }
        }
        return false;
    }

    private static void drawboard(final char[] ducks) {
        final StringBuilder sb = new StringBuilder();
        for (final char duck : ducks) {
            sb.append(duck).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final char[] ducks = placeDucks();
        final char[] bushes = {'_', '_', '_', '_', '_', '_', '_', '_'};

        System.out.println("[Duck Shooter]");
        while (true) {
            drawboard(bushes);
            System.out.printf("Shoot where? (0 - %d): ", ducks.length-1);
            final int shot = scanner.nextInt();

            if (shot < 0 || shot >= ducks.length) {
                System.out.println("You cannot shoot outside the range!");
                System.out.println();
                continue;
            }

            final char bush = bushes[shot];
            if (bush == '+' || bush == 'x') {
                System.out.println("You already shot there!");
                System.out.println();
                continue;
            } else if (bush == '_') {
                final char duck = ducks[shot];
                if (duck == 'd') {
                    System.out.println("You hit a duck!");
                    ducks[shot] = '+';
                    bushes[shot] = '+';
                } else {
                    System.out.println("You didn't hit anything...");
                    ducks[shot] = 'x';
                    bushes[shot] = 'x';
                }
                System.out.println();
            }

            if (!checkForDucks(ducks)) {
                drawboard(bushes);
                System.out.println("You've shot all the ducks!");
                return;
            }
        }
    }
}