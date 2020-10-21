package com.example.restfulwebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Rest api를 위해서는 RestController annotation 사용
public class HelloWorldController {
    // GET
    // /hello-world (endpoint)
    /*
    * 사용자 요청이 /hello-world 라는 엔드포인트로 전송된다면
    * "Hello World"라는 문구를 화면에 반환시켜준다.
    * */
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World"); //java bean 형태로 반환 -> json 형태로 반환하게 됨.
    }

}
