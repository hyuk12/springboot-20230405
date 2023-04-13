package com.web.study.service;

import com.web.study.domain.entity.user.Authority;
import com.web.study.domain.entity.user.User;
import com.web.study.dto.request.auth.LoginReqDto;
import com.web.study.dto.request.auth.SaveUserReqDto;
import com.web.study.dto.response.auth.JwtTokenRespDto;
import com.web.study.exception.CustomException;
import com.web.study.repository.UserRepository;
import com.web.study.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void saveUser(SaveUserReqDto saveUserReqDto) {
        User userEntity = saveUserReqDto.toEntity();
        userRepository.saveUser(userEntity);

        List<Authority> authorities = new ArrayList<>();
        authorities.add(Authority.builder()
                        .user_id(userEntity.getUser_id())
                        .role_id(1)
                        .build());

        userRepository.addAuthorities(authorities);
    }

    @Override
    public void duplicatedUsername(SaveUserReqDto saveUserReqDto) {
        User userEntity = userRepository.findUserByUsername(saveUserReqDto.getUsername());

        if(userEntity != null) {
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("username", "이미 사용중인 사용자 이름입니다.");

            throw new CustomException("duplicate error", errorMap);
        }
    }

    @Override
    public JwtTokenRespDto login(LoginReqDto loginReqDto) {

        // security 가 알아볼 수 있도록 변환 해주는 라이브러리 사용
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginReqDto.getUsername(), loginReqDto.getPassword());

        // authenticationManager 를 통해 authenticationToken 을 검증 (security 에서 제공하는 기능)
        // UserDetailsService 를 통해 DB 에서 사용자 정보를 가져옴 loadUserByUsername() 메소드 실행
        // 클라이언트 에서 받아온 loginReqDto 와 DB 에서 가져온 userEntity 를 비교해서 일치하면 authentication 객체를 만들어 줌
        // authentication 이 null 이면 인증 실패 만들어 지면 인증 성공
        Authentication authentication = authenticationManager.getObject().authenticate(authenticationToken);

        return jwtTokenProvider.createToken(authentication);
    }
}
