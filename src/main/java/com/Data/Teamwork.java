package com.Data;

import com.Data1.WorkArrangement;
import com.alibaba.fastjson.JSONObject;

import java.util.Objects;

public class Teamwork {
    private int teamID;
    private int teamworkid;
    private String workArrangement;
    private int meetingMinutes;
    private String assignmentResults;
    private int score;

    public int getTeamworkid() {
        return teamworkid;
    }

    public void setTeamworkid(int teamworkid) {
        this.teamworkid = teamworkid;
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

    public Teamwork(int teamID, int teamworkid, String workArrangement, int meetingMinutes, String assignmentResults, int score) {
        this.teamID = teamID;
        this.teamworkid = teamworkid;
        this.workArrangement = workArrangement;
        this.meetingMinutes = meetingMinutes;
        this.assignmentResults = assignmentResults;
        this.score = score;
    }

    public void setAssignmentResults(com.Data1.AssignmentResults assignmentResults){
        this.assignmentResults=JSONObject.toJSONString(assignmentResults);
    }
    public void setWorkArrangement(WorkArrangement workArrangement) {
        this.workArrangement = JSONObject.toJSONString(workArrangement);
    }
    public Teamwork(com.Data1.Teamwork teamwork){
        if(teamwork.getAssignmentResults()!=null)this.assignmentResults=JSONObject.toJSONString(teamwork.getAssignmentResults().getAssignmentresults());
        this.meetingMinutes=teamwork.getMeetingMinutes();
        this.score=teamwork.getScore();
        this.teamID=teamwork.getTeamID();
        if(teamwork.getWorkArrangement()!=null)this.workArrangement=JSONObject.toJSONString(teamwork.getWorkArrangement().getWorkArrangemnet());
        this.teamworkid=teamwork.getTeamworkid();
    }

    @Override
    public String toString() {
        return "Teamwork{" +
                "teamID=" + teamID +
                ", workArrangement='" + workArrangement + '\'' +
                ", meetingMinutes=" + meetingMinutes +
                ", assignmentResults='" + assignmentResults + '\'' +
                ", score=" + score +
                ", teamworkid=" + teamworkid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teamwork teamwork = (Teamwork) o;
        return teamID == teamwork.teamID && meetingMinutes == teamwork.meetingMinutes && score == teamwork.score && teamworkid == teamwork.teamworkid && Objects.equals(workArrangement, teamwork.workArrangement) && Objects.equals(assignmentResults, teamwork.assignmentResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamID, workArrangement, meetingMinutes, assignmentResults, score, teamworkid);
    }
// getters and setters
}