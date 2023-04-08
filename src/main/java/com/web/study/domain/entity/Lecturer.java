package com.web.study.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@Getter @ToString
public class Lecturer {
    private int id;
    private String name;
    private LocalDate birth_date;
}
