package commands;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LibrarianGeneralCommands {

    public static void librarianMenu() {

        try (Scanner librarianMenuScan = new Scanner(System.in)) {
            System.out.println(" ");
            System.out.println("----------------------------------");
            System.out.println("          LIBRARIAN MENU          ");
            System.out.println("----------------------------------");
            System.out.println(" ");
            System.out.println("1 - Subscriber");
            System.out.println("2 - Document Type");
            System.out.println("3 - Document");
            // System.out.println("4 - Booking");
            // System.out.println("5 - Rules");
            System.out.println(" ");
            System.out.println("Enter option number: ");
            int selectedOption = librarianMenuScan.nextInt();

            List<Integer> optionPossibility = Arrays.asList(1, 2, 3);

            if (optionPossibility.contains(selectedOption)) {

                switch (selectedOption) {
                    case 1:
                        LibrarianSubscriberCommands.librarianSubscriberMenu();

                    case 2:
                        // crudDocumentTypeMenu();
                    case 3:
                        LibrarianDocumentCommands.librarianDocumentMenu();
                        // case 4: booking();
                        // case 5: zoneRules();
                }

            } else {
                System.out.println("Option " + selectedOption + " doesn't exist. Choose an option between 1 and 3.");
            }

        } catch (Exception e) {
            System.out.println("ERROR :" + e.getMessage());
        }
    }

}
