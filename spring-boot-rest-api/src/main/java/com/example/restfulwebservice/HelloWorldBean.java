package com.example.restfulwebservice;

import lombok.AllArgsConstructor;
import lombok.Data;

// lombok, 자동생성으로 getter setter 가능
@Data //HelloWorldBean이 가진 모든 property가 만들어짐.
@AllArgsConstructor //모든 argument를 가진 Constructor가 만들어짐.

public class HelloWorldBean {
    private String message;

}
