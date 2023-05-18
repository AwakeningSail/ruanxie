package com.Request;

import java.util.Map;

public class AddTeamWorkArrangementRequest {
    private Map<String,String>TeamWorkArrangementRequest;

    public Map<String, String> getTeamWorkArrangementRequest() {
        return TeamWorkArrangementRequest;
    }

    public void setTeamWorkArrangementRequest(Map<String, String> teamWorkArrangementRequest) {
        TeamWorkArrangementRequest = teamWorkArrangementRequest;
    }

    @Override
    public String toString() {
        return "AddTeamWorkArrangementRequest{" +
                "TeamWorkArrangementRequest=" + TeamWorkArrangementRequest +
                '}';



    }

    public AddTeamWorkArrangementRequest(Map<String, String> teamWorkArrangementRequest) {
        TeamWorkArrangementRequest = teamWorkArrangementRequest;
    }
    public String getValue(String key){
        return TeamWorkArrangementRequest.get(key);
    }
}
