package com.web.study.controller.lecture;

import com.web.study.aop.annotation.TimerAspect;
import com.web.study.dto.request.student.StudentReqDto;
import com.web.study.dto.response.DataResponseDto;
import com.web.study.dto.response.ResponseDto;
import com.web.study.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<? extends ResponseDto> registerStudent(@RequestBody StudentReqDto studentReqDto) {
        studentService.saveStudent(studentReqDto);
        return  ResponseEntity.ok().body(ResponseDto.ofDefault());
    }

    @TimerAspect
    @GetMapping("/students")
    public ResponseEntity<? extends ResponseDto> getStudentAll() {
        return ResponseEntity.ok().body(DataResponseDto.of(studentService.getStudentAll()));
    }

    @TimerAspect
    @GetMapping("/student/{id}")
    public ResponseEntity<? extends ResponseDto> findStudentById(@PathVariable int id) {
        return ResponseEntity.ok().body(DataResponseDto.of(studentService.findStudentById(id)));
    }
}
