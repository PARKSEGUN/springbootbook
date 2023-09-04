package com.qkrtprjs.springbootproject.config.auth.dto;

import com.qkrtprjs.springbootproject.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {  //세션에 사용자 정보를 저장하기위한 DTO
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
