package com.web.study.repository;

import com.web.study.domain.entity.Lecture;
import com.web.study.domain.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LectureRepository {
    public void register(Lecture lecture);
    public List<Lecture> getLectureAll();
    public Lecture findLectureById(int id);
    public Lecture findLectureByName(String lectureName);
}
