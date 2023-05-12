package com.Data;

import java.util.Objects;

public class Document {
    private int documentID;
    private String address;

    // getters and setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return documentID == document.documentID && Objects.equals(address, document.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentID, address);
    }

    public int getDocumentID() {
        return documentID;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentID=" + documentID +
                ", address='" + address + '\'' +
                '}';
    }

    public void setDocumentID(int documentID) {
        this.documentID = documentID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Document(){}
    public Document(int documentID, String address) {
        this.documentID = documentID;
        this.address = address;
    }

}
