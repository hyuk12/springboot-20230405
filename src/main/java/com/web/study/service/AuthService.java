package com.web.study.service;

import com.web.study.dto.request.auth.LoginReqDto;
import com.web.study.dto.request.auth.SaveUserReqDto;
import com.web.study.dto.response.auth.JwtTokenRespDto;

public interface AuthService {

    public void saveUser(SaveUserReqDto saveUserReqDto);
    public void duplicatedUsername(SaveUserReqDto saveUserReqDto);

    public JwtTokenRespDto login(LoginReqDto loginReqDto);
}
