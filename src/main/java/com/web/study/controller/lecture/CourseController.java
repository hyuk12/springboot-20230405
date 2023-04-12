package com.web.study.controller.lecture;

import com.web.study.aop.annotation.ParamsAspect;
import com.web.study.aop.annotation.ValidAspect;
import com.web.study.dto.request.course.CourseReqDto;
import com.web.study.dto.request.course.SearchCourseReqDto;
import com.web.study.dto.response.DataResponseDto;
import com.web.study.dto.response.ResponseDto;
import com.web.study.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;


    @PostMapping("/course")
    public ResponseEntity<? extends ResponseDto> saveLecture(@RequestBody CourseReqDto courseReqDto) {
        courseService.saveCourse(courseReqDto);
        return ResponseEntity.ok().body(ResponseDto.ofDefault());
    }


    @GetMapping("/courses")
    public ResponseEntity<? extends ResponseDto> getCourseAll() {
        return ResponseEntity.ok().body(DataResponseDto.of(courseService.getCourseAll()));
    }

    @ValidAspect
    @ParamsAspect
    @GetMapping("/search/courses")
    public ResponseEntity<? extends ResponseDto> getSearchCourse(@Valid SearchCourseReqDto searchCourseReqDto, BindingResult bindingResult) {
        return ResponseEntity.ok().body(DataResponseDto.of(courseService.searchCourse(searchCourseReqDto)));
    }
}
