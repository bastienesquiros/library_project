package commands;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import dao.SubscriberDAO;
import entity.Subscriber;
import commands.LibrarianSubscriberCommands;

public class LibrarianSubscriberCommands {

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
                    case 2:
                        addSubscriber();
                    case 3:
                        LibrarianGeneralCommands.librarianMenu();
                
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
            System.out.println("Id subscriber : " + resu.getIdSubscriber());
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
                    case 2:
                        deleteSubscriber();
                    case 3:
                        librarianSubscriberMenu();
                }
            } else {
                System.out.println("Option " + selectedOption + " doesn't exist. Choose an option between 1 and 3.");
            }

        } catch (Exception e) {
            System.out.println("ERROR :" + e.getMessage());
        }
    }

    public static void addSubscriber() {

    	try (Scanner addSubscriberScan = new Scanner(System.in)) {
	    	System.out.println(" ");
	    	System.out.println("To create the subscriber, enter his firstname:");
	        String firstnameSubscriber = addSubscriberScan.nextLine();
	        System.out.println("Enter his lastname:");
	        String lastnameSubscriber = addSubscriberScan.nextLine();
	        System.out.println("Enter his address:");
	        String adressSubscriber = addSubscriberScan.nextLine();
	         	        
	        Subscriber newSubscriber = new Subscriber(firstnameSubscriber, lastnameSubscriber, adressSubscriber);
	        subscriberDAO.create(newSubscriber);    
	        
	        var resu = subscriberDAO.findByName(firstnameSubscriber, lastnameSubscriber);
	        System.out.println("                                  ");
            System.out.println("   - New Subscriber Informations -    ");
            System.out.println("                                  ");
            System.out.println("Id subscriber : " + resu.getIdSubscriber());
            System.out.println("Subscriber : " + resu.getFirstname() + " " + resu.getLastname());
            System.out.println("Address : " + resu.getAddress());
            System.out.println("                                  ");
            System.out.println("Borrowing capacity : " + resu.getNbMaxBorrow() + " document(s)");
            System.out.println("Blame number : " + resu.getBlame());
            System.out.println("Borrowing prohibited until : " + resu.getNotAllowedToBorrowUntil());
            
            librarianSubscriberMenu();
            
    	} catch (Exception e) {
            System.out.println("ERROR :" + e.getMessage());
        }
    }

    public static void modifySubscriber() {

    }

    public static void deleteSubscriber() {

    }
}
