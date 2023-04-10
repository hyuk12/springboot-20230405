package com.web.study.repository;

import com.web.study.domain.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseRepository {
    public void saveCourse(Course course);
    public List<Course> getCourseAll();
}
