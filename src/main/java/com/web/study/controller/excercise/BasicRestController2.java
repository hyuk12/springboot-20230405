package com.web.study.controller.excercise;

import com.web.study.dto.request.BasicTestDto2;
import com.web.study.dto.response.DataResponseDto;
import com.web.study.dto.response.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BasicRestController2 {

    @GetMapping("/search")
    public ResponseEntity<? extends ResponseDto> search(String name) {
        return ResponseEntity.ok().body(DataResponseDto.of(name));
    }

    @GetMapping("/search/all")
    public ResponseEntity<? extends ResponseDto> search(String name, int age) {
        String userInfo = name + "(" + age + ")";
        return ResponseEntity.ok().body(DataResponseDto.of(userInfo));
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<? extends ResponseDto> search(@PathVariable int id) {

        List<BasicTestDto2> basicTestDto = new ArrayList<>();

        basicTestDto.add(new BasicTestDto2(1, "홍길동", 31, "부산시 부산진구"));
        basicTestDto.add(new BasicTestDto2(2, "홍길이", 32, "부산시 사상"));
        basicTestDto.add(new BasicTestDto2(3, "홍길삼", 33, "부산시 덕천"));
        basicTestDto.add(new BasicTestDto2(4, "홍길사", 34, "부산시 덕포"));

        return ResponseEntity.ok().body(DataResponseDto.of(basicTestDto.get(id - 1)));
    }

    @PostMapping("/save")
    public ResponseEntity<? extends ResponseDto> save(BasicTestDto2 basicTestDto) {
        return ResponseEntity.created(null).body(DataResponseDto.of(basicTestDto));
    }

    @PostMapping("/save/json")
    public ResponseEntity<? extends ResponseDto> saveJson(@RequestBody BasicTestDto2 basicTestDto) {
        return ResponseEntity.created(null).body(DataResponseDto.of(basicTestDto));
    }
}
