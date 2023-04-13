package com.web.study.controller.auth;

import com.web.study.dto.request.auth.LoginReqDto;
import com.web.study.dto.request.auth.SaveUserReqDto;
import com.web.study.dto.response.DataResponseDto;
import com.web.study.dto.response.ResponseDto;
import com.web.study.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/register")
    public ResponseEntity<? extends ResponseDto> save(@RequestBody SaveUserReqDto saveUserReqDto) {
        authService.duplicatedUsername(saveUserReqDto);
        authService.saveUser(saveUserReqDto);
        return ResponseEntity.ok().body(ResponseDto.ofDefault());
    }

    @PostMapping("/auth/login")
    public ResponseEntity<? extends ResponseDto> login(@RequestBody LoginReqDto loginReqDto) {
        return ResponseEntity.ok().body(DataResponseDto.of(authService.login(loginReqDto)));
    }
}
