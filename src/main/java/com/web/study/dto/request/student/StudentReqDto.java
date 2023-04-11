package com.web.study.dto.request.student;

import com.web.study.domain.entity.Student;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class StudentReqDto {
    private String name;
    private LocalDate birthDate;

    public Student toEntity() {
        return Student.builder()
                .sdm_name(name)
                .sdm_birth(birthDate)
                .build();

    }
}
