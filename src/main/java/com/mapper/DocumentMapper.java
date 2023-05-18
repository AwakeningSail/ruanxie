package com.mapper;

import com.Data.Document;

import java.util.List;

public interface DocumentMapper {
    Document getDocumentById(int TeamID);

    void addDocument(Document document);

    void updateDocument(Document document);

    void deleteDocument(int TeamID);

    List<Document> getAllDocuments();
}
