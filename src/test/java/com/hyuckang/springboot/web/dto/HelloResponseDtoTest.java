package com.hyuckang.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        // given
        String name = "test";
        int amount = 100;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        // assertThat : assertj의 검증 메소드, 검증하고 싶은 대상을 인자로 받는다
        // isEqualTo : 동등 비교 메소드, 값을 비교해서 같을 때만 성공
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);


    }
}
