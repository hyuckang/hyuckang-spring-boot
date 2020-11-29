package com.hyuckang.springboot.web.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언된 모든 필드의 get메소드 생성
@RequiredArgsConstructor // final가 붙은 모든 필드의 생성자 생성, final이 없으면 생성 X
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
