package com.web.study.service;

import com.web.study.domain.entity.Course;
import com.web.study.dto.request.lecture.CourseReqDto;
import com.web.study.dto.response.CourseRespDto;

import java.util.List;

public interface CourseService {

    public void saveCourse(CourseReqDto courseReqDto);
    public List<CourseRespDto> getCourseAll();
    public List<CourseRespDto> searchCourse(int type, String searchValue);
}
