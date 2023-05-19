package commands;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import dao.SubscriberDAO;
import entity.Document;
import entity.Subscriber;
import commands.LibrarianSubscriberCommands;

public class LibrarianSubscriberCommands {

    static SubscriberDAO subscriberDAO = new SubscriberDAO();
    static Subscriber currentSubscriber = null;

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

            currentSubscriber = subscriberDAO.findByName(firstnameSubscriber, lastnameSubscriber);

            System.out.println("                                  ");
            System.out.println("   - Subscriber Informations -    ");
            System.out.println("                                  ");
            System.out.println("Id subscriber : " + currentSubscriber.getIdSubscriber());
            System.out.println("Subscriber : " + currentSubscriber.getFirstname() + " " + currentSubscriber.getLastname());
            System.out.println("Address : " + currentSubscriber.getAddress());
            System.out.println("                                  ");
            System.out.println("Borrowing capacity : " + currentSubscriber.getNbMaxBorrow() + " document(s)");
            System.out.println("Blame number : " + currentSubscriber.getBlame());
            System.out.println("Borrowing prohibited until : " + currentSubscriber.getNotAllowedToBorrowUntil());
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
                        modifySubscriber(currentSubscriber);
                    case 2:
                        deleteSubscriber(currentSubscriber);
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

    public static void modifySubscriber(Subscriber currentSubscriber) {
    	
    	try (Scanner modifySubscriberScan = new Scanner(System.in)) {
    		  
           System.out.println(" ");
           System.out.println("1 - Modify firstname");
           System.out.println("2 - Modify lastname");
           System.out.println("3 - Modify address");
           System.out.println("4 - Modify borrowing capacity");
           System.out.println("5 - Modify blame number");
           System.out.println("6 - Modify borrowing prohibited until");
           System.out.println("7 - Back to Librarian Menu");
           System.out.println(" ");
           System.out.println("Enter option number: ");
           int selectedOption = modifySubscriberScan.nextInt();

           List<Integer> optionPossibility = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

           if (optionPossibility.contains(selectedOption)) {

               switch (selectedOption) {
                   case 1:
                	   updateFirstname(currentSubscriber);
                   case 2:
                	   updateLastname(currentSubscriber);
                   case 3:
                	   updateAddress(currentSubscriber);
                   case 4:
                	   updateMaxBorrow(currentSubscriber);
                   case 5:
                	   updateNbBlame(currentSubscriber);
                   case 6:
                	   updateNotAllowedToBorrowUntil(currentSubscriber);
                   case 7:
                	   librarianSubscriberMenu();
               
               }

           } else {
               System.out.println("Option " + selectedOption + " doesn't exist. Choose an option between 1 and 3.");
           }
		   
    	}
    }

    public static void updateFirstname(Subscriber currentSubscriber) {
    	
    	try (Scanner updateFirstnameScan = new Scanner(System.in)) {
	    
    		  System.out.println(" ");
              System.out.println("Enter new firstname");
              String newFirstname = updateFirstnameScan.nextLine();
              
              currentSubscriber.setFirstname(newFirstname);
              subscriberDAO.update(currentSubscriber);
              System.out.println("Firstname updated");
              
              librarianSubscriberMenu();
            
    	} catch (Exception e) {
            System.out.println("ERROR :" + e.getMessage());
        }
    }
    
public static void updateLastname(Subscriber selectedSubscriber) {
    	
    	try (Scanner updateLastnameScan = new Scanner(System.in)) {
	    
    		  System.out.println(" ");
              System.out.println("Enter new lastname");
              String newLastname = updateLastnameScan.nextLine();
              
              selectedSubscriber.setLastname(newLastname);
              subscriberDAO.update(selectedSubscriber);
              System.out.println("Lastname updated");
              
              librarianSubscriberMenu();
            
    	} catch (Exception e) {
            System.out.println("ERROR :" + e.getMessage());
        }
    }

	public static void updateAddress(Subscriber selectedSubscriber) {
		
		try (Scanner updateAddressScan = new Scanner(System.in)) {
	    
			  System.out.println(" ");
	          System.out.println("Enter new address");
	          String newAdress = updateAddressScan.nextLine();
	          
	          selectedSubscriber.setAddress(newAdress);
	          subscriberDAO.update(selectedSubscriber);
	          System.out.println("Adress updated");
	          
	          librarianSubscriberMenu();
	        
		} catch (Exception e) {
	        System.out.println("ERROR :" + e.getMessage());
	    }
	}
	
	public static void updateMaxBorrow(Subscriber selectedSubscriber) {
		
		try (Scanner updateMaxBorrowScan = new Scanner(System.in)) {
	    
			  System.out.println(" ");
	          System.out.println("Enter new borrowing capacity");
	          int newBorrowingCapacity = updateMaxBorrowScan.nextInt();
	          
	          selectedSubscriber.setNbMaxBorrow(newBorrowingCapacity);
	          subscriberDAO.update(selectedSubscriber);
	          System.out.println("Borrowing capacity updated");
	          
	          librarianSubscriberMenu();
	        
		} catch (Exception e) {
	        System.out.println("ERROR :" + e.getMessage());
	    }
	}
	
	public static void updateNbBlame(Subscriber selectedSubscriber) {
		
		try (Scanner updateNbBlameScan = new Scanner(System.in)) {
	    
			  System.out.println(" ");
	          System.out.println("Enter new blame number");
	          int newNbBlame = updateNbBlameScan.nextInt();
	          
	          selectedSubscriber.setBlame(newNbBlame);
	          subscriberDAO.update(selectedSubscriber);
	          System.out.println("Blame number updated");
	          
	          librarianSubscriberMenu();
	        
		} catch (Exception e) {
	        System.out.println("ERROR :" + e.getMessage());
	    }
	}
  
	public static void updateNotAllowedToBorrowUntil(Subscriber selectedSubscriber) {
		
		try (Scanner updateNotAllowedToBorrowUntilScan = new Scanner(System.in)) {
	    
			  System.out.println(" ");
	          System.out.println("Enter new date");
	          String newDate = updateNotAllowedToBorrowUntilScan.nextLine();
	          LocalDate date = LocalDate.parse(newDate);
	          
	          selectedSubscriber.setNotAllowedToBorrowUntil(date);
	          subscriberDAO.update(selectedSubscriber);
	          System.out.println("Borrowing prohibited date updated");
	          
	          librarianSubscriberMenu();
	        
		} catch (Exception e) {
	        System.out.println("ERROR :" + e.getMessage());
	    }
	}
	
    public static void deleteSubscriber(Subscriber currentSubscriber) {
    	
    	int subscriberId = currentSubscriber.getIdSubscriber();
    	subscriberDAO.delete(subscriberId);
    	System.out.println("Subscriber deleted");

    }
}
