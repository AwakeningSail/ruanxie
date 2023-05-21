package com.Request;

import java.util.Objects;

public class updateScoreRequest {
    int TeamworkID;
    int score;
    String StudentID;

    public updateScoreRequest(int teamworkID, int score, String studentID) {
        TeamworkID = teamworkID;
        this.score = score;
        StudentID = studentID;
    }

    public int getTeamworkID() {
        return TeamworkID;
    }

    public void setTeamworkID(int teamworkID) {
        TeamworkID = teamworkID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public updateScoreRequest() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public String toString() {
        return "updateScoreRequest{" +
                "TeamworkID=" + TeamworkID +
                ", score=" + score +
                ", StudentID='" + StudentID + '\'' +
                '}';
    }
}
