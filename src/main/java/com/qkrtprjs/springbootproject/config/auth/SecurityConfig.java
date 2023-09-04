package com.qkrtprjs.springbootproject.config.auth;

import com.qkrtprjs.springbootproject.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity  //spring security 설정 활성화
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .headers().frameOptions().disable() //h2-console 화면을 사용하기위한 해당 옵션들 disable
                .and()
                .authorizeRequests()    //antMatchers 옵션을 사용하기위한 설정, url별 권한 관리를 설정하는 시작점
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()//권한 관리 대상 지정 url, html 관리 , permitAll() 누구한테나 열람가능
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())//해당 주소는 USER의 권한을 가직 사람만 열람
                .anyRequest().authenticated()//나머지 요청들을 인증이 된 사용자만 허용
                .and()
                .logout()//로그아웃 설정 시작
                .logoutSuccessUrl("/")  //로그아웃시에 /로 이동
                .and()
                .oauth2Login()//OAuth2 로그인 기능에대한 설정의 시작
                .userInfoEndpoint()//로그인 성공시에 사용자 정보를 가져올때 설정 담당
                .userService(customOAuth2UserService);  //로그인 성공시에 후속 조치를 진행할 UserService 인터페이스 구현체 등록, 리소스 서버에서 가져온 정보갖고 추가로 진행하고싶은 기능 추가가능
        return httpSecurity.build();
    }

}