package com.jeongseok.np1practice.dto;

import com.jeongseok.np1practice.entity.Comment;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentDto {

	private long commentId;
	private String content;
	private long postId;

	public static CommentDto of(Comment comment, long postId) {
		return new CommentDto(comment.getCommentId(), comment.getContent(), postId);
	}

}
