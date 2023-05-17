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

}
