package com.web.study.dto.response;

import com.web.study.domain.entity.Lecture;
import com.web.study.domain.entity.Student;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class CourseRespDto {
    private int courseId;
    private LocalDate registerDate;
    private String lectureName;
    private int lecturePrice;
    private String instructorName;
    private String studentName;
}
