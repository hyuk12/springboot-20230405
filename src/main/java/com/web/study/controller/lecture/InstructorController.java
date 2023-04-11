package com.web.study.controller.lecture;

import com.web.study.dto.request.lecture.InstructorReqDto;
import com.web.study.dto.response.DataResponseDto;
import com.web.study.dto.response.ResponseDto;
import com.web.study.service.InstructorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @PostMapping("/instructor")
    public ResponseEntity<? extends ResponseDto> registerInstructor(@RequestBody InstructorReqDto instructorReqDto) {
        instructorService.registerInstructor(instructorReqDto);
        return ResponseEntity.ok().body(ResponseDto.ofDefault());
    }

    @GetMapping("/instructors")
    public ResponseEntity<? extends ResponseDto> getInstructorAll() {
        return ResponseEntity.ok().body(DataResponseDto.of(instructorService.getInstructorAll()));
    }

    @GetMapping("/instructor/{id}")
    public ResponseEntity<? extends ResponseDto> findInstructorById(@PathVariable int id){
        log.info("id : {}", instructorService.findInstructorById(id));
        return ResponseEntity.ok().body(DataResponseDto.of(instructorService.findInstructorById(id)));
    }
}
