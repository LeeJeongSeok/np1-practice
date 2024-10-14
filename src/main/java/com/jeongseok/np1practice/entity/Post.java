package com.jeongseok.np1practice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private long postId;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@OneToMany(mappedBy = "post")
	private List<Comment> comments = new ArrayList<>();

	@Builder
	public Post(long postId, String title, String content) {
		this.postId = postId;
		this.title = title;
		this.content = content;
	}

	public void addComment(Comment comment) {
		if (!comments.contains(comment)) {
			comments.add(comment);
			comment.addPost();
		}
	}
}
