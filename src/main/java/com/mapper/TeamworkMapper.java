package com.mapper;

import com.Data.Teamwork;

import java.util.List;

public interface TeamworkMapper {
    List<Teamwork> getTeamworkById(int teamId);

    void addTeamwork(Teamwork teamwork);

    void updateTeamwork(Teamwork teamwork);

    void deleteTeamwork(int teamId);

    List<Teamwork> getAllTeamworks();

    Teamwork getTeamworkByTeamworkID(int TeamworkID);
    Teamwork getTeamworkByID1(int TeamworkID,int teamID);
}
