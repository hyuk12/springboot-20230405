package com.web.study.domain.entity.user;

import com.web.study.security.PrincipalUserDetails;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class User {
    private int user_id;
    private String username;
    private String password;
    private String name;
    private String email;

    private List<Authority> authorities;

    public PrincipalUserDetails toPrincipal() {

//        List<String> roles1 = new ArrayList<String>();
//        for(Authority authority : authorities) {
//            roles1.add(authority.getRole().getRole_name());
//        }

        List<String> roles = authorities.stream()
                .map(Authority::getRole)
                .map(Role::getRole_name)
                .collect(Collectors.toList());

        return PrincipalUserDetails.builder()
                .userId(user_id)
                .username(username)
                .password(password)
                .roles(roles)
                .build();
    }
}
