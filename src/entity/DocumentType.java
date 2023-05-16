package entity;

public class DocumentType {
    private String label;
    private int idDocumentType;

    public DocumentType() {
    }

    public DocumentType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getIdDocumentType() {
        return idDocumentType;
    }

    public void setIdDocumentType(int idUser) {
        this.idDocumentType = idUser;
    }

    @Override
    public String toString() {
        return "DocumentType [label=" + label + ", idDocumentType=" + idDocumentType + "]";
    }

}
