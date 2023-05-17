package main;

import java.time.LocalDate;

import dao.DocumentTypeDAO;
import dao.SubscriberDAO;
import dao.UserDAO;
import entity.DocumentType;
import entity.User;
import entity.Subscriber;

public class App {
    public static void main(String[] args) {

        SubscriberDAO subscriberDAO = new SubscriberDAO();

        Subscriber subscriberToRegister = new Subscriber("John", "Doe", "1 rue de la paix", 1);
        subscriberToRegister.setNotAllowedToBorrowUntil(LocalDate.of(2023, 12, 5)); // obligation d'écrire une date
                                                                                    // comme ceci

        subscriberDAO.create(subscriberToRegister);

    }
}
