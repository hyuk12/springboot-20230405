package com.web.study.domain.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int csm_id;
    private int ltm_id;
    private int sdm_id;
    private LocalDate register_date;
    private Lecture lecture;
    private Student student;
}
