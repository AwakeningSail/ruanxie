package com.mapper;

import com.Data.TeamDocument;

import java.util.List;

public interface TeamDocumentMapper {
    TeamDocument getTeamDocumentById(int teamDocumentId, int documentId);

    void addTeamDocument(TeamDocument teamDocument);

    void updateTeamDocument(TeamDocument teamDocument);

    void deleteTeamDocument(int teamDocumentId, int documentId);

    List<TeamDocument> getAllTeamDocuments();

    List<TeamDocument> getTeamDocumentByTeamDocumentId(int teamDocumentId);
}
