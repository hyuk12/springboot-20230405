package com.web.study.dto.request.lecture;

import com.web.study.domain.entity.Student;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@ToString
public class StudentReqDto {
    private String name;
    private LocalDate birthDate;

    public Student toEntity() {
        return Student.builder()
                .name(name)
                .birth_date(birthDate)
                .build();

    }
}