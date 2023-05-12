package com.Data;

import java.util.Objects;

public class Teamwork {
    private int teamID;
    private String workArrangement;//文件形式安排
    private int meetingMinutes;
    private String assignmentResults;
    private int score;

    @Override
    public String toString() {
        return "Teamwork{" +
                "teamID=" + teamID +
                ", workArrangement='" + workArrangement + '\'' +
                ", meetingMinutes=" + meetingMinutes +
                ", assignmentResults='" + assignmentResults + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teamwork teamwork = (Teamwork) o;
        return teamID == teamwork.teamID && meetingMinutes == teamwork.meetingMinutes && score == teamwork.score && Objects.equals(workArrangement, teamwork.workArrangement) && Objects.equals(assignmentResults, teamwork.assignmentResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamID, workArrangement, meetingMinutes, assignmentResults, score);
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getWorkArrangement() {
        return workArrangement;
    }

    public void setWorkArrangement(String workArrangement) {
        this.workArrangement = workArrangement;
    }

    public int getMeetingMinutes() {
        return meetingMinutes;
    }

    public void setMeetingMinutes(int meetingMinutes) {
        this.meetingMinutes = meetingMinutes;
    }

    public String getAssignmentResults() {
        return assignmentResults;
    }

    public void setAssignmentResults(String assignmentResults) {
        this.assignmentResults = assignmentResults;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Teamwork(int teamID, String workArrangement, int meetingMinutes, String assignmentResults, int score) {
        this.teamID = teamID;
        this.workArrangement = workArrangement;
        this.meetingMinutes = meetingMinutes;
        this.assignmentResults = assignmentResults;
        this.score = score;
    }
// getters and setters
}