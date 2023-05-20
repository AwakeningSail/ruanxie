package com.Data;

import java.util.Objects;

public class StudentDocument {
    private String studentID;
    private int documentID;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public StudentDocument(String studentID, int documentID) {
        this.studentID = studentID;
        this.documentID = documentID;
    }

    @Override
    public String toString() {
        return "StudentDocument{" +
                "studentID='" + studentID + '\'' +
                ", documentID=" + documentID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDocument that = (StudentDocument) o;
        return documentID == that.documentID && Objects.equals(studentID, that.studentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, documentID);
    }

    public int getDocumentID() {
        return documentID;
    }

    public void setDocumentID(int documentID) {
        this.documentID = documentID;
    }
}
