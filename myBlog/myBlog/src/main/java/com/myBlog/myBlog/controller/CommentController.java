package com.myBlog.myBlog.controller;

import com.myBlog.myBlog.payload.CommentDto;
import com.myBlog.myBlog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping("/{post_id}")
    public ResponseEntity<?> saveOneComment( @PathVariable("post_id") Long id,@Valid @RequestBody CommentDto commentDto, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        CommentDto dto = commentService.saveComment(id, commentDto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{post_id}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable("post_id") Long id){
        return commentService.getCommentsByPostId(id);
    }

    @GetMapping("/{post_id}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentsByCommentsId(@PathVariable("post_id") Long id,
                                                    @PathVariable("id") Long commentId){
        CommentDto dto = commentService.getCommentsByCommentId(id, commentId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @PutMapping("/{post_id}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable("post_id") Long postId,
                                                    @PathVariable("id") Long commentId,
                                                    @RequestBody CommentDto commentDto){
        CommentDto dto = commentService.updateComment(postId, commentId, commentDto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable("postId") Long postId,
                                                @PathVariable("id") Long commentId){
        commentService.deleteComment(postId, commentId);
        return ResponseEntity.ok("Comment is deleted");
    }
}
