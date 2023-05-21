package com.Data1;

import java.util.Objects;

public class Teamwork {
    private int teamID;
    private WorkArrangements workArrangements; // 添加 JSONObject 类型的属性
    private int meetingMinutes;
    private AssignmentResults assignmentResults; // 添加 JSONObject 类型的属性
    private TeamScores teamScores;
    private int teamworkid;


    public Teamwork(com.Data.Teamwork teamwork){
        if(teamwork==null)return;
        this.meetingMinutes=teamwork.getMeetingMinutes();
        this.teamID=teamwork.getTeamID();
        if(teamwork.getAssignmentResults()!=null)this.assignmentResults=new AssignmentResults(teamwork.getAssignmentResults());
        else this.assignmentResults=new AssignmentResults();
        if(teamwork.getWorkArrangement()!=null)this.workArrangements=new WorkArrangements(teamwork.getWorkArrangement());
        else this.workArrangements=new WorkArrangements();
        this.teamworkid=teamwork.getTeamworkid();
        if(teamwork.getScore()!=null)this.teamScores=new TeamScores(teamwork.getScore());
        else this.teamScores=new TeamScores();
    }

    @Override
    public String toString() {
        return "Teamwork{" +
                "teamID=" + teamID +
                ", workArrangements=" + workArrangements +
                ", meetingMinutes=" + meetingMinutes +
                ", assignmentResults=" + assignmentResults +
                ", teamScores=" + teamScores +
                ", teamworkid=" + teamworkid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teamwork teamwork = (Teamwork) o;
        return teamID == teamwork.teamID && meetingMinutes == teamwork.meetingMinutes && teamworkid == teamwork.teamworkid && Objects.equals(workArrangements, teamwork.workArrangements) && Objects.equals(assignmentResults, teamwork.assignmentResults) && Objects.equals(teamScores, teamwork.teamScores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamID, workArrangements, meetingMinutes, assignmentResults, teamScores, teamworkid);
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

    public TeamScores getTeamScores() {
        return teamScores;
    }

    public void setTeamScores(TeamScores teamScores) {
        this.teamScores = teamScores;
    }

    public int getTeamworkid() {
        return teamworkid;
    }

    public void setTeamworkid(int teamworkid) {
        this.teamworkid = teamworkid;
    }

    public Teamwork(int teamID, WorkArrangements workArrangements, int meetingMinutes, AssignmentResults assignmentResults, TeamScores teamScores, int teamworkid) {
        this.teamID = teamID;
        this.workArrangements = workArrangements;
        this.meetingMinutes = meetingMinutes;
        this.assignmentResults = assignmentResults;
        this.teamScores = teamScores;
        this.teamworkid = teamworkid;
    }

    public Teamwork() {

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