package com.Data1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AssignmentResults {
    private Map<String, Integer> assignmentresults; // 存储每个人的具体分工，key 为人员名称，value 为分工描述

    public AssignmentResults(Map<String, Integer> assignmentresults) {
        this.assignmentresults = assignmentresults;
    }
    public AssignmentResults(String assignmentresult){
        this.assignmentresults=(Map)JSON.parse(assignmentresult);
    }

    public Map<String, Integer> getAssignmentresults() {
        return assignmentresults;
    }

    public void setAssignmentresults(Map<String, Integer> assignmentresults) {
        this.assignmentresults = assignmentresults;
    }

    public int getValue(String key){
        return assignmentresults.get(key);
    }

    @Override
    public String toString() {
        return "AssignmentResults{" +
                "assignmentresults=" + assignmentresults +
                '}';
    }
}