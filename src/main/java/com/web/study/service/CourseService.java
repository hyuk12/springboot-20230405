package com.web.study.service;

import com.web.study.domain.entity.Course;
import com.web.study.dto.request.lecture.CourseReqDto;

import java.util.List;

public interface CourseService {

    public void saveCourse(CourseReqDto courseReqDto);
    public List<Course> getCourseAll();
    public List<Course> searchCourse(int type, String searchValue);
}
