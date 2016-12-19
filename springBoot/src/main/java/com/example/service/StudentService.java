package com.example.service;

import com.example.dao.mapper.StudentMapper;
import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/12/14 0014.
 */
@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    public int inserStudent(String name, int age){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        int result = studentMapper.insert(student);
        return result;
    }
}
