package com.web.study.domain.entity;

import com.web.study.dto.response.LecturerRespDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@Getter
@ToString
public class Lecturer {
    private int id;
    private String name;
    private LocalDate birth_date;

    public LecturerRespDto toDto() {
        return LecturerRespDto.builder()
                .id(id)
                .name(name)
                .birthDate(birth_date)
                .build();
    }
}
