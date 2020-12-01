package com.hyuckang.springboot.web.dto;

import com.hyuckang.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // 클래스 내 모든 필드의 Getter 메소드 자동 추가(lombok)
@NoArgsConstructor // 기본 생성자 자동 추가(lombok)
public class PostsSaveRequestDto {

    String title;
    private String content;
    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성(lombok)
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
