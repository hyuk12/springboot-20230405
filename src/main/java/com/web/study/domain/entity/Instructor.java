package com.web.study.domain.entity;

import com.web.study.dto.response.InstructorRespDto;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Instructor {
    private int itm_id;
    private String itm_name;
    private LocalDate itm_birth;

    public InstructorRespDto toDto() {
        return InstructorRespDto.builder()
                .id(itm_id)
                .name(itm_name)
                .birthDate(itm_birth)
                .build();
    }
}
