package com.web.study.dto.request.course;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter @Setter
@ToString
public class SearchCourseReqDto {

    @Min(value = 1, message = "type 은 1 이상의 값이어야 합니다.")
    @Max(value = 3, message = "type 은 3 이하의 값이어야 합니다.")
    private int type;

    @NotBlank(message = "검색어를 입력해주세요.")
    private String searchValue;
}
