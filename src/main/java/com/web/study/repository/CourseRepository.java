package com.web.study.repository;

import com.web.study.domain.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface CourseRepository {
    public void saveCourse(Course course);
    public List<Course> getCourseAll();
    public List<Course> searchCourse(Map<String, Object> parameterMap);
}
