package com.mapper;

import com.Data.StudentDocument;

import java.util.List;

public interface StudentDocumentMapper {
    void addStudentDocument(StudentDocument studentDocument);

    void deleteStudentDocument(String studentID, int documentID);

    List<StudentDocument> getStudentDocumentsByStudentID(String studentID);

    List<StudentDocument> getStudentDocumentsByDocumentID(int documentID);
}
