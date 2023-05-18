package com.Data1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class WorkArrangement {
    private Map<String, String> workArrangemnet; // 存储每个人的具体分工，key 为人员名称，value 为分工描述

    public WorkArrangement(Map<String, String> WorkArrangemnet) {
        workArrangemnet=new HashMap<>();
        for(String s:WorkArrangemnet.keySet()){
            workArrangemnet.put(s,WorkArrangemnet.get(s));
        }
    }
    public WorkArrangement(String workArrangemnet) {
        this.workArrangemnet = (Map<String, String>) JSONObject.parse(workArrangemnet);
    }

    public Map<String, String> getWorkArrangemnet() {
        return workArrangemnet;
    }

    public void setWorkArrangemnet(Map<String, String> workArrangemnet) {
        this.workArrangemnet = workArrangemnet;
    }
    public String getValue(String key){
        return this.workArrangemnet.get(key);
    }

    @Override
    public String toString() {
        return "WorkArrangement{" +
                "workArrangemnet=" + workArrangemnet +
                '}';
    }
}