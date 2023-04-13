package com.cloud.boot.service.posts;

import com.cloud.boot.domain.posts.Posts;
import com.cloud.boot.domain.posts.PostsRepository;
import com.cloud.boot.web.dto.PostsResponseDto;
import com.cloud.boot.web.dto.PostsSaveRequestDto;
import com.cloud.boot.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다 id : " + id));
        return new PostsResponseDto(posts);
    }
}
