package com.web.study.repository;

import com.web.study.domain.entity.Lecture;
import com.web.study.domain.entity.LectureRegistry;
import com.web.study.domain.entity.Lecturer;
import com.web.study.domain.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LectureRepository {

    public void saveLecturer(Lecturer lecturer);
    public void saveStudent(Student student);
    public void register(Lecture lecture);


    public void saveLectureRegistry(LectureRegistry lectureRegistry);
    public Lecture findLectureByName(String lectureName);
    public Student findStudentByName(String studentName);

//    int getStudentId(String name);
//    int getLectureId(String name);
//    void registerLectureRegistry(Lecture lecture);
}
