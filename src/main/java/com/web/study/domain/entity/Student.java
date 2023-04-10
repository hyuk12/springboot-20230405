package com.web.study.domain.entity;

import com.web.study.dto.response.StudentRespDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;

@Getter
@Builder
@ToString

public class Student {
    private int id;
    private String name;
    private LocalDate birth_date;

    public StudentRespDto toDto() {
        return StudentRespDto.builder()
                .id(id)
                .name(name)
                .birthDate(birth_date)
                .build();
    }
}
