package com.example.restfulwebservice.helloworld;

import com.example.restfulwebservice.helloworld.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController //Rest api를 위해서는 RestController annotation 사용
public class HelloWorldController {
    @Autowired //annotation을 통한 의존성 주입
    private MessageSource messageSource;
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

    @GetMapping("/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s",name));
    }

    @GetMapping("/hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required = false) Locale locale){
        return messageSource.getMessage("greeting.message", null, locale);
    }

}
