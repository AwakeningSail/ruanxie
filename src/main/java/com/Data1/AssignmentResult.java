package com.Data1;

import java.util.Objects;

public class AssignmentResult {
    String StudentID;
    int documentID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignmentResult that = (AssignmentResult) o;
        return documentID == that.documentID && Objects.equals(StudentID, that.StudentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(StudentID, documentID);
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public int getDocumentID() {
        return documentID;
    }

    public void setDocumentID(int documentID) {
        this.documentID = documentID;
    }

    public AssignmentResult(String studentID, int documentID) {
        StudentID = studentID;
        this.documentID = documentID;
    }
}
