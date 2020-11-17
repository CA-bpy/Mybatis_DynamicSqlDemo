package com.ca_bpy;

import com.ca_bpy.dao.IStudentDao;
import com.ca_bpy.domain.Student;

import com.ca_bpy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *  Unit test
 *  Test select method.
 *  Test insert method.
 */
public class TestDemo {
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);

    //测试selectObject方法
    //测试动态SQL <if>标签
    @Test
    public void testSelectObjectIf() {
        Student student = new Student();
        student.setName("张三");
        student.setAge(22);
        List<Student> studentList =studentDao.selectStudentsObjectIf(student);
        System.out.println("查询表的内容结果如下：");
        for(Student students:studentList) {
            System.out.println(students);
        }
    }

    //测试动态SQL <where>标签
    @Test
    public void testSelectObjectWhere() {
        Student student = new Student();
//        student.setName("张三");
        student.setAge(22);
        List<Student> studentList =studentDao.selectStudentsObjectWhere(student);
        System.out.println("查询表的内容结果如下：");
        for(Student students:studentList) {
            System.out.println(students);
        }
    }

    //测试动态SQL <where>标签
    @Test
    public void testSelectObjectForeach() {
        List<Student> list = new ArrayList<>();
        Student stu = new Student();
        stu.setId(10002);
        list.add(stu);
        stu = new Student();
        stu.setId(10005);
        list.add(stu);
        List<Student> studentList =studentDao.selectStudentsObjectForeach(list);
        System.out.println("查询表的内容结果如下：");
        for(Student students:studentList) {
            System.out.println(students);
        }
    }
}
