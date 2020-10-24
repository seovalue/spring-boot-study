// User 도메인 클래스
package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
//@JsonIgnoreProperties(value={"password","ssn"})
@JsonFilter("UserInfoV2")
public class UserV2 extends User{
    private String grade;

    public UserV2(){};
}
