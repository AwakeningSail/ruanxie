package com.Data;

import java.sql.Time;
import java.util.Objects;

public class Class {
    private String classID;
    private int classSize;
    private Time classBeginningTime;

    public Class() {
    }
// getters and setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return classSize == aClass.classSize && Objects.equals(classID, aClass.classID) && Objects.equals(classBeginningTime, aClass.classBeginningTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classID, classSize, classBeginningTime);
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public int getClassSize() {
        return classSize;
    }

    public void setClassSize(int classSize) {
        this.classSize = classSize;
    }

    public Time getClassBeginningTime() {
        return classBeginningTime;
    }

    public void setClassBeginningTime(Time classBeginningTime) {
        this.classBeginningTime = classBeginningTime;
    }

    public Class(String classID, int classSize, Time classBeginningTime) {
        this.classID = classID;
        this.classSize = classSize;
        this.classBeginningTime = classBeginningTime;
    }
}
