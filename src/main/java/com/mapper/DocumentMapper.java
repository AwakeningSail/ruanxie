package com.mapper;

import com.Data.Document;

import java.util.List;

public interface DocumentMapper {
    Document getDocumentById(int documentId);

    void addDocument(Document document);

    void updateDocument(Document document);

    void deleteDocument(int documentId);

    List<Document> getAllDocuments();
}
