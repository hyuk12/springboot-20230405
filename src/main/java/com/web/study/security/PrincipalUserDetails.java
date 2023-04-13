package com.web.study.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public class PrincipalUserDetails implements UserDetails {

    private int userId;
    private String username;
    private String password;
    private List<String> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    // 사용기간 만료 기본값 false 하나라도 false 이면 로그인 불가
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정 잠김 기본값 false
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    // 비밀번호 5회 틀렸을 때 기본값 false
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    // 계정 비활성화 상태 (이메일 인증을 완료해야하거나, 전화번호 인증을 하지 않았을 때) 기본값 false 인증이 완료되면 true 로 풀어주는 식
    @Override
    public boolean isEnabled() {
        return true;
    }
}
