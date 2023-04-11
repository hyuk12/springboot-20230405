package com.web.study.domain.entity;

import com.web.study.dto.response.LectureRespDto;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Lecture {
    private int ltm_id;
    private String ltm_name;
    private int ltm_price;
    private int itm_id;
    private Instructor instructor;

    public LectureRespDto toDto() {
        return LectureRespDto.builder()
                .id(ltm_id)
                .lectureName(ltm_name)
                .lecturePrice(ltm_price)
                .itmId(itm_id)
                .build();
    }
}
