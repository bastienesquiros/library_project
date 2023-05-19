package commands;

import java.util.Scanner;

import dao.SubscriberDAO;
import dao.UserDAO;
import main.App;

public class SubscriberCommands {

    public static void subscriberMenu() {
        System.out.println("SUBSCRIBER MENU");
        System.out.println("---------------");
        System.out.println("1 - My profile");
        System.out.println("2 - Search for a document");
        System.out.println("4 - My borrowing");
        System.out.println("Enter option number: ");
        Scanner subscriberMenu = new Scanner(System.in);
        int selectedOption = subscriberMenu.nextInt();

        switch (selectedOption) {
            case 1:
                subscriberProfile();
                break;
            case 2:
                System.out.println("Search for a document");
                break;
            case 3:
                System.out.println("My borrowing");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

    }

    private static void subscriberProfile() {
        System.out.println("MY PROFILE");
        System.out.println("----------");
        System.out.println(UserDAO.displayByUsername(App.username));

        System.out.println("1 - Edit profile");
        System.out.println("2 - Delete profile");
        System.out.println("3 - Back to menu");

        Scanner subscriberProfile = new Scanner(System.in);
        int selectedOption = subscriberProfile.nextInt();

        switch (selectedOption) {
            case 1:
                subscriberEditProfile();
                break;
            case 2:
                // SubscriberDAO.delete(App.username);
        }
    }

    private static void subscriberEditProfile() {
    }

}
