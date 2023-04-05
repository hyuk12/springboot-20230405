package com.web.study.controller;

import com.web.study.dto.response.DataResponseDto;
import com.web.study.dto.response.ErrorResponseDto;
import com.web.study.dto.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BasicController {

    // string 자료형 이외에 모두 json 임.

    @GetMapping("/view/test")
    public ResponseEntity<? extends ResponseDto> view() {

        List<String> strList = new ArrayList<String>();
        strList.add("a");
        strList.add("b");
        strList.add("c");
        strList.add("d");
        strList.add("e");

        if(strList.contains("e")) {
            try {
                throw new RuntimeException();
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body(ErrorResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, e));
            }
        }

        return ResponseEntity.ok(DataResponseDto.of(strList));
    }
}

