package com.example.restfulwebservice.user;


// DAO란?
/*
* Data Access Object의 약자
* DB를 사용해 데이터를 조회하거나 조작하는 기능을 전담하도록 만든 오브젝트
* */

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service //이 컴포넌트가 어떤 용도로 사용될 것인지 annotation
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;
    static {
        users.add(new User(1,"Minjeong", new Date(), "pass1", "701010-111111"));
        users.add(new User(2,"Seungjae", new Date(), "pass2", "801010-111111"));
        users.add(new User(3,"Yeongsook", new Date(), "pass3", "901010-111111"));
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

    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()){
            User user = iterator.next();
            if (user.getId() == id){
                iterator.remove();
                return user;
            }
        }

        return null;
    }
    /*
     * 입력된 user와 id가 동일한 유저를 찾아서 해당 유저의 정보를 입력된 내용으로 수정한다.
     * 만약 일치하는 id를 가진 유저가 없다면, null을 리턴한다.
     * */
    public User revise(User user){
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()){
            User u = iterator.next();
            if (u.getId() == user.getId()){
                u.setName(user.getName());
                u.setJoinDate(user.getJoinDate());
                return u;
            }
        }

        return null;
    }
}
