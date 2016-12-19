package com.example.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.RestfulApiApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestfulApiApplication.class)
@WebAppConfiguration
public class StudentServiceTest {
	@Autowired
    StudentService studentService;

	@Test
	public void testInserStudent() {
		System.out.print("start");
	    int result = studentService.inserStudent("xuelei11", 25);
	    System.out.print(result);
	}

}
