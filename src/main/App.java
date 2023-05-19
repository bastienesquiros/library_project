package main;

import java.util.Scanner;

import commands.LibrarianGeneralCommands;
import commands.SubscriberGeneralCommands;
import dao.SubscriberDAO;
import dao.UserDAO;
import entity.Subscriber;
import entity.User;

public class App {
    private static UserDAO userDAO = new UserDAO();
    private static SubscriberDAO subscriberDAO = new SubscriberDAO();
    public static String username;

    public static void main(String[] args) {
        mainMenu();

    }

    public static void mainMenu() {
        boolean validOption = false;
        Scanner signInMenu = new Scanner(System.in);

        System.out.println("                             ");
        System.out.println("WELCOME TO THE LIBRARY SYSTEM");
        System.out.println("-----------------------------");
        System.out.println("                             ");
        System.out.println("1 - Sign in");
        System.out.println("2 - Sign up");
        System.out.println(" ");

        while (!validOption) {
            System.out.println("Enter option number: ");
            int selectedOption = signInMenu.nextInt();

            switch (selectedOption) {
                case 1:
                    signIn();
                    validOption = true;
                    break;
                case 2:
                    signUp();
                    validOption = true;
                    break;
                default:
                    System.out.println("Invalid option. Retry? (Y/N): ");
                    String retry = signInMenu.next();

                    if (retry.equalsIgnoreCase("N")) {
                        validOption = true;
                    }
                    break;
            }
        }
    }

    private static void signUp() {

        Scanner information = new Scanner(System.in);
        System.out.println("Enter your username: ");
        username = information.nextLine();
        System.out.println("Enter your password: ");
        String password = information.nextLine();
        System.out.println("Enter your first name: ");
        String firstName = information.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = information.nextLine();
        System.out.println("Enter your address: ");
        String address = information.nextLine();

        User user = new User(username, password, false);
        userDAO.create(user);
        Subscriber subscriber = new Subscriber(firstName, lastName, address, user.getIdUser());

        subscriberDAO.create(subscriber);
        System.out.println(" ");
        System.out.println("Your account has been created successfully");
        System.out.println("");
        System.out.println("Now you can sign in below:");
        System.out.println("-------------------------");
        signIn();
    }

    public static boolean signIn() {
        Scanner information = new Scanner(System.in);
        boolean authenticated = false;

        while (!authenticated) {
            System.out.println("Enter your username: ");
            username = information.nextLine();
            System.out.println("Enter your password: ");
            String password = information.nextLine();

            if (UserDAO.signIn(username, password)) {
                userType();
                authenticated = true;
            } else {
                System.out.println("Wrong username or password");
                System.out.println("Retry? (Y/N): ");
                String retry = information.nextLine();

                if (retry.equalsIgnoreCase("N")) {
                    break;
                }
            }
        }

        return authenticated;
    }

    public static void userType() {
        if (UserDAO.isLibrarian(username)) {
            LibrarianGeneralCommands.librarianMenu();
        } else {
            SubscriberGeneralCommands.subscriberMenu();
        }
    }

}
