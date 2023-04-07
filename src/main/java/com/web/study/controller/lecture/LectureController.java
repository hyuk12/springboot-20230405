package com.web.study.controller.lecture;

import com.web.study.dto.request.lecture.LectureReqDto;
import com.web.study.dto.response.DataResponseDto;
import com.web.study.dto.response.ResponseDto;
import com.web.study.service.LectureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
//        log.info("lecture register: {}", lectureReqDto);
        lectureService.registerLecture(lectureReqDto);
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
