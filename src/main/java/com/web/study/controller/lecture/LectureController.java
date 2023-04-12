package com.web.study.controller.lecture;

import com.web.study.aop.annotation.TimerAspect;
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
        lectureService.registerLecture(lectureReqDto);
        return ResponseEntity.ok().body(ResponseDto.ofDefault());
    }

    @TimerAspect
    @GetMapping("/lectures")
    public ResponseEntity<? extends ResponseDto> getLectureAll() {
        return ResponseEntity.ok().body(DataResponseDto.of(lectureService.getLectureAll()));
    }

    // Read
    @TimerAspect
    @GetMapping("/search/lectures")
    public ResponseEntity<? extends ResponseDto> getLecture(int type, String searchValue) {
        return ResponseEntity.ok().body(DataResponseDto.of(lectureService.getLectureBySearch(type, searchValue)));
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
