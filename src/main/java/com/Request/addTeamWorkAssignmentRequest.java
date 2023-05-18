package com.Request;

import java.util.Objects;

public class addTeamWorkAssignmentRequest {
    int DocumentID;
    int TeamWorkID;

    @Override
    public String
    toString() {
        return "addTeamWorkAssignmentRequest{" +
                "DocumentID=" + DocumentID +
                ", TeamWorkID=" + TeamWorkID +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        addTeamWorkAssignmentRequest that = (addTeamWorkAssignmentRequest) o;
        return DocumentID == that.DocumentID && TeamWorkID == that.TeamWorkID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(DocumentID, TeamWorkID);
    }

    public int getDocumentID() {
        return DocumentID;
    }

    public void setDocumentID(int documentID) {
        DocumentID = documentID;
    }

    public int getTeamWorkID() {
        return TeamWorkID;
    }

    public void setTeamWorkID(int teamWorkID) {
        TeamWorkID = teamWorkID;
    }

    public addTeamWorkAssignmentRequest(int documentID, int teamWorkID) {
        DocumentID = documentID;
        TeamWorkID = teamWorkID;
    }
}
