package com.qkrtprjs.springbootproject.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)  //파라미터로선언된 객체에만 사용하겠다
@Retention(RetentionPolicy.RUNTIME) //
public @interface LoginUser {
}
