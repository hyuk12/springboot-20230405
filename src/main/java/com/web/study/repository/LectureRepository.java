package com.web.study.repository;

import com.web.study.domain.entity.Lecture;
import com.web.study.domain.entity.Lecturer;
import com.web.study.domain.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LectureRepository {
    public int register(Lecture lecture);
    public int saveStudent(Student student);
    public int saveLecturer(Lecturer lecturer);

}
