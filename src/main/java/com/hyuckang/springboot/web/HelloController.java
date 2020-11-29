package com.hyuckang.springboot.web;

import com.hyuckang.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController // 컨트롤러가 JSON을 반환하도록 만들어준다
public class HelloController {
    
    @GetMapping("/hello")   // [도메인]/hello로 GET 요청이 들어왔을때 매핑
    public String hello() {
        return "hello";
    }
    
    // @RequestParam : 파라미터를 가져오는 어노테이션
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
