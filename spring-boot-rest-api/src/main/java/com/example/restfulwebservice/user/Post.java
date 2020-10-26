package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    // User : Post -> 1 : (0~N), Main : Sub - > Parent : Child
    // Post가 Many, User가 One
    // LAZY  지연 로딩, 포스트 데이터가 필요로 하는 시점에 유저 데이터를 가져오겠다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
}
