package commands;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.SubscriberDAO;

public class LibrarianSubscriberCommands {
    private LibrarianSubscriberCommands() {
    }

    static SubscriberDAO subscriberDAO = new SubscriberDAO();

    public static void librarianSubscriberMenu() {

        try (Scanner subscriberMenuScan = new Scanner(System.in)) {
            System.out.println("                                  ");
            System.out.println("----------------------------------");
            System.out.println("         SUBSCRIBERS MANAGEMENT   ");
            System.out.println("----------------------------------");
            System.out.println("                                  ");
            System.out.println("1 - Consult");
            System.out.println("2 - Add");
            System.out.println("3 - Back to Librarian Menu");
            System.out.println(" ");
            System.out.println("Enter option number: ");
            int selectedOption = subscriberMenuScan.nextInt();

            List<Integer> optionPossibility = Arrays.asList(1, 2, 3);

            if (optionPossibility.contains(selectedOption)) {

                switch (selectedOption) {
                    case 1:
                        consultSubscriber();
                        break;
                    case 2:
                        addSubscriber();
                        break;
                    case 3:
                        LibrarianGeneralCommands.librarianMenu();
                        break;
                    default:
                        System.out.println("Invalid option. Retry? (Y/N): ");
                        String retry = subscriberMenuScan.next();

                        if (retry.equalsIgnoreCase("N")) {
                            System.out.println("Back to Librarian Menu");
                            LibrarianGeneralCommands.librarianMenu();
                        }
                        break;
                }

            } else {
                System.out.println("Option " + selectedOption + " doesn't exist. Choose an option between 1 and 3.");
            }

        } catch (Exception e) {
            System.out.println("ERROR :" + e.getMessage());
        }
    }

    public static void consultSubscriber() {

        try (Scanner consultSubscriberScan = new Scanner(System.in)) {

            System.out.println(" ");
            System.out.println("Select the subscriber you want work on");
            System.out.println("Enter firstname:");
            String firstnameSubscriber = consultSubscriberScan.nextLine();
            System.out.println("Enter lastname:");
            String lastnameSubscriber = consultSubscriberScan.nextLine();

            var resu = subscriberDAO.findByName(firstnameSubscriber, lastnameSubscriber);

            System.out.println("                                  ");
            System.out.println("   - Subscriber Informations -    ");
            System.out.println("                                  ");
            System.out.println("Subscriber : " + resu.getFirstname() + " " + resu.getLastname());
            System.out.println("Address : " + resu.getAddress());
            System.out.println("                                  ");
            System.out.println("Borrowing capacity : " + resu.getNbMaxBorrow() + " document(s)");
            System.out.println("Blame number : " + resu.getBlame());
            System.out.println("Borrowing prohibited until : " + resu.getNotAllowedToBorrowUntil());
            System.out.println(" ");
            System.out.println("             -----               ");
            System.out.println("1 - Modify");
            System.out.println("2 - Delete");
            System.out.println("3 - Back to Subscriber Crud");
            System.out.println(" ");
            System.out.println("Enter option number: ");
            int selectedOption = consultSubscriberScan.nextInt();

            List<Integer> optionPossibility = Arrays.asList(1, 2, 3);

            if (optionPossibility.contains(selectedOption)) {

                switch (selectedOption) {
                    case 1:
                        modifySubscriber();
                        break;
                    case 2:
                        deleteSubscriber();
                        break;
                    case 3:
                        librarianSubscriberMenu();
                        break;
                    default:
                        System.out.println("Invalid option. Retry? (Y/N): ");
                        String retry = consultSubscriberScan.next();

                        if (retry.equalsIgnoreCase("N")) {
                            System.out.println("Back to Subscriber Crud");
                            librarianSubscriberMenu();
                        }
                        break;
                }
            } else {
                System.out.println("Option " + selectedOption + " doesn't exist. Choose an option between 1 and 3.");
            }

        } catch (Exception e) {
            System.out.println("ERROR :" + e.getMessage());
        }
    }

    public static void addSubscriber() {
        // TODO
    }

    public static void modifySubscriber() {
        // TODO
    }

    public static void deleteSubscriber() {
        // TODO
    }
}
