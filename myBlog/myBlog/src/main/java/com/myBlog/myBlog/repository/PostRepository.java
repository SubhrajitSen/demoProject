package com.myBlog.myBlog.repository;

import com.myBlog.myBlog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {

}
