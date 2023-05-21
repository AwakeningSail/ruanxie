package com.Data1;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class WorkArrangements {
    private int size;
    private List<WorkArrangement> workArrangemnets; // 存储每个人的具体分工，key 为人员名称，value 为分工描述

    public WorkArrangements(String s){
        JSONObject jsonObject=JSONObject.parseObject(s);
        this.size=jsonObject.getInteger("size");
        List<JSONObject> strings=jsonObject.getJSONArray("workArrangemnets");
        workArrangemnets=new ArrayList<>();
        for(JSONObject jsonObject1:strings){
            workArrangemnets.add(new WorkArrangement(jsonObject1));
        }
    }
    public WorkArrangements(Map<String, String> map){
        this.workArrangemnets=new ArrayList<>();
        for(String s1:map.keySet()){
            this.workArrangemnets.add(new WorkArrangement(s1,map.get(s1)));
        }
        this.size=this.workArrangemnets.size();
    }
    public WorkArrangements(List<WorkArrangement> workArrangements){
        this.workArrangemnets=workArrangements;
        size=workArrangements.size();
    }
    public WorkArrangements() {
        workArrangemnets=new ArrayList<>();
    }

    @Override
    public String toString() {
        return "WorkArrangementS{" +
                "size=" + size +
                ", workArrangemnets=" + workArrangemnets +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkArrangements that = (WorkArrangements) o;
        return size == that.size && Objects.equals(workArrangemnets, that.workArrangemnets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, workArrangemnets);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<WorkArrangement> getWorkArrangemnets() {
        return workArrangemnets;
    }

    public void setWorkArrangemnets(List<WorkArrangement> workArrangemnets) {
        this.workArrangemnets = workArrangemnets;
    }

    public WorkArrangements(int size, List<WorkArrangement> workArrangemnets) {
        this.size = size;
        this.workArrangemnets = workArrangemnets;
    }
}