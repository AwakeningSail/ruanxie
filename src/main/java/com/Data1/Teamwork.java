package com.Data1;

import com.alibaba.fastjson.JSONObject;

public class Teamwork {
    private int teamID;
    private WorkArrangement workArrangement; // 添加 JSONObject 类型的属性
    private int meetingMinutes;
    private AssignmentResults assignmentResults; // 添加 JSONObject 类型的属性
    private int score;

    // 构造方法
    public Teamwork(int teamID, String workArrangement, int meetingMinutes,
                    String assignmentResults, int score) {
        this.teamID = teamID;
        this.workArrangement = new WorkArrangement(workArrangement); // 将字符串解析为 JSONObject 对象
        this.meetingMinutes = meetingMinutes;
        this.assignmentResults = new AssignmentResults(assignmentResults); // 将字符串解析为 JSONObject 对象
        this.score = score;
    }
    public Teamwork(com.Data.Teamwork teamwork) {
        this.teamID = teamwork.getTeamID();
        this.workArrangement = new WorkArrangement(teamwork.getWorkArrangement()); // 将字符串解析为 JSONObject 对象
        this.meetingMinutes = teamwork.getMeetingMinutes();
        this.assignmentResults = new AssignmentResults(teamwork.getAssignmentResults()); // 将字符串解析为 JSONObject 对象
        this.score = teamwork.getScore();
    }
    // getters and setters
    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public JSONObject getWorkArrangement() {
        return workArrangement.ToJSONObject();
    }

    public void setWorkArrangement(JSONObject workArrangement) {
        this.workArrangement = new WorkArrangement(workArrangement);
    }

    public int getMeetingMinutes() {
        return meetingMinutes;
    }

    public void setMeetingMinutes(int meetingMinutes) {
        this.meetingMinutes = meetingMinutes;
    }

    public JSONObject getAssignmentResults() {
        return this.assignmentResults.ToJSONObject();
    }

    public void setAssignmentResults(JSONObject assignmentResults) {
        this.assignmentResults = new AssignmentResults(assignmentResults);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
