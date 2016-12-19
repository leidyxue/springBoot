package com.example.dao.mapper;

import com.example.model.Student;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Administrator on 2016/12/14 0014.
 */
public class StudentMapperProvider {
    public String insert(final Student student){
        return new SQL(){
            {
                INSERT_INTO("student");
                VALUES("name", "#{student.name}");
                VALUES("age", "#{student.age}");
            }
        }.toString();
    }
}
