package com.web.study.controller.advice;

import com.web.study.dto.response.ErrorResponseDto;
import com.web.study.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ApiControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponseDto> handleException(CustomException e) {
        return ResponseEntity.badRequest().body(ErrorResponseDto.of(HttpStatus.BAD_REQUEST,e,e.getErrorMap()));
    }
}
