// User 도메인 클래스
package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
//@JsonIgnoreProperties(value={"password","ssn"})
@JsonFilter("UserInfo")
public class User {
    private Integer id;

    @Size(min=2, message = "Name은 2글자 이상 입력해주세요.")
    private String name;
    @Past //과거의 날짜만 입력 가능
    private Date joinDate;

//    @JsonIgnore
    private String password;

    private String ssn; //주민등록번호
}
