package com.web.study.dto.request.Instructor;

import com.web.study.domain.entity.Instructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@ToString
public class InstructorReqDto {
    private String name;
    private LocalDate birthDate;

    public Instructor toEntity() {
        return Instructor.builder()
                .itm_name(name)
                .itm_birth(birthDate)
                .build();
    }
}
