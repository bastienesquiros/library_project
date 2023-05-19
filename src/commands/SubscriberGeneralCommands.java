package commands;

import java.util.Scanner;

import dao.DocumentDAO;
import dao.SubscriberDAO;
import dao.UserDAO;
import entity.Document;
import main.App;

public class SubscriberGeneralCommands {

    private SubscriberGeneralCommands() {
    }

    static DocumentDAO documentDAO = new DocumentDAO();

    public static void subscriberMenu() {
        boolean validOption = false;
        Scanner subscriberMenu = new Scanner(System.in);

        System.out.println("               ");
        System.out.println("SUBSCRIBER MENU");
        System.out.println("---------------");
        System.out.println("1 - My profile");
        System.out.println("2 - Search for a document");
        System.out.println("3 - My borrowing");
        System.out.println("4 - Log out");
        System.out.println("                     ");

        while (!validOption) {
            System.out.println("Enter option number: ");
            int selectedOption = subscriberMenu.nextInt();

            switch (selectedOption) {
                case 1:
                    subscriberProfile();
                    validOption = true;
                    break;
                case 2:
                    subscriberFindDocument();
                    validOption = true;
                    break;
                case 3:
                    System.out.println("My borrowing");
                    validOption = true;
                    break;
                case 4:
                    App.mainMenu();
                    validOption = true;
                    break;
                default:
                    System.out.println("Invalid option. Retry? (Y/N): ");
                    String retry = subscriberMenu.next();

                    if (retry.equalsIgnoreCase("N")) {
                        validOption = true;
                    }
                    break;
            }
        }
    }

    private static void subscriberProfile() {
        boolean validOption = false;
        Scanner subscriberProfile = new Scanner(System.in);

        System.out.println("MY PROFILE");
        System.out.println("----------");

        System.out.println(SubscriberDAO.displaySubscriberAndUserData(App.username));
        System.out.println(" ");

        System.out.println("1 - Edit profile");
        System.out.println("2 - Delete profile");
        System.out.println("3 - Back to menu");
        System.out.println(" ");

        while (!validOption) {
            System.out.println("Enter option number:");
            int selectedOption = subscriberProfile.nextInt();

            switch (selectedOption) {
                case 1:
                    subscriberEditProfile();
                    validOption = true;
                    break;
                case 2:
                    UserDAO.delete(App.username);
                    System.out.println("Profile deleted");
                    App.mainMenu();
                    validOption = true;
                    break;
                case 3:
                    subscriberMenu();
                    validOption = true;
                    break;
                default:
                    System.out.println("Invalid option. Retry? (Y/N): ");
                    String retry = subscriberProfile.next();

                    if (retry.equalsIgnoreCase("N")) {
                        validOption = true;
                    }
                    break;
            }
        }
    }

    private static void subscriberEditProfile() {
        // TODO
    }

    private static void subscriberFindDocument() {
        System.out.println("Enter the title of the document you want to find: ");
        Scanner userInput = new Scanner(System.in);
        String documentTitle = userInput.nextLine();

        if (documentDAO.findByTitle(documentTitle) == null) {
            System.out.println("No document found");
        } else {
            Document documentFound = documentDAO.findByTitle(documentTitle);
            System.out.println(documentFound.getTitle() + " exists in the library");
        }
    }
}
