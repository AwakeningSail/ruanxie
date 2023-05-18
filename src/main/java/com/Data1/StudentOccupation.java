package com.Data1;

import com.Data.Student;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import java.util.Objects;

public class StudentOccupation {
    private String studentID;
    private String name;
    private String telephone;
    private String email;
    private String occupation;
    public StudentOccupation() {

    }
    public StudentOccupation(Student student, String occupation){
        this.studentID = student.getStudentID();
        this.name = student.getName();
        this.telephone = student.getTelephone();
        this.email = student.getEmail();
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "StudentPos{" +
                "studentID='" + studentID + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", occupation='" + occupation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentOccupation that = (StudentOccupation) o;
        return Objects.equals(studentID, that.studentID) && Objects.equals(name, that.name) && Objects.equals(telephone, that.telephone) && Objects.equals(email, that.email) && Objects.equals(occupation, that.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, name, telephone, email, occupation);
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public StudentOccupation(String studentID, String name, String telephone, String email, String occupation) {
        this.studentID = studentID;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.occupation = occupation;
    }
}

