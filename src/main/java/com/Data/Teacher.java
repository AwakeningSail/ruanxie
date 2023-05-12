package com.Data;

import java.util.Objects;

public class Teacher {
    private String teacherID;
    private String name;
    private String password;
    private String classID;
    private String telephone;
    private String email;

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
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

    public Teacher(String teacherID, String name, String password, String classID, String telephone, String email) {
        this.teacherID = teacherID;
        this.name = name;
        this.password = password;
        this.classID = classID;
        this.telephone = telephone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherID='" + teacherID + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", classID='" + classID + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(teacherID, teacher.teacherID) && Objects.equals(name, teacher.name) && Objects.equals(password, teacher.password) && Objects.equals(classID, teacher.classID) && Objects.equals(telephone, teacher.telephone) && Objects.equals(email, teacher.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherID, name, password, classID, telephone, email);
    }
// getters and setters
}
