package com.service;

import com.Data.Student;
import com.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;

public class StudentLogin {

    @Autowired(required=false)
    private StudentMapper studentMapper;
    public StudentLogin() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        studentMapper=sqlSession.getMapper(com.mapper.StudentMapper.class);
    }

    public Student Login(String ID, String Password){
        Student student=check(ID);
        if(student==null){
            return null;
        }
        if(student.getPassword().equals(Password)){
            return student;
        }else{
            return null;
        }
    }
    Student check(String ID){
        Student student=studentMapper.getStudentByEmail(ID);
        if(student!=null)return student;
        student=studentMapper.getStudentById(ID);
        if(student!=null)return student;
        student=studentMapper.getStudentByTelephone(ID);
        if(student!=null)return student;
        return null;
    }

}
