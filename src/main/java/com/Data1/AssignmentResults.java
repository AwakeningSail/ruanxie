package com.Data1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AssignmentResults {
    private Map<String, String> assignmentresults; // 存储每个人的具体分工，key 为人员名称，value 为分工描述

    // 无参构造方法
    public AssignmentResults() {
        this.assignmentresults = new HashMap<>();
    }

    // 有参构造方法，接收一个 JSON 字符串
    public AssignmentResults(String jsonStr) {
        // 将字符串解析为 JSONObject 对象
        // 将 JSONObject 中的数据转换为 Map 存储
        this.assignmentresults = new HashMap<>();
        this.assignmentresults= JSON.parseObject(jsonStr,Map.class);
    }
    public AssignmentResults(JSONObject jsonObject){
        this.assignmentresults=(HashMap)jsonObject.entrySet();
    }

    public String ToJSONString(){
        return JSON.toJSONString(assignmentresults);
    }
    public JSONObject ToJSONObject(){
        return JSONObject.parseObject(JSON.toJSONString(assignmentresults));
    }

}