package com.Data1;

import java.util.Objects;

public class Teamwork {
    private int teamID;
    private WorkArrangements workArrangements; // 添加 JSONObject 类型的属性
    private int meetingMinutes;
    private AssignmentResults assignmentResults; // 添加 JSONObject 类型的属性
    private int score;
    private int teamworkid;


    public Teamwork(com.Data.Teamwork teamwork){
        if(teamwork==null)return;
        this.meetingMinutes=teamwork.getMeetingMinutes();
        this.score=teamwork.getScore();
        this.teamID=teamwork.getTeamID();
        if(teamwork.getAssignmentResults()!=null)this.assignmentResults=new AssignmentResults(teamwork.getAssignmentResults());
        else this.assignmentResults=new AssignmentResults();
        if(teamwork.getWorkArrangement()!=null)this.workArrangements=new WorkArrangements(teamwork.getWorkArrangement());
        else this.workArrangements=new WorkArrangements();
        this.teamworkid=teamwork.getTeamworkid();
    }

    public Teamwork() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teamwork teamwork = (Teamwork) o;
        return teamID == teamwork.teamID && meetingMinutes == teamwork.meetingMinutes && score == teamwork.score && teamworkid == teamwork.teamworkid && Objects.equals(workArrangements, teamwork.workArrangements) && Objects.equals(assignmentResults, teamwork.assignmentResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamID, workArrangements, meetingMinutes, assignmentResults, score, teamworkid);
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public WorkArrangements getWorkArrangements() {
        return workArrangements;
    }

    public void setWorkArrangements(WorkArrangements workArrangements) {
        this.workArrangements = workArrangements;
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

    public void setScore(int score) {
        this.score = score;
    }

    public int getTeamworkid() {
        return teamworkid;
    }

    public void setTeamworkid(int teamworkid) {
        this.teamworkid = teamworkid;
    }

    public Teamwork(int teamID, WorkArrangements workArrangements, int meetingMinutes, AssignmentResults assignmentResults, int score, int teamworkid) {
        this.teamID = teamID;
        this.workArrangements = workArrangements;
        this.meetingMinutes = meetingMinutes;
        this.assignmentResults = assignmentResults;
        this.score = score;
        this.teamworkid = teamworkid;
    }
}
/*
[
  {
    "teamID": 1,
    "workArrangement": {
      "workArrangemnet": {
        "1": "1"
      }
    },
    "meetingMinutes": 0,
    "assignmentResults": {
      "assignmentresults": null
    },
    "score": 0,
    "teamworkid": 1
  }
]
*/