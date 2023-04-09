package com.web.study.controller.lecture;

import com.web.study.dto.request.lecture.LectureRegistryReqDto;
import com.web.study.dto.request.lecture.LectureReqDto;
import com.web.study.dto.request.lecture.LecturerReqDto;
import com.web.study.dto.request.lecture.StudentReqDto;
import com.web.study.dto.response.DataResponseDto;
import com.web.study.dto.response.ErrorResponseDto;
import com.web.study.dto.response.ResponseDto;
import com.web.study.exception.DuplicatedNameException;
import com.web.study.service.LectureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
public class LectureController {

    private final LectureService lectureService;

    // Create
    @PostMapping("/lecture")
    public ResponseEntity<? extends ResponseDto> register(@RequestBody LectureReqDto lectureReqDto) {
        try {
            lectureService.registerLecture(lectureReqDto);
            return ResponseEntity.ok().body(ResponseDto.ofDefault());
        }catch (DuplicatedNameException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ResponseDto.ofDuplicate("Duplicate lecture name"));
        }
    }

    @PostMapping("/students")
    public ResponseEntity<? extends ResponseDto> saveStudent(@RequestBody StudentReqDto studentReqDto) {
        try {
            lectureService.saveStudent(studentReqDto);
            return ResponseEntity.ok().body(ResponseDto.ofDefault());
        } catch (DuplicatedNameException e) {
            // Handle the case where the student name is duplicated
            // You may want to return an appropriate error response
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ResponseDto.ofDuplicate("Duplicate student name"));
        }
    }

    @PostMapping("/lecturers")
    public ResponseEntity<? extends ResponseDto> saveLecturer(@RequestBody LecturerReqDto lecturerReqDto) {
        lectureService.saveLecturer(lecturerReqDto);
        return ResponseEntity.ok().body(ResponseDto.ofDefault());
    }

    @PostMapping("/lecture/students/lectures")
    public ResponseEntity<? extends ResponseDto> saveLecture(@RequestBody LectureRegistryReqDto lectureRegistryReqDto) {
        lectureService.saveLectureRegistry(lectureRegistryReqDto);
        return ResponseEntity.ok().body(ResponseDto.ofDefault());
    }

    // Read
    @GetMapping("/lecture/{id}")
    public ResponseEntity<? extends ResponseDto> get() {
        return ResponseEntity.ok().body(ResponseDto.ofDefault());
    }

    // Update
    @PutMapping()
    public ResponseEntity<? extends ResponseDto> modify() {
        return ResponseEntity.ok().body(ResponseDto.ofDefault());
    }

    // Delete
    @DeleteMapping()
    public ResponseEntity<? extends ResponseDto> remove() {
        return ResponseEntity.ok().body(ResponseDto.ofDefault());
    }
}
