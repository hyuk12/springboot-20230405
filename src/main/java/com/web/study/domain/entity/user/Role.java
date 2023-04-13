package com.web.study.domain.entity.user;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
public class Role {
    private int role_id;
    private String role_name;
}
