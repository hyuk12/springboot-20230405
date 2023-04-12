package com.web.study.domain.entity;

import com.web.study.dto.response.LectureRespDto;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Lecture {
    private int ltm_id;
    private String ltm_name;
    private int ltm_price;
    private int itm_id;
    private Instructor instructor;

    public LectureRespDto toDto() {

        String instructorName = null;
        int itmId = 0;

        if(instructor != null) {
            instructorName = instructor.getItm_name();
            itmId = instructor.getItm_id();
        }

        return LectureRespDto.builder()
                .id(ltm_id)
                .lectureName(ltm_name)
                .lecturePrice(ltm_price)
                .itmId(itm_id)
                .instructorName(instructor.getItm_name())
                .build();
    }
}
