package com.web.study.service;

import com.web.study.domain.entity.Course;
import com.web.study.domain.entity.Lecture;
import com.web.study.domain.entity.Student;
import com.web.study.dto.request.lecture.CourseReqDto;
import com.web.study.repository.CourseRepository;
import com.web.study.repository.LectureRepository;
import com.web.study.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public List<Course> getCourseAll() {
        return courseRepository.getCourseAll();
    }

    @Override
    public List<Course> searchCourse(int type, String searchValue) {
        Map<String, Object> parameterMap = Map.of("type", type, "searchValue", searchValue);
        return courseRepository.searchCourse(parameterMap);
    }
}
