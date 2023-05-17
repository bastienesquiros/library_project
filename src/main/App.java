package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

import dao.DocumentTypeDAO;
import dao.SubscriberDAO;
import dao.UserDAO;
import entity.DocumentType;
import entity.User;
import entity.Subscriber;

public class App {
    public static void main(String[] args) {
        App.run();
    }

    private static void run() {
    	signIn();
    	
    	if(signIn() == true) {
    		userType();
    	}
    }
    
    public static boolean signIn() {
    
    	Scanner information = new Scanner(System.in);
    	System.out.println("WELCOME TO THE LIBRARY SYSTEM");
    	System.out.println("Enter your username: ");
    	String username = information.nextLine();
    	System.out.println("Enter your password: ");
    	String password = information.nextLine();
    	boolean verification = UserDAO.signIn(username, password);
    	information.close();
    	return verification;
    	
    }
    
    public static void userType() {
    	
    	 System.out.println("Yok");
//        boolean isLibrarian = false;
//        boolean isSubscriber = false;
//     
//    	Scanner signIn = new Scanner(System.in);
//
//
//        if (verification) {
//            if (UserDAO.isLibrarian(username)) {
//                System.out.println("You are logged in as a librarian !");
//                isLibrarian = true;
//            } else {
//                System.out.println("You are logged in as a subscriber !");
//                isSubscriber = true;
//            }
//
//        } else {
//            System.out.println("Wrong username or password!");
//        }
//  
//        if (isLibrarian) {
//            librarianMenu();
//        } else if (isSubscriber) {
//            subscriberMenu();
//        } 
    }

    
    private static void subscriberMenu() {
        System.out.println("A IMPLEMENTER");
    }

    private static void librarianMenu() {
         
        try (Scanner librarianMenu = new Scanner(System.in)) {
            System.out.println("LIBRARIAN MENU");
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
//            List<Integer> optionPossibility = Arrays.asList(1, 2, 3, 4, 5);
//        
//            if (optionPossibility.contains(selectedOption)) {
//                System.out.println(selectedOption);
//            } else {
//                System.out.println("Option" + selectedOption + "doesn't exist. Choose a option betwen 1 and 5.");
//            }

