package com.jeongseok.np1practice.repository;

import com.jeongseok.np1practice.entity.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

//	@Query("select p from Post p join fetch p.postId")
//	List<Post> findAllPostAndComment();

	@Query("select p from Post p join fetch p.comments")
	List<Post> findAllPostAndComment();
}
