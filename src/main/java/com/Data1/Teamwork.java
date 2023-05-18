package com.Data1;

import com.alibaba.fastjson.JSONObject;

public class Teamwork {
    private int teamID;
    private WorkArrangement workArrangement; // 添加 JSONObject 类型的属性
    private int meetingMinutes;
    private AssignmentResults assignmentResults; // 添加 JSONObject 类型的属性
    private int score;
    private int teamworkid;

    public Teamwork() {

    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public WorkArrangement getWorkArrangement() {
        return workArrangement;
    }

    public void setWorkArrangement(WorkArrangement workArrangement) {
        this.workArrangement = workArrangement;
    }

    public int getMeetingMinutes() {
        return meetingMinutes;
    }

    public void setMeetingMinutes(int meetingMinutes) {
        this.meetingMinutes = meetingMinutes;
    }

    public AssignmentResults getAssignmentResults() {
        return assignmentResults;
    }

    public void setAssignmentResults(AssignmentResults assignmentResults) {
        this.assignmentResults = assignmentResults;
    }

    public int getScore() {
        return score;
    }

    public int getTeamworkid() {
        return this.teamworkid;
    }

    public void setTeamworkid(int teamworkid) {
        this.teamworkid = teamworkid;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Teamwork(int teamID, WorkArrangement workArrangement, int meetingMinutes, AssignmentResults assignmentResults, int score) {
        this.teamID = teamID;
        this.workArrangement = workArrangement;
        this.meetingMinutes = meetingMinutes;
        this.assignmentResults = assignmentResults;
        this.score = score;
    }

    public Teamwork(int teamID, WorkArrangement workArrangement, int meetingMinutes, AssignmentResults assignmentResults, int score, int teamworkid) {
        this.teamID = teamID;
        this.workArrangement = workArrangement;
        this.meetingMinutes = meetingMinutes;
        this.assignmentResults = assignmentResults;
        this.score = score;
        this.teamworkid = teamworkid;
    }

    public Teamwork(com.Data.Teamwork teamwork){
        this.meetingMinutes=teamwork.getMeetingMinutes();
        this.score=teamwork.getScore();
        this.teamID=teamwork.getTeamID();
        this.assignmentResults=new AssignmentResults(teamwork.getAssignmentResults());
        this.workArrangement=new WorkArrangement(teamwork.getWorkArrangement());
        this.teamworkid=teamwork.getTeamworkid();
    }

    @Override
    public String toString() {
        return "Teamwork{" +
                "teamID=" + teamID +
                ", workArrangement=" + workArrangement +
                ", meetingMinutes=" + meetingMinutes +
                ", assignmentResults=" + assignmentResults +
                ", score=" + score +
                ", teamworkid=" + teamworkid +
                '}';
    }
}
