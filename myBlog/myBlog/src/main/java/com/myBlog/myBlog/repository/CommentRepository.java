package com.myBlog.myBlog.repository;

import com.myBlog.myBlog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long id);
    List<Comment> findByEmail(String Email);
}
