package com.Data1;

import com.alibaba.fastjson.JSONObject;

import java.util.Objects;

public class TeamScore {
    String StudentID;
    int score;

    public String getStudentID() {
        return StudentID;
    }

    @Override
    public String toString() {
        return "TeamScore{" +
                "StudentID='" + StudentID + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamScore teamScore = (TeamScore) o;
        return score == teamScore.score && Objects.equals(StudentID, teamScore.StudentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(StudentID, score);
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public TeamScore(String studentID, int score) {
        StudentID = studentID;
        this.score = score;
    }
    public TeamScore(JSONObject jsonObject) {
        StudentID=jsonObject.getString("studentID");
        score=jsonObject.getInteger("score");
    }

}
