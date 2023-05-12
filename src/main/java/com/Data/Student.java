package com.Data;

import java.util.Objects;

public class Student {
    private String studentID;
    private String name;
    private String password;
    private int teamID;
    private String telephone;
    private String email;

    public Student() {

    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", teamID=" + teamID +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return teamID == student.teamID && Objects.equals(studentID, student.studentID) && Objects.equals(name, student.name) && Objects.equals(password, student.password) && Objects.equals(telephone, student.telephone) && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, name, password, teamID, telephone, email);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
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

    public Student(String studentID, String name, String password, int teamID, String telephone, String email) {
        this.studentID = studentID;
        this.name = name;
        this.password = password;
        this.teamID = teamID;
        this.telephone = telephone;
        this.email = email;
    }
// getters and setters
}

