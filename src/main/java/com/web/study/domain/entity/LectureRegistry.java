package com.web.study.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Builder
@ToString
public class LectureRegistry {
    private int id;
    private int lecture_id;
    private int student_id;
    private LocalDate register_date;
}
