package com.example.restfulwebservice.exception;

//모든 컴포넌트에서 사용 가능한 일반화된 예외처리를 위한 자바 객체

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
}
