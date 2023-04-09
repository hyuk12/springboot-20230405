package com.web.study.dto.request.lecture;


import com.web.study.domain.entity.LectureRegistry;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Builder
@Setter
public class LectureRegistryReqDto {
    private String lectureName;
    private String studentName;

    public LectureRegistry toEntity(int lectureId, int studentId){
        return LectureRegistry.builder()
                .lecture_id(lectureId)
                .student_id(studentId)
                .register_date(LocalDate.now())
                .build();
    }
}
