package com.web.study.controller.lecture;

import com.web.study.dto.request.lecture.LecturerReqDto;
import com.web.study.dto.response.DataResponseDto;
import com.web.study.dto.response.ResponseDto;
import com.web.study.service.LecturerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LecturerController {

    private final LecturerService lecturerService;

    @PostMapping("/lecturer")
    public ResponseEntity<? extends ResponseDto> saveLecturer(@RequestBody LecturerReqDto lecturerReqDto) {
        lecturerService.saveLecturer(lecturerReqDto);
        return ResponseEntity.ok().body(ResponseDto.ofDefault());
    }

    @GetMapping("/lecturers")
    public ResponseEntity<? extends ResponseDto> getLecturers() {
        return ResponseEntity.ok().body(DataResponseDto.of(lecturerService.getLecturerAll()));
    }

    @GetMapping("/lecturer/{id}")
    public ResponseEntity<? extends ResponseDto> getLecturerById(@PathVariable int id){
        log.info("id : {}", lecturerService.findLecturerById(id));
        return ResponseEntity.ok().body(DataResponseDto.of(lecturerService.findLecturerById(id)));
    }
}
