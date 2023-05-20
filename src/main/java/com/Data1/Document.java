package com.Data1;

import java.util.Objects;

public class Document {
    private int documentID;
    private String name;

    // getters and setters

    Document(){}
    public Document(com.Data.Document document){
        documentID=document.getDocumentID();
        String[] strings=document.getAddress().split("/");
        name=strings[strings.length-1];
    }
    @Override
    public String toString() {
        return "Document{" +
                "documentID=" + documentID +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return documentID == document.documentID && Objects.equals(name, document.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentID, name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDocumentID() {
        return documentID;
    }

    public void setDocumentID(int documentID) {
        this.documentID = documentID;
    }

    public Document(int documentID, String name) {
        this.documentID = documentID;
        this.name = name;
    }
}
