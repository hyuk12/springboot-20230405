package com.web.study.dto.request.lecture;

import com.web.study.domain.entity.Lecturer;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@ToString
public class LecturerReqDto {
    private String name;
    private LocalDate birthDate;

    public Lecturer toEntity() {
        return Lecturer.builder()
                .name(name)
                .birth_date(birthDate)
                .build();
    }
}
