package com.mapper;

import com.Data.Team;

import java.util.List;

public interface TeamMapper {
    Team getTeamById(int teamId);

    void addTeam(Team team);

    void updateTeam(Team team);

    void deleteTeam(int teamId);

    List<Team> getAllTeams();
}
