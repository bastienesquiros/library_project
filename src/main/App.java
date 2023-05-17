package main;

import java.time.LocalDate;
import java.time.zone.ZoneRules;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import commands.LibrarianCommands;
import commands.SubscriberCommands;
import dao.UserDAO;

public class App {
    public static String username;

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        if (signIn()) {
            userType();
        }
    }

    public static void userType() {
        if (UserDAO.isLibrarian(username)) {
            LibrarianCommands.librarianMenu();
        } else {
            SubscriberCommands.subscriberMenu();
        }
    }

    public static boolean signIn() {

        Scanner information = new Scanner(System.in);
        System.out.println("                             ");
        System.out.println("WELCOME TO THE LIBRARY SYSTEM");
        System.out.println("-----------------------------");
        System.out.println("                             ");
        System.out.println("Enter your username: ");
        username = information.nextLine();
        System.out.println("Enter your password: ");
        String password = information.nextLine();
        if (UserDAO.signIn(username, password)) {
            return true;
        } else {
            System.out.println("                          ");
            System.out.println("Wrong username or password");
            return false;
        }
    }

    private static void librarianMenu() {

        try (Scanner librarianMenuScan = new Scanner(System.in)) {
            System.out.println("LIBRARIAN MENU");
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
                    case 5:
                        deleteSubscriber();
                }

            } else {
                System.out.println("Option " + selectedOption + " doesn't exist. Choose an option between 1 and 4.");
            }

        } catch (Exception e) {
            System.out.println("ERROR :" + e.getMessage());
        }
    }
}
