package com.Data1;

import java.sql.Time;
import com.alibaba.fastjson.JSONObject;

import javax.xml.crypto.Data;

public class Team {
        private int teamID;
        private int teamSize;
        private boolean isBuild;
        private Time buildTime;
        private Arrangement arrangement; // 添加 JSONObject 类型的属性
        private int teamDocumentID;
        private String replyScore;
        private String notice;

        // 构造方法
        public Team(int teamID, int teamSize, boolean isBuild, Time buildTime, String arrangement,
                    int teamDocumentID, String replyScore, String notice) {
                this.teamID = teamID;
                this.teamSize = teamSize;
                this.isBuild = isBuild;
                this.buildTime = buildTime;
                this.arrangement = new Arrangement(arrangement); // 将字符串解析为 JSONObject 对象
                this.teamDocumentID = teamDocumentID;
                this.replyScore = replyScore;
                this.notice = notice;
        }
        public Team(com.Data.Team team){
                this.teamID = team.getTeamID();
                this.teamSize = team.getTeamSize();
                this.isBuild = team.isBuild();
                this.buildTime = team.getBuildTime();
                this.arrangement = new Arrangement(team.getArrangement()); // 将字符串解析为 JSONObject 对象
                this.teamDocumentID = team.getTeamDocumentID();
                this.replyScore = team.getReplyScore();
                this.notice = team.getNotice();
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

        public String getArrangement() {
                return arrangement.toJSONString();
        }

        public void setArrangement(String arrangement) {
                this.arrangement = new Arrangement(arrangement);
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
}
