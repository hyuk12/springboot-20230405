package com.web.study.domain.entity;

import com.web.study.dto.response.CourseRespDto;
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

    public CourseRespDto toDto() {
        String lectureName =  null;
        int lecturePrice = 0;
        String instructorName = null;
        String studentName = null;

        if(lecture != null) {
            lectureName = lecture.getLtm_name();
            lecturePrice = lecture.getLtm_price();
            if(lecture.getInstructor() != null) {
                instructorName = lecture.getInstructor().getItm_name();
            }
        }

        if (student != null) {
            studentName = student.getSdm_name();
        }

        if (lecture == null || student == null){
            return null;
        }
        return CourseRespDto.builder()
                .courseId(csm_id)
                .registerDate(register_date)
                .lectureName(lectureName)
                .lecturePrice(lecturePrice)
                .instructorName(instructorName)
                .studentName(studentName)
                .build();
    }
}
