package entity;

public class Document {
    private int idDocument;
    private String title;
    private int idDocumentType;

    public int getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIdDocumentType() {
        return idDocumentType;
    }

    public void setIdDocumentType(int idDocumentType) {
        this.idDocumentType = idDocumentType;
    }

	@Override
	public String toString() {
		return "Document [idDocument=" + idDocument + ", title=" + title + ", idDocumentType=" + idDocumentType + "]";
	}
}
