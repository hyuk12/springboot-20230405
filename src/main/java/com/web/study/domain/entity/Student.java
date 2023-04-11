package com.web.study.domain.entity;

import com.web.study.dto.response.StudentRespDto;
import lombok.*;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int sdm_id;
    private String sdm_name;
    private LocalDate sdm_birth;

    public StudentRespDto toDto() {
        return StudentRespDto.builder()
                .id(sdm_id)
                .name(sdm_name)
                .birthDate(sdm_birth)
                .build();
    }
}
