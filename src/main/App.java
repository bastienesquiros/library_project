package main;

import java.time.LocalDate;
import java.util.Scanner;

import dao.DocumentTypeDAO;
import dao.SubscriberDAO;
import dao.UserDAO;
import entity.DocumentType;
import entity.User;
import entity.Subscriber;

public class App {
    public static void main(String[] args) {
        App.signIn();
    }

    public static void signIn() {
        boolean isLibrarian = false;
        boolean isSubscriber = false;

        try (Scanner signIn = new Scanner(System.in)) {
            System.out.println("WELCOME TO THE LIBRARY SYSTEM");
            System.out.println("Enter your username: ");
            String username = signIn.nextLine();
            System.out.println("Enter your password: ");
            String password = signIn.nextLine();

            boolean verification = UserDAO.signIn(username, password);

            if (verification) {
                if (UserDAO.isLibrarian(username)) {
                    System.out.println("You are logged in as a librarian !");
                    isLibrarian = true;
                } else {
                    System.out.println("You are logged in as a subscriber !");
                    isSubscriber = true;

                }

            } else {
                System.out.println("Wrong username or password!");
            }
        } catch (Exception e) {
            System.out.println("Error while signing in: " + e.getMessage());
        } finally {
            if (isLibrarian) {
                librarianMenu();
            } else if (isSubscriber) {
                subscriberMenu();
            }
        }
    }

    private static void subscriberMenu() {
        System.out.println("A IMPLEMENTER");
    }

    private static void librarianMenu() {
        System.out.println("A IMPLEMENTER");
    }
}