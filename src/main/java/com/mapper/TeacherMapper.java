package com.mapper;

import com.Data.Student;
import com.Data.Teacher;

import java.util.List;


public interface TeacherMapper {
    Teacher getTeacherById(String teacherId);
    Teacher getTeacherByTelephone(String Telephone);
    Teacher getTeacherByEmail(String Email);
    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    void deleteTeacher(String teacherId);

    List<Teacher> getAllTeachers();
}
