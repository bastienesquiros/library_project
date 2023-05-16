package main;

import dao.SubscriberDAO;
import dao.UserDAO;
import entity.User;
import entity.Subscriber;

public class App {
	
    public static void main(String[] args) {
    	// Connexion
    	Connect connect = new Connect();
    	connect.getConnection();
    	
    	// UserDAO userDAO = new UserDAO(); // Créer une instance de UserDAO afin de manipuler la table user dans la base
                                         // de données

        // userDAO.findAll().forEach(System.out::println); // Affiche tous les
        // utilisateurs

        // System.out.println(userDAO.find(1)); // Affiche l'utilisateur avec l'id 1

        // User newUser = new User("Richard", "richardno10", false); // Créer une
        // nouvelle instance utilisateur avec les attributs spécifiés (cela créer
        // uniquement dans notre code Java pas en base de données)

        // userDAO.create(newUser); // Créer l'utilisateur dans la base de données

        // System.out.println(userDAO.find(5)); // Affiche l'utilisateur avec l'id 5

        // System.err.println(userDAO.delete(6)); // Supprime l'utilisateur avec l'id 6

    	// User bastienUpdated = new User(); // Créer une nouvelle instance utilisateur sans paramètres, afin de pouvoir
                                          // modifier les attributs de l'utilisateur avec les setters
    	//	bastienUpdated.setIdUser(4); // Ici on cible quel utilisateur on souhaite modifier en base de données, ici
                                     // l'utilisateur avec l'id 4
    	// bastienUpdated.setLogin("Update"); // On modifie le login
    	// bastienUpdated.setPassword("update"); // On modifie le mot de passe
    	// bastienUpdated.setLibrarian(true); // On modifie le statut de bibliothécaire

    	// System.out.println(userDAO.update(bastienUpdated)); // On met à jour l'utilisateur en base de données
    	
    	// Créer une instance de SubscriberDAO afin de manipuler la table subscriber dans la base
    	 SubscriberDAO subscriberDAO = new SubscriberDAO();
    	// Affiche tous les subscriber
        // subscriberDAO.findAll().forEach(System.out::println);     
        // Affiche l'utilisateur avec l'id 2
        // System.out.println(subscriberDAO.find(2));
    	// Créer une nouvelle instance abonné
    	 Subscriber newSubscriber = new Subscriber("Bob", "bobno12", "111 Upper St", 3);
    	 System.out.println(newSubscriber);
    	// Créer l'abonné dans la base de données
    	// subscriberDAO.create(newSubscriber);     
     	// Supprime l'abonné dans la base de données
        // System.err.println(subscriberDAO.delete(10)); 
    	 

    	 newSubscriber.setFirstname("Bill");
    	 newSubscriber.setLastname("Gates");
    	 newSubscriber.setAddress("89 high way"); 
         newSubscriber.setNbMaxBorrow(4);
         newSubscriber.setBlame(1);
         newSubscriber.setNotAllowedToBorrowUntil("2023-06-25");
    	 System.out.println(newSubscriber);
         
    }
}
