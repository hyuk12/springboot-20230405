package com.web.study.controller;

import com.web.study.dto.request.UserAdditionDto;
import com.web.study.dto.response.DataResponseDto;
import com.web.study.dto.response.ErrorResponseDto;
import com.web.study.dto.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class UserStore {
    public static Map<Integer, UserAdditionDto> userMap = new HashMap<>();
}

@RestController
public class UserRestController {

    @GetMapping("/api/user/{id}")
    public ResponseEntity<? extends ResponseDto> getUser(@PathVariable int id) {

        Map<Integer, UserAdditionDto> userMap = UserStore.userMap;

        try {
            if (!userMap.containsKey(id)) {
                throw new RuntimeException("존재하지 않는 id 입니다.");
            }
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(ErrorResponseDto.of(HttpStatus.BAD_REQUEST, e));
        };
        return ResponseEntity.ok().body(DataResponseDto.of(userMap.get(id)));
    }

    @GetMapping("/api/users")
    public ResponseEntity<? extends ResponseDto> getUsers() {
        return ResponseEntity.ok().body(DataResponseDto.of(new ArrayList<>(UserStore.userMap.values())));
    }

    @PostMapping("/api/user/addition")
    public ResponseEntity< ? extends ResponseDto> addUserPost(@RequestBody UserAdditionDto userAdditionDto) {
        Map<Integer, UserAdditionDto> userMap = UserStore.userMap;
        int maxKey = 0;
        if(!userMap.keySet().isEmpty()) {
            maxKey = Collections.max(userMap.keySet());
        }

        userMap.put(maxKey + 1, userAdditionDto);
        return ResponseEntity.created(null).body(DataResponseDto.of(userAdditionDto));
    }

}
