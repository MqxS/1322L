package assignment5;

import java.util.Scanner;

public class Assignment5 {
    private static final String LeftArrow = "←";
    private static final String UpArrow = "↑";
    private static final String RightArrow = "→";
    private static final String DownArrow = "↓";

    private static boolean isUserEntryValid(final Tile[][] map, final int row, final int column) {
        return row >= 0 && column >= 0 && map.length > row && map[0].length > column;
    }

    private static void printMaze(final Tile[][] map) {
        final StringBuilder sb = new StringBuilder();
        for (final Tile[] row : map) {
            for (final Tile tile : row) {
                sb.append(String.format("%-2s", tile.getSymbol()));
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static boolean validateRow(final String row, final int mazeWidth) {
        if (row.length() != mazeWidth) {
            return false;
        }

        if (row.isEmpty()) {
            return true;
        }

        final char firstChar = row.charAt(0);
        return (firstChar == '.' || firstChar == '+')
                && validateRow(row.substring(1), mazeWidth - 1);
    }

    private static String pathFinder(final Tile[][] map, final int row, final int column) {
        if (!isUserEntryValid(map, row, column)) {
            return "";
        }

        final Tile tile = map[row][column];

        if (tile.isVisited() || tile.getSymbol().equals("+")) {
            return "";
        }

        if (tile.getSymbol().equals("x")) {
            return "x";
        }

        tile.setVisited(true);

        final String down = pathFinder(map, row + 1, column);
        if (!down.isEmpty()) {
            return DownArrow + down;
        }

        final String right = pathFinder(map, row, column + 1);
        if (!right.isEmpty()) {
            return RightArrow + right;
        }

        final String up = pathFinder(map, row - 1, column);
        if (!up.isEmpty()) {
            return  UpArrow + up;
        }

        final String left = pathFinder(map, row, column - 1);
        if (!left.isEmpty()) {
            return LeftArrow + left;
        }

        return "";
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("[Maze Pathfinder]");

        int mazeWidth;
        do {
            System.out.print("Enter size of maze. Must be 2 or greater: ");
            mazeWidth = scanner.nextInt();
            scanner.nextLine();
        } while (mazeWidth < 2);
        System.out.printf("Maze set to %dx%d%n", mazeWidth, mazeWidth);
        System.out.println();

        final Tile[][] map = new Tile[mazeWidth][mazeWidth];

        System.out.printf(
                "Enter maze row by row. " +
                "Row must be made of either walls (+) or empty spaces (.) and must be length of %d%n",
                mazeWidth
        );
        for (int i = 0; i < mazeWidth; i++) {
            System.out.printf("Enter row %d: ", i);
            final String row = scanner.nextLine();
            final boolean isRowValid = validateRow(row, mazeWidth);
            if (!isRowValid) {
                System.out.printf(
                        "Row must be made of either walls (+) or empty spaces (.) and must be of length %d%n",
                        mazeWidth
                );
                i--;
                continue;
            }

            for (int j = 0; j < row.length(); j++) {
                map[i][j] = new Tile(row.substring(j, j + 1));
            }
        }

        System.out.println();
        System.out.println("Here is your current maze:");
        printMaze(map);

        int startRow;
        int startColumn;
        boolean startInvalid = false;
        do {
            if (startInvalid) {
                System.out.printf("Invalid column: Must be between 0 and %d%n", mazeWidth-1);
            }

            System.out.println("Placing starting point");
            System.out.print("Place starting point in which row?: ");
            startRow = scanner.nextInt();
            System.out.print("Place starting point in which column?: ");
            startColumn = scanner.nextInt();
            scanner.nextLine();

            startInvalid = !isUserEntryValid(map, startRow, startColumn);
        } while (startInvalid);
        map[startRow][startColumn] = new Tile("o");


        System.out.println("----");
        int endRow;
        int endColumn;
        boolean endInvalid = false;
        boolean invalidStart = false;
        do {
            if (endInvalid) {
                System.out.printf("Invalid column: Must be between 0 and %d%n", mazeWidth-1);
            }
            if (invalidStart) {
                System.out.println("Cannot place ending point on starting point");
            }

            System.out.println("Placing ending point");
            System.out.print("Place ending point in which row?: ");
            endRow = scanner.nextInt();
            System.out.print("Place ending point in which column?: ");
            endColumn = scanner.nextInt();
            scanner.nextLine();
            endInvalid = !isUserEntryValid(map, endRow, endColumn);
            invalidStart = map[endRow][endColumn].getSymbol().equals("o");

        } while (endInvalid || invalidStart);
        map[endRow][endColumn] = new Tile("x");

        System.out.println();
        System.out.println("Here is your final maze:");
        printMaze(map);

        System.out.println("Press any key to run pathfinder...");
        scanner.nextLine();

        final String directions = pathFinder(map, startRow, startColumn);
        if (directions.isEmpty()) {
            System.out.println("There is no path from 'o' to 'x'");
        } else {
            System.out.println("To go from 'o' to 'x', follow these steps:");
            System.out.println(directions);
        }
    }
}
