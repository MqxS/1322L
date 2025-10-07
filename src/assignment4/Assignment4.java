package assignment4;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment4 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final ArrayList<Media> allMedia = new ArrayList<>();

        System.out.println("[Media Manager]");
        System.out.println();
        while(true) {
            System.out.println("1- Add Image");
            System.out.println("2- Add Music");
            System.out.println("3- Add Video");
            System.out.println("4- Show images");
            System.out.println("5- Show music");
            System.out.println("6- Show videos");
            System.out.println("7- Show images and videos");
            System.out.println("8- Show music and videos");
            System.out.println("9- Exit");

            System.out.print("Enter option: ");
            final int option = scanner.nextInt();
            scanner.nextLine();

            System.out.println();
            switch (option) {
                case 1 -> {
                    System.out.print("Enter file name: ");
                    final String fileName = scanner.nextLine();
                    System.out.print("Enter image codec: ");
                    final String imageCodec = scanner.nextLine();

                    final Image image = new Image(fileName, imageCodec);
                    allMedia.add(image);
                    System.out.println();
                }
                case 2 -> {
                    System.out.print("Enter file name: ");
                    final String fileName = scanner.nextLine();
                    System.out.print("Enter audio codec: ");
                    final String audioCodec = scanner.nextLine();

                    final Music music = new Music(fileName, audioCodec);
                    allMedia.add(music);
                    System.out.println();
                }
                case 3 -> {
                    System.out.print("Enter file name: ");
                    final String fileName = scanner.nextLine();
                    System.out.print("Enter image codec: ");
                    final String imageCodec = scanner.nextLine();
                    System.out.print("Enter audio codec: ");
                    final String audioCodec = scanner.nextLine();

                    final Video video = new Video(fileName, imageCodec, audioCodec);
                    allMedia.add(video);
                    System.out.println();
                }
                case 4 -> {
                    for(final Media media : allMedia) {
                        if (media instanceof Image image) {
                            System.out.println(image.getMediaInfo());
                            System.out.println();
                        }
                    }
                }
                case 5 -> {
                    for(final Media media : allMedia) {
                        if (media instanceof Music music) {
                            System.out.println(music.getMediaInfo());
                            System.out.println();
                        }
                    }
                }
                case 6 -> {
                    for(final Media media : allMedia) {
                        if (media instanceof Video video) {
                            System.out.println(video.getMediaInfo());
                            System.out.println();
                        }
                    }
                }
                case 7 -> {
                    for(final Media media : allMedia) {
                        if (media instanceof Image image) {
                            System.out.println(image.getMediaInfo());
                            System.out.println();
                        } else if (media instanceof Video video) {
                            System.out.println(video.getMediaInfo());
                            System.out.println();
                        }
                    }
                }
                case 8 -> {
                    for(final Media media : allMedia) {
                        if (media instanceof Music music) {
                            System.out.println(music.getMediaInfo());
                            System.out.println();
                        } else if (media instanceof Video video) {
                            System.out.println(video.getMediaInfo());
                            System.out.println();
                        }
                    }
                }
                case 9 -> {
                    System.out.println("Shutting down...");
                    return;
                }
            }
        }
    }
}
