package com.web.study.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data // jackson 으로 자동 변환하려면 getter 와 setter  가 필요하다
@RequiredArgsConstructor
public class ResponseDto {
    private final boolean success;
    private final int code;
    private final String message;

    public static ResponseDto ofDefault() {
        return new ResponseDto (true, 200, "Successfully");
    }
    public static ResponseDto ofDuplicate(String message) {
        return new ResponseDto (false, 409, message);
    }

    public static ResponseDto of(boolean success, int code, String message) {
        return new ResponseDto (success, code, message);
    }
}
