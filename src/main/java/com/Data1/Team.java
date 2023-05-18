package com.Data1;

import java.io.IOException;
import java.sql.Time;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import org.springframework.util.StringUtils;

import javax.xml.crypto.Data;

public class Team {
    private int teamID;
    private int teamSize;
    private boolean isBuild;
    private Time buildTime;
    private Arrangement arrangement; // 添加 JSONObject 类型的属性
    private String replyScore;
    private String notice;

    // 构造方法
    public Team(int teamID, int teamSize, boolean isBuild, Time buildTime, String arrangement,
                int teamDocumentID, String replyScore, String notice) throws IOException {
        this.teamID = teamID;
        this.teamSize = teamSize;
        this.isBuild = isBuild;
        this.buildTime = buildTime;
        this.arrangement = new Arrangement(arrangement); // 将字符串解析为 JSONObject 对象
        this.replyScore = replyScore;
        this.notice = notice;
    }

    public Team(com.Data.Team team) {
        this.teamID = team.getTeamID();
        this.teamSize = team.getTeamSize();
        this.isBuild = team.isBuild();
        this.buildTime = team.getBuildTime();
        this.arrangement = new Arrangement(team.getArrangement()); // 将字符串解析为 JSONObject 对象
        this.replyScore = team.getReplyScore();
        this.notice = team.getNotice();
    }

    public String toJSONString() {
        JsonFactory jsonFactory=new JsonFactory();
        String x=jsonFactory.toJsonString(this);
        return x;
    }

    public Team() {

    }

    public void setArrangement(Arrangement arrangement) {
        this.arrangement = arrangement;
    }

    // getters and setters
    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public boolean isBuild() {
        return isBuild;
    }

    public void setBuild(boolean build) {
        isBuild = build;
    }

    public Time getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(Time buildTime) {
        this.buildTime = buildTime;
    }

    public Arrangement getArrangement() {
        return arrangement;
    }

    public String getReplyScore() {
        return replyScore;
    }

    public void setReplyScore(String replyScore) {
        this.replyScore = replyScore;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamID=" + teamID +
                ", teamSize=" + teamSize +
                ", isBuild=" + isBuild +
                ", buildTime=" + buildTime +
                ", arrangement=" + arrangement +
                ", replyScore='" + replyScore + '\'' +
                ", notice='" + notice + '\'' +
                '}';
    }
}
