package com.qkrtprjs.springbootproject.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
//Junit에 내장된 샐행자 외에 다른 실행자를 실행시킨다. 여기서는 SpringRunner라는 스프링 실행자를 사용, 스프링 부트 테스트와 Junit 사이에 연결자 역할
@WebMvcTest //Web에 집중할 수 있는 스프링 테스트 어노테이션, @Controller, @ControllerAdvice 사용가능 서비스나 레파지토리는 사용 불가
public class HelloControllerTest {  //이름은 보통 대상클래스이름에 Test를 추가로 붙여준다 구조는 생성했던 구조와 비슷하게 만들어준다.

    @Autowired
    private MockMvc mvc;
    //스프링 api를 테스트하는데에 여러가지 방법이 있지만 MockMVC는 가상의 서버를 동작시키기때문에 더 빠른 속도로 테스트를 할 수 있다.

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk()) //정상인지 Status 코드 확인
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("hello"))
                .andExpect(jsonPath("amount").value(amount));
    }
}
