package com.mapper;

import com.Data.TestPaper;

import java.util.List;

public interface TestPaperMapper {
    TestPaper getTestPaperById(String teacherId, int testPaperId);

    void addTestPaper(TestPaper testPaper);

    void updateTestPaper(TestPaper testPaper);

    void deleteTestPaper(String teacherId, int testPaperId);

    List<TestPaper> getAllTestPapers();
}
