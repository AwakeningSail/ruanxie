package com.Data1;

import java.util.Objects;

public class WorkArrangement {
    String StudentID;
    String Task;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkArrangement that = (WorkArrangement) o;
        return StudentID.equals(that.StudentID) && Task.equals(that.Task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(StudentID, Task);
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    public WorkArrangement(String studentID, String task) {
        StudentID = studentID;
        Task = task;
    }

    @Override
    public String toString() {
        return "WorkArrangement{" +
                "StudentID='" + StudentID + '\'' +
                ", Task='" + Task + '\'' +
                '}';
    }
}
