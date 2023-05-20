package com.service;

import com.Data.Student;
import com.Data.Teacher;
import com.mapper.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;

public class TeacherService {

    @Autowired(required=false)
    private TeacherMapper teacherMapper;
    public TeacherService() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        teacherMapper=sqlSession.getMapper(com.mapper.TeacherMapper.class);
    }

    public Teacher Login(String ID, String Password){
        Teacher teacher= Find(ID);
        if(teacher==null){
            return null;
        }
        if(teacher.getPassword().equals(Password)){
            return teacher;
        }else{
            return null;
        }
    }
    Teacher Find(String ID){
        Teacher teacher=teacherMapper.getTeacherById(ID);
        if(teacher!=null)return teacher;
        teacher=teacherMapper.getTeacherById(ID);
        if(teacher!=null)return teacher;
        teacher=teacherMapper.getTeacherByTelephone(ID);
        if(teacher!=null)return teacher;
        return null;
    }

}
