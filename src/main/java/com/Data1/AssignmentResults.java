package com.Data1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class AssignmentResults {
    int size;
    private List<AssignmentResult> assignmentResults; // 存储每个人的具体分工，key 为人员名称，value 为分工描述

    public AssignmentResults(String s){
        JSONObject jsonObject=JSONObject.parseObject(s);
        this.size=jsonObject.getInteger("size");
        List<JSONObject> strings=jsonObject.getJSONArray("assignmentResults");
        assignmentResults=new ArrayList<>();
        for(JSONObject jsonObject1:strings){
            assignmentResults.add(new AssignmentResult(jsonObject1));
        }
    }

    public AssignmentResults() {
        this.assignmentResults=new ArrayList<>();
    }

    @Override
    public String toString() {
        return "AssignmentResults{" +
                "size=" + size +
                ", assignmentResults=" + assignmentResults +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignmentResults that = (AssignmentResults) o;
        return size == that.size && Objects.equals(assignmentResults, that.assignmentResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, assignmentResults);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<AssignmentResult> getAssignmentResults() {
        return assignmentResults;
    }

    public void setAssignmentResults(List<AssignmentResult> assignmentResults) {
        this.assignmentResults = assignmentResults;
    }
    public void setAssignmentResults(AssignmentResult assignmentResult) {
        System.out.println(assignmentResults);
        List<AssignmentResult> assignmentResults1=new ArrayList<>();
        for(AssignmentResult assignmentResult1:this.assignmentResults){
            if(!assignmentResult1.getStudentID().equals(assignmentResult.getStudentID())){
                assignmentResults1.add(assignmentResult1);
            }
        }
        assignmentResults1.add(assignmentResult);
        this.assignmentResults=assignmentResults1;
        System.out.println(assignmentResults1);
    }
    public AssignmentResults(int size, List<AssignmentResult> assignmentResults) {
        this.size = size;
        this.assignmentResults = assignmentResults;
    }
}