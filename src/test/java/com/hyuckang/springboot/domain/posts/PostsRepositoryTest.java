package com.hyuckang.springboot.domain.posts;


import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After  // @After : 단위 테스트가 종료될때마다, 수행되는 메소드
    public void cleanup() {
        postsRepository.deleteAll();    // deleteAll() : 모든 데이터 삭제
    }

    @Test
    public void 게시글저장_불러오기() {

        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("hyuckang15@gmail.com")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();  // findAll() : 모든 데이터 조회

        // then
        Posts posts = postsList.get(0);
        Assertions.assertThat(posts.getTitle()).isEqualTo(title);
        Assertions.assertThat(posts.getContent()).isEqualTo(content);
        Assertions.assertThat(posts.getAuthor()).isEqualTo("hyuckang15@gmail.com");

    }

}
