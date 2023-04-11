package com.web.study.dto.request.lecture;


import com.web.study.domain.entity.Course;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Builder
@Setter
public class CourseReqDto {
    private int lectureId;
    private int studentId;

    public Course toEntity(){
        return Course.builder()
                .ltm_id(lectureId)
                .sdm_id(studentId)
                .register_date(LocalDate.now())
                .build();
    }
}
