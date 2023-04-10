package com.web.study.repository;

import com.web.study.domain.entity.Lecture;
import com.web.study.domain.entity.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LectureRepository {
    public void register(Lecture lecture);
    public Lecture findLectureByName(String lectureName);
}
