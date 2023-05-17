package commands;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LibrarianCommands {

    public static void librarianMenu() {

        try (Scanner librarianMenuScan = new Scanner(System.in)) {
        	System.out.println("---------------");
            System.out.println("LIBRARIAN MENU");
            System.out.println("---------------");
            System.out.println("1 - Subscriber");
            System.out.println("2 - Document Type");
            System.out.println("3 - Document");
            // System.out.println("4 - Booking");
            // System.out.println("5 - Rules");

            System.out.println("Enter option number: ");
            int selectedOption = librarianMenuScan.nextInt();

            List<Integer> optionPossibility = Arrays.asList(1, 2, 3);

            if (optionPossibility.contains(selectedOption)) {

                switch (selectedOption) {
                    case 1:
                        crudSubscriberMenu();
                    case 2:
                        crudDocumentTypeMenu();
                    case 3:
                        crudDocumentMenu();
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

    public static void crudSubscriberMenu() {

        try (Scanner subscriberMenuScan = new Scanner(System.in)) {
            System.out.println("POSSIBLE ACTIONS ON THE SUBSCRIBER");
            System.out.println("---------------");
            System.out.println("1 - Consult");
            System.out.println("2 - Add");
            System.out.println("3 - Modify");
            System.out.println("4 - Delete");

            System.out.println("Enter option number: ");
            int selectedOption = subscriberMenuScan.nextInt();

            List<Integer> optionPossibility = Arrays.asList(1, 2, 3, 4);

            if (optionPossibility.contains(selectedOption)) {

                switch (selectedOption) {
                    case 1:
                        consultSubscriber();
                    case 2:
                        addSubscriber();
                    case 3:
                        modifySubscriber();
                    case 4:
                        deleteSubscriber();
                }

            } else {
                System.out.println("Option " + selectedOption + " doesn't exist. Choose an option between 1 and 4.");
            }

        } catch (Exception e) {
            System.out.println("ERROR :" + e.getMessage());
        }
    }
    
    public static void consultSubscriber() {
        System.out.println("ok");
    }

    public static void addSubscriber() {

    }

    public static void modifySubscriber() {

    }

    public static void deleteSubscriber() {

    }



    public static void crudDocumentTypeMenu() {

    }

    public static void crudDocumentMenu() {

    }

}
