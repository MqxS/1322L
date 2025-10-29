package lab9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab9 {
    private static ArrayList<String> readLinesFromFile(final File file) throws IOException {
        final ArrayList<String> lines = new ArrayList<>();
        try (final BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null;) {
                lines.add(line);
            }
        } catch (final IOException e) {
            throw new IOException(
                    String.format("%s (The system cannot find the file specified)%n", file.getName()));
        }
        return lines;
    }

    public static String diff(final File file1, final File file2) {
        final ArrayList<String> file1Lines;
        final ArrayList<String> file2Lines;
        try {
            file1Lines = readLinesFromFile(file1);
            file2Lines = readLinesFromFile(file2);
        } catch (final IOException e) {
            return e.getMessage();
        }

        final int file1Size = file1Lines.size();
        final int file2Size = file2Lines.size();
        final int maxSize = Math.max(file1Size, file2Size);
        final int minSize = Math.min(file1Size, file2Size);

        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxSize; i++) {
            if (i >= minSize) {
                sb.append("Files have different number of lines");
                sb.append(System.lineSeparator());
                return sb.toString();
            }

            final String line1 = file1Lines.get(i);
            final String line2 = file2Lines.get(i);

            if (!line1.equals(line2)) {
                sb.append(String.format("Line %d%n", i + 1))
                        .append(String.format("< %s%n", line1))
                        .append(String.format("> %s%n", line2));
            }
        }

        if (sb.isEmpty()) {
            sb.append("Files are identical");
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("[Diff Detector]");

        System.out.print("Enter the name of file 1: ");
        final String file1Name = scanner.nextLine();
        System.out.print("Enter the name of file 2: ");
        final String file2Name = scanner.nextLine();

        final File file1 = new File(file1Name);
        final File file2 = new File(file2Name);

        final String result = diff(file1, file2);
        System.out.println();
        System.out.println(result);

        System.out.println("Program complete");
    }
}
