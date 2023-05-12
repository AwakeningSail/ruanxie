package com.Data1;

import com.alibaba.fastjson.JSONObject;

import java.util.Objects;

public class Arrangement {
    private String leader;
    private String productManager;
    private String planQualityManager;
    private String testManager;
    private String devManager;
    Arrangement(){}
    public Arrangement(String json) {
        JSONObject jsonObj = JSONObject.parseObject(json);
        this.leader = jsonObj.getString("leader");
        this.productManager = jsonObj.getString("productManager");
        this.planQualityManager = jsonObj.getString("planQualityManager");
        this.testManager = jsonObj.getString("testManager");
        this.devManager = jsonObj.getString("devManager");
    }
    public String toJSONString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("leader", this.leader);
        jsonObj.put("productManager", this.productManager);
        jsonObj.put("planQualityManager", this.planQualityManager);
        jsonObj.put("testManager", this.testManager);
        jsonObj.put("devManager", this.devManager);
        return jsonObj.toJSONString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arrangement that = (Arrangement) o;
        return Objects.equals(leader, that.leader) && Objects.equals(productManager, that.productManager) && Objects.equals(planQualityManager, that.planQualityManager) && Objects.equals(testManager, that.testManager) && Objects.equals(devManager, that.devManager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leader, productManager, planQualityManager, testManager, devManager);
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getProductManager() {
        return productManager;
    }

    public void setProductManager(String productManager) {
        this.productManager = productManager;
    }

    public String getPlanQualityManager() {
        return planQualityManager;
    }

    public void setPlanQualityManager(String planQualityManager) {
        this.planQualityManager = planQualityManager;
    }

    public String getTestManager() {
        return testManager;
    }

    public void setTestManager(String testManager) {
        this.testManager = testManager;
    }

    public String getDevManager() {
        return devManager;
    }

    public void setDevManager(String devManager) {
        this.devManager = devManager;
    }

    public Arrangement(String leader, String productManager, String planQualityManager, String testManager, String devManager) {
        this.leader = leader;
        this.productManager = productManager;
        this.planQualityManager = planQualityManager;
        this.testManager = testManager;
        this.devManager = devManager;
    }
}
