package com.web.study.dto.request.lecture;

import com.web.study.domain.entity.Lecture;
import com.web.study.domain.entity.LectureRegistry;
import com.web.study.domain.entity.Student;
import lombok.Setter;

import java.time.LocalDate;

@Setter
public class LectureRegistryReqDto {
    private Lecture lecture;
    private Student student;

    public LectureRegistry toEntity(){
        return LectureRegistry.builder()
                .lecture_id(lecture.getId())
                .student_id(student.getId())
                .register_date(LocalDate.now())
                .build();
    }
}
