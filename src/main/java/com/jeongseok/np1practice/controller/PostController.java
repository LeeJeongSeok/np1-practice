package com.jeongseok.np1practice.controller;

import com.jeongseok.np1practice.dto.PostDto;
import com.jeongseok.np1practice.entity.Post;
import com.jeongseok.np1practice.service.PostService;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	@GetMapping("/post")
	public List<PostDto> getPost() {
		return postService.getPost();
	}

	// 바로 엔티티 객체를 뿌려주면 연관관계에 있는 객체들끼리 순환참조를 이루게된다. (양방향 연관관계 문제)
	// 한쪽에서 jsonignore해줘야한다
	@GetMapping("/test")
	public List<Post> test() {
		return postService.getPosts();
	}

	@GetMapping("/fetch-join")
	public List<PostDto> getPostWithFetchJoin() {
		return postService.getPostWithFetchJoin();
	}

}
