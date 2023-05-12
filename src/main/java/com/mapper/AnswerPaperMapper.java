package com.mapper;

import com.Data.AnswerPaper;

import java.util.List;

public interface AnswerPaperMapper {
    AnswerPaper getAnswerPaperById(String studentId, int testPaperId);

    void addAnswerPaper(AnswerPaper answerPaper);

    void updateAnswerPaper(AnswerPaper answerPaper);

    void deleteAnswerPaper(String studentId, int testPaperId);

    List<AnswerPaper> getAllAnswerPapers();
}
