package com.web.study.dto.request.auth;

import com.web.study.domain.entity.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter @Setter
@ToString
public class SaveUserReqDto {
    private String username;
    private String password;
    private String name;
    private String email;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(new BCryptPasswordEncoder().encode(password))
                .name(name)
                .email(email)
                .build();
    }
}
