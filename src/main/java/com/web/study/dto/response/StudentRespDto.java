package com.web.study.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class StudentRespDto {
    private int id;
    private String name;
    private LocalDate birthDate;
}
