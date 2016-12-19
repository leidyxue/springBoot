package com.example.dao.mapper;

import com.example.model.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by Administrator on 2016/12/14 0014.
 */
@MapperScan
public interface StudentMapper {

    @InsertProvider(type = StudentMapperProvider.class, method = "insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="student.id", before=false, resultType=int.class)
    int insert(@Param("student") Student student);

}
