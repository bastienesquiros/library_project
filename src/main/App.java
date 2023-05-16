package main;

import dao.UserDAO;
import entity.User;

public class App {
	
    public static void main(String[] args) {
    	Connect connect = new Connect();
    	connect.getConnection();
        UserDAO userDAO = new UserDAO(); // Créer une instance de UserDAO afin de manipuler la table user dans la base
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

        User bastienUpdated = new User(); // Créer une nouvelle instance utilisateur sans paramètres, afin de pouvoir
                                          // modifier les attributs de l'utilisateur avec les setters
        bastienUpdated.setIdUser(4); // Ici on cible quel utilisateur on souhaite modifier en base de données, ici
                                     // l'utilisateur avec l'id 4
        bastienUpdated.setLogin("Update"); // On modifie le login
        bastienUpdated.setPassword("update"); // On modifie le mot de passe
        bastienUpdated.setLibrarian(true); // On modifie le statut de bibliothécaire

        System.out.println(userDAO.update(bastienUpdated)); // On met à jour l'utilisateur en base de données

    }
}
