package com.web.study.controller.lecture;

import com.web.study.dto.request.lecture.CourseReqDto;
import com.web.study.dto.response.DataResponseDto;
import com.web.study.dto.response.ResponseDto;
import com.web.study.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/course")
    public ResponseEntity<? extends ResponseDto> saveLecture(@RequestBody CourseReqDto courseReqDto) {
        courseService.saveCourse(courseReqDto);
        return ResponseEntity.ok().body(ResponseDto.ofDefault());
    }

    @GetMapping("/course/all")
    public ResponseEntity<? extends ResponseDto> getCourseAll() {
        return ResponseEntity.ok().body(DataResponseDto.of(courseService.getCourseAll()));
    }

    @GetMapping("/search/courses")
    public ResponseEntity<? extends ResponseDto> searchCourse(int type, String searchValue) {
        return ResponseEntity.ok().body(DataResponseDto.of(courseService.searchCourse(type, searchValue)));
    }
}
