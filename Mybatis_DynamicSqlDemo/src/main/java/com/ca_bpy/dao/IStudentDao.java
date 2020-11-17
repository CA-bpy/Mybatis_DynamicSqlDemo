package com.ca_bpy.dao;

import com.ca_bpy.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Persistence layer interface
 * Define the method of operating database.
 **/
public interface IStudentDao {
    //使用对象进行多个参数查询操作
    //动态SQL 使用<if>标签
    List<Student> selectStudentsObjectIf(Student student);
    //动态SQL 使用<where>标签
    List<Student> selectStudentsObjectWhere(Student student);
    //动态SQL 使用<foreach>标签
    List<Student> selectStudentsObjectForeach(List<Student> studentList);

}
