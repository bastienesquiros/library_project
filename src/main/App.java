package main;

import dao.UserDAO;
import entity.User;
import dao.DocumentDAO;

public class App {
    public static void main(String[] args) {
    	DocumentDAO documentDAO = new DocumentDAO();
    	documentDAO.findAll().forEach(System.out::println);
    }
}
