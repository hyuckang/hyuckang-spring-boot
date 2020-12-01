package com.hyuckang.springboot.service.posts;

import com.hyuckang.springboot.domain.posts.Posts;
import com.hyuckang.springboot.domain.posts.PostsRepository;
import com.hyuckang.springboot.web.dto.PostsResponseDto;
import com.hyuckang.springboot.web.dto.PostsSaveRequestDto;
import com.hyuckang.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor // final이 선언된 필드를 인자로 하는 생성자 자동 생성(lombok)
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없는니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }


    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없는니다. id = " + id));

        return new PostsResponseDto(entity);
    }
}
