package com.Data;

import java.sql.Time;
import java.util.Objects;

public class Team {
    private int teamID;
    private int teamSize;
    private boolean isBuild;
    private Time buildTime;
    private String arrangement;
    private int teamDocumentID;
    private String replyScore;
    private String notice;

    @Override
    public String toString() {
        return "Team{" +
                "teamID=" + teamID +
                ", teamSize=" + teamSize +
                ", isBuild=" + isBuild +
                ", buildTime=" + buildTime +
                ", arrangement='" + arrangement + '\'' +
                ", teamDocumentID=" + teamDocumentID +
                ", replyScore='" + replyScore + '\'' +
                ", notice='" + notice + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return teamID == team.teamID && teamSize == team.teamSize && isBuild == team.isBuild && teamDocumentID == team.teamDocumentID && Objects.equals(buildTime, team.buildTime) && Objects.equals(arrangement, team.arrangement) && Objects.equals(replyScore, team.replyScore) && Objects.equals(notice, team.notice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamID, teamSize, isBuild, buildTime, arrangement, teamDocumentID, replyScore, notice);
    }

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

    public String getArrangement() {
        return arrangement;
    }

    public void setArrangement(String arrangement) {
        this.arrangement = arrangement;
    }

    public int getTeamDocumentID() {
        return teamDocumentID;
    }

    public void setTeamDocumentID(int teamDocumentID) {
        this.teamDocumentID = teamDocumentID;
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

    public Team(int teamID, int teamSize, boolean isBuild, Time buildTime, String arrangement, int teamDocumentID, String replyScore, String notice) {
        this.teamID = teamID;
        this.teamSize = teamSize;
        this.isBuild = isBuild;
        this.buildTime = buildTime;
        this.arrangement = arrangement;
        this.teamDocumentID = teamDocumentID;
        this.replyScore = replyScore;
        this.notice = notice;
    }
// getters and setters
}
