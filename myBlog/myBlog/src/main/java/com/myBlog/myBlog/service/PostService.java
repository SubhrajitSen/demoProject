package com.myBlog.myBlog.service;

import com.myBlog.myBlog.payload.PostDto;
import com.myBlog.myBlog.payload.PostResponse;

public interface PostService {
    PostDto createPost(PostDto postDto);

   PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePostById(PostDto postDto, long id);

    void deletePostById(long id);
}
