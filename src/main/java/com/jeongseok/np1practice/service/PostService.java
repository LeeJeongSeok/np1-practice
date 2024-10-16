package com.jeongseok.np1practice.service;

import com.jeongseok.np1practice.controller.PostController;
import com.jeongseok.np1practice.dto.CommentDto;
import com.jeongseok.np1practice.dto.PostDto;
import com.jeongseok.np1practice.entity.Comment;
import com.jeongseok.np1practice.entity.Post;
import com.jeongseok.np1practice.repository.PostRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;

	public List<PostDto> getPost() {
		System.out.println("post 테이블 조회");
		List<Post> posts = postRepository.findAll(); // N + 1에서 1를 담당

		List<PostDto> postDtos = new ArrayList<>();

		for (Post post : posts) {
			System.out.println("post에서 comment 테이블조회");
			List<Comment> comments = post.getComments(); // N + 1에서 N를 담당

			List<CommentDto> commentDtos = new ArrayList<>();
			for (Comment comment : comments) {
				commentDtos.add(CommentDto.of(comment, post.getPostId()));
			}

			postDtos.add(PostDto.of(post, commentDtos));
		}

		return postDtos;
	}

	public List<Post> getPosts() {
		return postRepository.findAll();
	}

	public List<PostDto> getPostWithFetchJoin() {
		return postRepository.findAllPostAndComment()
			.stream()
			.map(post -> PostDto.of(post,
				post.getComments()
					.stream()
					.map(comment -> CommentDto.of(comment, post.getPostId()))
					.toList())
			)
			.toList();
	}
}
