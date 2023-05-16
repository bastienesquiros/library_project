package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.DocumentType;
import main.Connect;

public class DocumentTypeDAO implements DAO<DocumentType, String> {

    @Override
    public List<DocumentType> findAll() {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("SELECT * FROM document_type");
            ResultSet result = prepare.executeQuery();
            List<DocumentType> documentTypes = new ArrayList<>();
            while (result.next()) {
                DocumentType documentType = new DocumentType();
                documentType.setIdDocumentType(result.getInt("id_document_type"));
                documentType.setLabel(result.getString("label"));
                documentTypes.add(documentType);
            }
            return documentTypes;
        } catch (SQLException e) {
            System.out.println("Error while getting documents type : " + e.getMessage());
        }
        return null;
    }

    @Override
    public DocumentType find(int id) {
        try (PreparedStatement prepare = Connect.getConnection()
                .prepareStatement("SELECT * FROM document_type WHERE id_document_type = ?")) {
            prepare.setInt(1, id);
            ResultSet result = prepare.executeQuery();
            DocumentType documentType = new DocumentType();
            if (result.next()) {
                documentType.setIdDocumentType(result.getInt("id_document_type"));
                documentType.setLabel(result.getString("label"));
                return documentType;
            } else {
                System.out.println("Document type does not exist");
            }
        } catch (SQLException e) {
            System.out.println("Error while getting document type : " + e.getMessage());
        }
        return null;
    }

    @Override
    public DocumentType create(DocumentType obj) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("INSERT INTO document_type (label) VALUES (?)");
            prepare.setString(1, obj.getLabel());
            prepare.executeUpdate();
            return obj;
        } catch (SQLException e) {
            System.out.println("Error while creating document type : " + e.getMessage());
        }
        return null;
    }

    @Override
    public String delete(int id) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("DELETE FROM document_type WHERE id_document_type = ?");
            prepare.setInt(1, id);
            prepare.executeUpdate();
            return "Document type deleted";
        } catch (SQLException e) {
            System.out.println("Error while deleting document type : " + e.getMessage());
        }
        return null;
    }

    @Override
    public String update(DocumentType obj) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("UPDATE document_type SET label = ? WHERE id_document_type = ?");
            prepare.setString(1, obj.getLabel());
            prepare.setInt(2, obj.getIdDocumentType());
            prepare.executeUpdate();
            return "Document type updated";
        } catch (SQLException e) {
            System.out.println("Error while updating document type : " + e.getMessage());
        }
        return null;
    }

}
