package com.web.study.service;

import com.web.study.domain.entity.Course;
import com.web.study.domain.entity.Lecture;
import com.web.study.domain.entity.Student;
import com.web.study.dto.request.lecture.CourseReqDto;
import com.web.study.dto.response.CourseRespDto;
import com.web.study.repository.CourseRepository;
import com.web.study.repository.LectureRepository;
import com.web.study.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    @Override
    public void saveCourse(CourseReqDto courseReqDto) {
        Course course = courseReqDto.toEntity();
        courseRepository.saveCourse(course);
    }

    @Override
    public List<CourseRespDto> getCourseAll() {
        List<CourseRespDto> dtos = new ArrayList<>();
        courseRepository.getCourseAll().forEach(course -> {
            dtos.add(course.toDto());
        });
        return dtos;
    }

    @Override
    public List<CourseRespDto> searchCourse(int type, String searchValue) {
        List<CourseRespDto> dtos = new ArrayList<>();
        Map<String, Object> parameterMap = Map.of("type", type, "searchValue", searchValue);

        courseRepository.searchCourse(parameterMap).forEach(course -> {
            dtos.add(course.toDto());
        });
        return dtos;
    }
}
