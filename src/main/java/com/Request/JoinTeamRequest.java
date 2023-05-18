package com.Request;

import java.util.Objects;

public class JoinTeamRequest {
    int TeamID;


    public int getTeamID() {
        return TeamID;
    }

    @Override
    public String toString() {
        return "JoinTeamRequest{" +
                "TeamID=" + TeamID +
                '}';
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoinTeamRequest that = (JoinTeamRequest) o;
        return TeamID == that.TeamID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(TeamID);
    }

    public JoinTeamRequest() {
    }

    public JoinTeamRequest(int teamID) {
        TeamID = teamID;
    }
}
