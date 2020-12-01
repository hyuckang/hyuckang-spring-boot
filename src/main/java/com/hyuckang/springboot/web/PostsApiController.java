package com.hyuckang.springboot.web;

import com.hyuckang.springboot.service.posts.PostsService;
import com.hyuckang.springboot.web.dto.PostsResponseDto;
import com.hyuckang.springboot.web.dto.PostsSaveRequestDto;
import com.hyuckang.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor // final이 선언된 필드를 인자로 하는 생성자 자동 생성(lombok)
@RestController // 컨트롤러가 JSON을 반환하도록 만들어준다
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts") // Post 요청이 들어왔을 때 매핑
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

}
