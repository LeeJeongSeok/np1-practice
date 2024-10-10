package com.jeongseok.np1practice.controller;

import com.jeongseok.np1practice.entity.Comment;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {


	public static void main(String[] args) {
		Comment comment = Comment.builder()
			.id(1L)
			.content("test")
			.build();

		System.out.println(comment.getId() + " "  + comment.getContent());
	}
}
