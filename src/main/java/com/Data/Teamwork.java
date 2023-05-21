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
    private String score;

    public Teamwork(com.Data1.Teamwork teamwork){
        if(teamwork.getAssignmentResults()!=null)this.assignmentResults=JSONObject.toJSONString(teamwork.getAssignmentResults());
        this.meetingMinutes=teamwork.getMeetingMinutes();
        if(teamwork.getTeamScores()!=null)this.score=JSONObject.toJSONString(teamwork.getTeamScores());
        this.teamID=teamwork.getTeamID();
        if(teamwork.getWorkArrangements()!=null)this.workArrangement=JSONObject.toJSONString(teamwork.getWorkArrangements());
        this.teamworkid=teamwork.getTeamworkid();
    }

    @Override
    public String toString() {
        return "Teamwork{" +
                "teamID=" + teamID +
                ", teamworkid=" + teamworkid +
                ", workArrangement='" + workArrangement + '\'' +
                ", meetingMinutes=" + meetingMinutes +
                ", assignmentResults='" + assignmentResults + '\'' +
                ", score='" + score + '\'' +
                '}';
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public int getTeamworkid() {
        return teamworkid;
    }

    public void setTeamworkid(int teamworkid) {
        this.teamworkid = teamworkid;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Teamwork(int teamID, int teamworkid, String workArrangement, int meetingMinutes, String assignmentResults, String score) {
        this.teamID = teamID;
        this.teamworkid = teamworkid;
        this.workArrangement = workArrangement;
        this.meetingMinutes = meetingMinutes;
        this.assignmentResults = assignmentResults;
        this.score = score;
    }
}