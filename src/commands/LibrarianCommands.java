package commands;

import java.util.Scanner;

public class LibrarianCommands {

    public static void librarianMenu() {

        try (Scanner librarianMenu = new Scanner(System.in)) {
            System.out.println("              ");
            System.out.println("LIBRARIAN MENU");
            System.out.println("--------------");
            System.out.println("              ");
            System.out.println("1 - Subscriber");
            System.out.println("2 - Document Type");
            System.out.println("3 - Type");
            System.out.println("4 - Booking");
            System.out.println("5 - Rules");

            System.out.println("Enter option number: ");
            int selectedOption = librarianMenu.nextInt();
            System.out.println(selectedOption);

        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        } finally {
            System.out.println("finish");
        }
    }
}
