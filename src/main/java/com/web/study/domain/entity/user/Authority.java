package com.web.study.domain.entity.user;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
public class Authority {
    private int authority_id;
    private int user_id;
    private int role_id;

    private Role role;
}
