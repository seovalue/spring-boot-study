package com.example.restfulwebservice.user;


// DAO란?
/*
* Data Access Object의 약자
* DB를 사용해 데이터를 조회하거나 조작하는 기능을 전담하도록 만든 오브젝트
* */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;
    static {
        users.add(new User(1,"Minjeong", new Date()));
        users.add(new User(2,"Seungjae", new Date()));
        users.add(new User(3,"Yeongsook", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        for (User user: users){
            if (user.getId() == id){
                return user;
            }
        }
        return null; // for문을 다 돌아도 일치하는 유저가 없는 경우
    }

    public User save(User user){
        if (user.getId() == null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }
}