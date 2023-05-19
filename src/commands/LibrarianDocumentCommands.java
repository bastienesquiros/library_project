package commands;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.DocumentDAO;
import entity.Document;

public class LibrarianDocumentCommands {
    static DocumentDAO documentDAO = new DocumentDAO();
    static Document currentDocument = null;

    public static void librarianDocumentMenu() {
        try (Scanner documentMenuScan = new Scanner(System.in)) {
            System.out.println("                                  ");
            System.out.println("----------------------------------");
            System.out.println("         DOCUMENTS MANAGEMENT     ");
            System.out.println("----------------------------------");
            System.out.println("                                  ");
            System.out.println("1 - Consult");
            System.out.println("2 - Add");
            System.out.println(" ");
            System.out.println("Enter option number: ");
            int selectedOption = documentMenuScan.nextInt();

            List<Integer> optionPossibility = Arrays.asList(1, 2);

            if (optionPossibility.contains(selectedOption)) {

                switch (selectedOption) {
                    case 1:
                        consultDocument();
                    case 2:
                        addDocument();

                }

            } else {
                System.out.println("Option " + selectedOption + " doesn't exist. Choose an option between 1 and 4.");
            }

        } catch (Exception e) {
            System.out.println("ERROR :" + e.getMessage());
        }
    }

    private static void addDocument() {
        try (Scanner addDocumentScan = new Scanner(System.in)) {

            System.out.println(" ");
            System.out.println("Please enter informations about the document you want to add");
            System.out.println("Enter title:");
            String documentTitle = addDocumentScan.nextLine();
            System.out.println("Enter the type of document:");
            int documentType = addDocumentScan.nextInt();
            Document documentToCreate = new Document(documentTitle, documentType);
            documentDAO.create(documentToCreate);
        } catch (Exception e) {
            System.out.println("ERROR :" + e.getMessage());
        }

    }

    private static void modifyDocument() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter the new title (current title: " + currentDocument.getTitle() + "):");
            String newTitle = input.nextLine();

            System.out.println("Enter the new document type (current document type: "
                    + currentDocument.getIdDocumentType() + "):");
            int newDocumentType = input.nextInt();

            currentDocument.setTitle(newTitle);
            currentDocument.setIdDocumentType(newDocumentType);

            String updateResult = documentDAO.update(currentDocument);
            System.out.println(updateResult);
        } catch (Exception e) {
            System.out.println("ERROR :" + e.getMessage());
        }

    }

    private static void deleteDocument() {
        documentDAO.delete(currentDocument);
    }

    private static void consultDocument() {

        try (Scanner consultDocumentScan = new Scanner(System.in)) {

            System.out.println(" ");
            System.out.println("Select the document you want work on");
            System.out.println("Enter title:");
            String documentTitle = consultDocumentScan.nextLine();
            currentDocument = documentDAO.findByTitle(documentTitle);

            if (documentDAO.findByTitle(documentTitle) == null) {
                System.out.println("This document doesn't exist");
            } else {
                System.out.println(documentDAO.findByTitle(documentTitle));

                System.out.println("ENTER OPTION NUMBER :");
                System.out.println(1 + " - Modify");
                System.out.println(2 + " - Delete");
                Scanner modifyOrDeleteScan = new Scanner(System.in);
                int modifyOrDelete = modifyOrDeleteScan.nextInt();

                if (modifyOrDelete == 1) {
                    modifyDocument();
                } else if (modifyOrDelete == 2) {
                    deleteDocument();
                } else {
                    System.out
                            .println("Option " + modifyOrDelete + " doesn't exist. Choose an option between 1 and 2.");
                }
                modifyOrDeleteScan.close();
            }

        } catch (Exception e) {
            System.out.println("ERROR :" + e.getMessage());
        }

    }

}
