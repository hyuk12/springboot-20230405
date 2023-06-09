package com.web.study.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class InstructorRespDto {
    private int id;
    private String name;
    private LocalDate birthDate;
}
