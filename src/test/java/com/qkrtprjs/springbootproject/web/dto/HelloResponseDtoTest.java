package com.qkrtprjs.springbootproject.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복기능_테스트() throws Exception {
        //given
        String name = "test";
        int amount=1000;
        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);
        //then
        assertThat(dto.getName()).isEqualTo(name);
        //테스트 검증 라이브러리의 검증 메소드 검증하고 싶은 댓상을 메소드 인자로 받는다.
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
