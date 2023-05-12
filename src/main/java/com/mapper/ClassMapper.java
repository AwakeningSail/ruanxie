package com.mapper;

import java.util.List;

public interface ClassMapper {
    Class getClassById(String classId);

    void addClass(Class classObj);

    void updateClass(Class classObj);

    void deleteClass(String classId);

    List<Class> getAllClasses();
}
