package com.example.controller;

import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/12/14 0014.
 */
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/studentAdd", method = { RequestMethod.GET})
    private String studentAdd(HttpServletRequest request){
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        studentService.inserStudent(name, age);
        return "add student success!";
    }
}
