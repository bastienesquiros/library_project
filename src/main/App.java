package main;

import dao.DocumentTypeDAO;
import dao.UserDAO;
import entity.DocumentType;
import entity.User;

public class App {
    public static void main(String[] args) {

        DocumentTypeDAO documentTypeDAO = new DocumentTypeDAO();

        DocumentType documentToUpdate = new DocumentType("TEST");
        documentToUpdate.setIdDocumentType(1);
        documentTypeDAO.update(documentToUpdate);
    }
}
