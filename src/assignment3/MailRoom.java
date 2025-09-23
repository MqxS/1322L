package assignment3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.kennesaw.edu/ccse/first-year-experience/cse1322l/assignments/cse1322l_assignment_3_fall_2025.pdf
public class MailRoom {
    private static boolean handleLetter(final Letter letter, final ArrayList<Mail> letterList) {
        final boolean validLetter =
                !letter.getDeliveryAddress().isEmpty()
                        && !letter.getReturnAddress().isEmpty()
                        && 5 <= letter.getHeight()
                        && letter.getHeight() <= 11.5
                        && 3.5 <= letter.getWidth()
                        && letter.getWidth() <= 6.125
                        && 0.007 <= letter.getThickness()
                        && letter.getThickness() <= 0.25
                        && letter.getHeight()-letter.getWidth() >= 1.5;

        if (validLetter) {
            letterList.add(letter);
        }
        return validLetter;
    }

    private static boolean handleFlat(final Flat flat, final ArrayList<Mail> mailList) {
        final boolean validFlat = !flat.getDeliveryAddress().isEmpty()
                && !flat.getReturnAddress().isEmpty()
                && 11.5 <= flat.getHeight()
                && flat.getHeight() <= 15
                && 6.125 <= flat.getWidth()
                && flat.getWidth() <= 12
                && 0.25 <= flat.getThickness()
                && flat.getThickness() <= 0.75
                && flat.getContents().equals("DOCUMENTS");

        if (validFlat) {
            mailList.add(flat);
        }
        return validFlat;
    }

    //The boxList cannot be of type Box because the list we pass in is of type Mail
    private static boolean handleRegularBox(final RegularBox box, final List<Mail> boxList) {
        final boolean validFlat = !box.getDeliveryAddress().isEmpty()
                && !box.getReturnAddress().isEmpty()
                && 6 <= box.getHeight()
                && box.getHeight() <= 27
                && 0.25 <= box.getWidth()
                && box.getWidth() <= 17
                && 3 <= box.getBoxHeight()
                && box.getBoxHeight() <= 17
                && 0 <= box.getWeight()
                && box.getWeight() <= 70
                && 0 <= box.getCount()
                && box.getCount() <= 50;

        if (validFlat) {
            boxList.add(box);
        }
        return validFlat;
    }

    private static boolean handleLiveBox(final LiveBox box, final List<Mail> mailList) {
        final boolean validFlat = !box.getDeliveryAddress().isEmpty()
                && !box.getReturnAddress().isEmpty()
                && 6 <= box.getHeight()
                && box.getHeight() <= 27
                && 0.25 <= box.getWidth()
                && box.getWidth() <= 17
                && 3 <= box.getBoxHeight()
                && box.getBoxHeight() <= 17
                && ((box.getAnimal().equals("HONEYBEE")
                        && box.getCount() >= 0
                        && box.getCount() <= 20)
                    || (box.getAnimal().equals("CHICKEN")
                        && box.getAge() >= 0
                        && box.getAge() <= 1)
                );

        if (validFlat) {
            mailList.add(box);
        }
        return validFlat;
    }

    public static void main(String[] args) {
        final ArrayList<Mail> deliver = new ArrayList<>();
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to KSUPS");
        while(true) {
            System.out.println();
            System.out.println("1- Send letter");
            System.out.println("2- Send flat");
            System.out.println("3- Send regular box");
            System.out.println("4- Send live box");
            System.out.println("5- Dispatch items");
            System.out.println("6- Quit");

            System.out.print("Enter option: ");
            final int option = scanner.nextInt();
            scanner.nextLine();

            System.out.println();
            switch (option) {
                case 1, 2, 3, 4 -> {
                    System.out.print("Enter the delivery address: ");
                    final String deliveryAddress = scanner.nextLine();
                    System.out.print("Enter the return address: ");
                    final String returnAddress = scanner.nextLine();
                    System.out.print("Enter the width of your mail: ");
                    final double width = scanner.nextDouble();
                    System.out.print("Enter the length of your mail: ");
                    final double length = scanner.nextDouble();

                    switch (option) {
                        case 1 -> {
                            System.out.print("Enter the thickness of your mail: ");
                            final double thickness = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Enter the contents of your letter: ");
                            final String content = scanner.nextLine();

                            final Letter letter =
                                    new Letter(deliveryAddress, returnAddress, width, length, thickness, content);

                            System.out.println();
                            if(handleLetter(letter, deliver)) {
                                System.out.println("Letter accepted for delivery.");
                            } else {
                                System.out.println("Letter cannot be mailed.");
                            }
                        }
                        case 2 -> {
                            System.out.print("Enter the thickness of your mail: ");
                            final double thickness = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Enter the contents of your Flat: ");
                            final String content = scanner.nextLine();

                            final Flat flat =
                                    new Flat(deliveryAddress, returnAddress, width, length, thickness, content);

                            System.out.println();
                            if (handleFlat(flat, deliver)) {
                                System.out.println("Flat accepted for delivery.");
                            } else {
                                System.out.println("Flat cannot be mailed.");
                            }

                        }
                        case 3 -> {
                            System.out.print("Enter the height of your mail: ");
                            final double height = scanner.nextDouble();
                            System.out.print("Enter how many items your box has: ");
                            final int count = scanner.nextInt();
                            System.out.print("Enter the weight of your box: ");
                            final double weight = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Enter the contents of your box: ");
                            final String content = scanner.nextLine();

                            final RegularBox box = new RegularBox(
                                    deliveryAddress,
                                    returnAddress,
                                    width,
                                    length,
                                    height,
                                    count,
                                    content,
                                    weight
                            );

                            System.out.println();
                            if (handleRegularBox(box, deliver)) {
                                System.out.println("Regular Box accepted for delivery.");
                            } else {
                                System.out.println("Regular Box cannot be mailed.");
                            }
                        }
                        case 4 -> {
                            System.out.print("Enter the height of your mail: ");
                            final double height = scanner.nextDouble();
                            System.out.print("Enter how many items your box has: ");
                            final int count = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter what animal your box has: ");
                            final String animal = scanner.nextLine();
                            System.out.print("Enter age of the oldest animal, in days: ");
                            final int oldestAge = scanner.nextInt();

                            final LiveBox box = new LiveBox(
                                    deliveryAddress,
                                    returnAddress,
                                    width,
                                    length,
                                    height,
                                    count,
                                    animal,
                                    oldestAge
                            );

                            System.out.println();
                            if (handleLiveBox(box, deliver)) {
                                System.out.println("Live Box accepted for delivery.");
                            } else {
                                System.out.println("Live box cannot be mailed.");
                            }

                        }
                    }
                }
                case 5 -> {
                    if (!deliver.isEmpty()) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("DISPATCHING THE FOLLOWING ITEMS FOR DELIVERY:");
                        sb.append(System.lineSeparator());
                        for (final Mail mail : deliver) {
                            sb.append("==========");
                            sb.append(System.lineSeparator());
                            sb.append(mail.toString());
                        }
                        sb.append("==========");
                        System.out.println(sb);
                        deliver.clear();
                    } else {
                        System.out.println("Delivery queue is empty.");
                    }
                }
                case 6 -> {
                    System.out.println("Quitting...");
                    return;
                }
            }
        }
    }
}
