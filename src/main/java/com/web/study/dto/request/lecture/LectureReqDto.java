package com.web.study.dto.request.lecture;

import com.web.study.domain.entity.Lecture;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class LectureReqDto {
    private String lectureName;
    private int lecturePrice;
    private int itmId;

    public Lecture toEntity(){

        return Lecture.builder()
                .ltm_name(lectureName)
                .ltm_price(lecturePrice)
                .itm_id(itmId)
                .build();
    }
}
