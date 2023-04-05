package com.web.study.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class DataResponseDto<T> extends ResponseDto {

    private final T data;

    private DataResponseDto(T data) {
        super(true, HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        this.data = data;
    }

    private DataResponseDto(T data, String message) {
        super(true, HttpStatus.OK.value(), message);
        this.data = data;
    }

    public static <T> DataResponseDto<T> of(T data) {
        return new DataResponseDto<T>(data);
    }

    public static <T> DataResponseDto<T> of(T data, String message) {
        return new DataResponseDto<T>(data, message);
    }

    public static <T> DataResponseDto<T> empty() {
        return new DataResponseDto<T>(null);
    }
}
