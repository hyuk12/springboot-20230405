package com.web.study.service;

import com.web.study.aop.annotation.CheckNameAspect;
import com.web.study.aop.annotation.ReturnDataAspect;
import com.web.study.aop.annotation.TimerAspect;
import com.web.study.dto.request.course.CourseReqDto;
import com.web.study.dto.request.course.SearchCourseReqDto;
import com.web.study.dto.response.CourseRespDto;
import com.web.study.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    @CheckNameAspect
    @Override
    public void saveCourse(CourseReqDto courseReqDto) {
        courseRepository.saveCourse(courseReqDto.toEntity());
    }

    @TimerAspect
    @Override
    public List<CourseRespDto> getCourseAll() {

        List<CourseRespDto> dtos = new ArrayList<>();
        courseRepository.getCourseAll().forEach(course -> {
            dtos.add(course.toDto());
        });

        return dtos;
    }

    @ReturnDataAspect
    @Override
    public List<CourseRespDto> searchCourse(SearchCourseReqDto searchCourseReqDto) {
        List<CourseRespDto> dtos = new ArrayList<>();
        Map<String, Object> parameterMap = Map.of("type", searchCourseReqDto.getType(), "searchValue", searchCourseReqDto.getSearchValue());

        courseRepository.searchCourse(parameterMap).forEach(course -> {
            dtos.add(course.toDto());
        });
        return dtos;
    }
}
