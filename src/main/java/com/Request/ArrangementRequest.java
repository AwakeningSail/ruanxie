package com.Request;

import com.Data.Student;

public class ArrangementRequest {
    private String leader;
    private String productManager;
    private String planQualityManager;
    private String testManager;
    private String devManager;

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

    public ArrangementRequest(String leader, String productManager, String planQualityManager, String testManager, String devManager) {
        this.leader = leader;
        this.productManager = productManager;
        this.planQualityManager = planQualityManager;
        this.testManager = testManager;
        this.devManager = devManager;
    }
}
