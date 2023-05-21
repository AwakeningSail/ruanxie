package com.Data1;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TeamScores {
    int size;
    private List<TeamScore> teamScores;

    public  TeamScores(String s){
        JSONObject jsonObject=JSONObject.parseObject(s);
        this.size=jsonObject.getInteger("size");
        List<JSONObject> strings=jsonObject.getJSONArray("teamScores");
        teamScores=new ArrayList<>();
        if(strings==null)return;
        for(JSONObject jsonObject1:strings){
            teamScores.add(new TeamScore(jsonObject1));
        }
    }

    public TeamScores() {

    }

    @Override
    public String toString() {
        return "TeamScores{" +
                "size=" + size +
                ", teamScores=" + teamScores +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamScores that = (TeamScores) o;
        return size == that.size && Objects.equals(teamScores, that.teamScores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, teamScores);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<TeamScore> getTeamScores() {
        return teamScores;
    }

    public void setTeamScores(List<TeamScore> teamScores) {
        this.teamScores = teamScores;
    }
    public void setTeamScores(TeamScore teamScore) {
        System.out.println(teamScores);
        List<TeamScore> teamScores1=new ArrayList<>();
        if(teamScores==null){
            teamScores=new ArrayList<>();
            teamScores.add(teamScore);
            this.size=1;
            return ;
        }
        for(TeamScore teamScore1:this.teamScores){
            if(!teamScore1.getStudentID().equals(teamScore.getStudentID())){
                teamScores1.add(teamScore1);
            }
        }
        teamScores1.add(teamScore);
        this.teamScores=teamScores1;
        this.size=teamScores.size();
        System.out.println(teamScores1);
    }
    public TeamScores(int size, List<TeamScore> teamScores) {
        this.size = size;
        this.teamScores = teamScores;
    }
}
