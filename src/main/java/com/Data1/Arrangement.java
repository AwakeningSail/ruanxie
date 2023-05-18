package com.Data1;

import com.Data.Student;
import com.alibaba.fastjson.JSONObject;
import com.service.StudentService;

import java.io.IOException;
import java.util.Objects;

public class Arrangement {
    private Student leader;
    private Student productManager;
    private Student planQualityManager;
    private Student testManager;
    private Student devManager;
    public Arrangement(){
        this.leader=null;
        this.productManager =null ;
        this.planQualityManager =null ;
        this.testManager =null ;
        this.devManager =null ;
    }
    public Arrangement(String json) {
        System.out.println(json);
        JSONObject jsonObj = JSONObject.parseObject(json);
        if(jsonObj.getString("leader")!=null)this.leader = new Student(jsonObj.getString("leader"));
        if(jsonObj.getString("productManager")!=null)this.productManager =new Student(jsonObj.getString("productManager")) ;
        if(jsonObj.getString("planQualityManager")!=null)this.planQualityManager =new Student(jsonObj.getString("planQualityManager")) ;
        if(jsonObj.getString("testManager")!=null)this.testManager =new Student(jsonObj.getString("testManager")) ;
        if(jsonObj.getString("devManager")!=null)this.devManager=new Student(jsonObj.getString("devManager"));
    }
    public String toJSONString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("leader", this.leader);

        if(this.productManager!=null)jsonObj.put("productManager", this.productManager);
        if(this.planQualityManager!=null)jsonObj.put("planQualityManager", this.planQualityManager);
        if(this.testManager!=null)jsonObj.put("testManager", this.testManager);
        if(this.devManager!=null)jsonObj.put("devManager", this.devManager);
        return jsonObj.toJSONString();
    }

    @Override
    public String toString() {
        return "Arrangement{" +
                "leader=" + leader +
                ", productManager=" + productManager +
                ", planQualityManager=" + planQualityManager +
                ", testManager=" + testManager +
                ", devManager=" + devManager +
                '}';
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

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public Student getProductManager() {
        return productManager;
    }

    public void setProductManager(Student productManager) {
        this.productManager = productManager;
    }

    public Student getPlanQualityManager() {
        return planQualityManager;
    }

    public void setPlanQualityManager(Student planQualityManager) {
        this.planQualityManager = planQualityManager;
    }

    public Student getTestManager() {
        return testManager;
    }

    public void setTestManager(Student testManager) {
        this.testManager = testManager;
    }

    public Student getDevManager() {
        return devManager;
    }

    public void setDevManager(Student devManager) {
        this.devManager = devManager;
    }

    public Arrangement(Student leader, Student productManager, Student planQualityManager, Student testManager, Student devManager) {
        this.leader = leader;
        this.productManager = productManager;
        this.planQualityManager = planQualityManager;
        this.testManager = testManager;
        this.devManager = devManager;
    }
    public void setLeader(String leaderID) throws IOException {
        StudentService studentService = new StudentService();
        this.leader = studentService.Find(leaderID);
    }

    public void setProductManager(String productManagerID) throws IOException {
        StudentService studentService = new StudentService();
        this.productManager = studentService.Find(productManagerID);
    }

    public void setPlanQualityManager(String planQualityManagerID) throws IOException {
        StudentService studentService = new StudentService();
        this.planQualityManager = studentService.Find(planQualityManagerID);
    }

    public void setTestManager(String testManagerID) throws IOException {
        StudentService studentService = new StudentService();
        this.testManager = studentService.Find(testManagerID);
    }

    public void setDevManager(String devManagerID) throws IOException {
        StudentService studentService = new StudentService();
        this.devManager = studentService.Find(devManagerID);
    }

    public int getSize(){
        int a=0;
        if(this.leader!=null)a++;
        if(this.productManager !=null )a++;
        if(this.planQualityManager !=null )a++;
        if(this.testManager !=null)a++ ;
        if(this.devManager !=null )a++;
        return a;
    }
}
