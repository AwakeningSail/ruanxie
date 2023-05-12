package com.mapper;

import com.Data.Score;

import java.util.List;

public interface ScoreMapper {
    Score getScoreById(String studentId, int testPaperId, int teamId);

    void addScore(Score score);

    void updateScore(Score score);

    void deleteScore(String studentId, int testPaperId, int teamId);

    List<Score> getAllScores();
}
