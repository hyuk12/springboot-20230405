package com.web.study.repository;

import com.web.study.domain.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentRepository {

    public void saveStudent(Student student);
    public List<Student> getStudentAll();
    public Student findStudentById(int id);
    public Student findStudentByName(String studentName);
}
