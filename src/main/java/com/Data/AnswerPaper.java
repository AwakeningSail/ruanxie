package com.Data;

import java.util.Objects;

public class AnswerPaper {
    private String studentID;
    private int testPaperID;
    private int documentID;

    @Override
    public String toString() {
        return "AnswerPaper{" +
                "studentID='" + studentID + '\'' +
                ", testPaperID=" + testPaperID +
                ", documentID=" + documentID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerPaper that = (AnswerPaper) o;
        return testPaperID == that.testPaperID && documentID == that.documentID && Objects.equals(studentID, that.studentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, testPaperID, documentID);
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public int getTestPaperID() {
        return testPaperID;
    }

    public void setTestPaperID(int testPaperID) {
        this.testPaperID = testPaperID;
    }

    public int getDocumentID() {
        return documentID;
    }

    public void setDocumentID(int documentID) {
        this.documentID = documentID;
    }

    public AnswerPaper() {
    }

    public AnswerPaper(String studentID, int testPaperID, int documentID) {
        this.studentID = studentID;
        this.testPaperID = testPaperID;
        this.documentID = documentID;
    }
// getters and setters
}
