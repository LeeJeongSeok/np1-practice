package com.jeongseok.np1practice.dto;

import com.jeongseok.np1practice.entity.Post;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostDto {

	private long postId;
	private String title;
	private String content;
	private List<CommentDto> comments;

	public static PostDto of(Post post, List<CommentDto> comments) {
		return new PostDto(post.getPostId(), post.getTitle(), post.getContent(), comments);
	}
}
