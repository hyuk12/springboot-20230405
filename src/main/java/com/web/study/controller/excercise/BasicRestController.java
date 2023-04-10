package com.web.study.controller.excercise;


import com.web.study.dto.request.BasicTestDto;
import com.web.study.dto.response.DataResponseDto;
import com.web.study.dto.response.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class BasicRestController {

    // GET 요청의 Param 을 처리 하는 방법
    @GetMapping("/read")
    public ResponseEntity<? extends ResponseDto> read  (BasicTestDto basicTestDto) {

        String userInfo = basicTestDto.getName() + "(" + basicTestDto.getAge() + ")";
        return ResponseEntity.ok().body(DataResponseDto.of(userInfo));
    }

    @GetMapping("/read2/{id}")
    public ResponseEntity<? extends ResponseDto> read2(@PathVariable int id) {
        Map<Integer, String> userMap = new HashMap<>();

        userMap.put(1, "홍길동");
        userMap.put(2, "홍길이");
        userMap.put(3, "홍길삼");
        userMap.put(4, "홍길사");
        userMap.put(5, "홍길오");

        return ResponseEntity.ok().body(DataResponseDto.of(userMap.get(id)));
    }

    // json 데이터를 받기 위해서 @RequestBody 사용 /  x-www-form-urlencoded 으로 받기 위해선 없는체로 받아야한다.
    @PostMapping("/create")
    public ResponseEntity<? extends ResponseDto> create(@RequestBody BasicTestDto basicTestDto) {
        System.out.println("data added");
        return ResponseEntity.created(null).body(DataResponseDto.of(basicTestDto));
    }
}
