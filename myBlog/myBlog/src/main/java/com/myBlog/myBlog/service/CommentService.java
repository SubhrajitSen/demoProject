package com.myBlog.myBlog.service;

import com.myBlog.myBlog.payload.CommentDto;

import java.util.List;

public interface CommentService {
    public CommentDto saveComment(Long id, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(Long id);

   CommentDto getCommentsByCommentId(Long id, Long commentId);

    CommentDto updateComment(Long postId, Long commentId, CommentDto commentDto);

    void deleteComment(Long postId, Long commentId);
}
