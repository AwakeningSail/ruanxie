package com.mapper;

import com.Data.Student;

import java.util.List;

public interface StudentMapper {
    Student getStudentById(String studentId);
    Student getStudentByTelephone(String Telephone);
    Student getStudentByEmail(String Email);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(String studentId);
    List<Student> getAllStudents();
}
