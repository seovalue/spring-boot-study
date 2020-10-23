package com.example.restfulwebservice.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserDaoService service;

    // 의존성 주입의 방법으로 생성
    public UserController(UserDaoService service){
        this.service = service;
    }

    // 사용자 전체 목록 조회
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    // 특정 사용자 조회
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return service.findOne(id);
    }
}
