package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Document;
import main.Connect;

public class DocumentDAO implements DAO<Document>{
    
    public List<Document> findAll() {
        try {
            PreparedStatement prepare = Connect.getConnection().prepareStatement("SELECT * FROM document");
            ResultSet result = prepare.executeQuery();
            List<Document> documents = new ArrayList<>();
            while (result.next()) {
                Document document = new Document();
                document.setIdDocument(result.getInt("id_document"));
                document.setTitle(result.getString("title"));
                document.setIdDocumentType(result.getInt("id_document_type"));
                documents.add(document);
            }
            return documents;
        } catch (SQLException exception) {
            System.out.println("Erreur lors de la récupération des documents : " + exception.getMessage());
        }
        return null;
    }
    
    public Document find (int id) {
        try {
            PreparedStatement prepare = Connect.getConnection().prepareStatement("SELECT * FROM document WHERE id_document = ?");
            prepare.setInt(1, id);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                Document document = new Document();
                document.setIdDocument(result.getInt("id_document"));
                document.setTitle(result.getString("title"));
                document.setIdDocumentType(result.getInt("document_type"));
                return document;
            } else {
                System.out.println("Ce document n'existe pas");
            }
        } catch (SQLException exception) {
            System.out.println("Erreur lors de la récupération du document : " + exception.getMessage());
        }
        return null;
    }
    
    public Document create(Document document) {
        try {
            PreparedStatement prepare = Connect.getConnection().prepareStatement("INSERT INTO document (title, document_type) VALUES (?, ?)");
            prepare.setString(1, document.getTitle());
            prepare.setInt(2, document.getIdDocumentType());
            prepare.executeUpdate();
            System.out.println("Document créé avec succès");
            return document;
        } catch (SQLException exception) {
            System.out.println("Erreur lors de la création du document : " + exception.getMessage());
        }
        return null;
    }
    
    public String update(Document document) {
        try {
            PreparedStatement prepare = Connect.getConnection().prepareStatement("UPDATE document SET title = ?, document_type = ? WHERE id_document = ?");
            prepare.setString(1, document.getTitle());
            prepare.setInt(2, document.getIdDocumentType());
            prepare.setInt(3, document.getIdDocument());
            prepare.executeUpdate();
            return "Document mis à jour avec succès";
        } catch (SQLException exception) {
            System.out.println("Erreur lors de la mise à jour du document : " + exception.getMessage());
        }
        return null;
    }
    
    public String delete(int id) {
        try {
            PreparedStatement prepare = Connect.getConnection().prepareStatement("DELETE FROM document WHERE id_document = ?");
            prepare.setInt(1, id);
            prepare.executeUpdate();
            return "Document supprimé avec succès";
        } catch (SQLException exception) {
            System.out.println("Erreur lors de la suppression du document : " + exception.getMessage());
        }
        return null;
    }
}
