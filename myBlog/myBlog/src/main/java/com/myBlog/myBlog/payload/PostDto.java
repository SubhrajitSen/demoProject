package com.myBlog.myBlog.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class PostDto {
    private Long id;
    @NotEmpty
    @Size(min = 2, message = "Post title should be at least 2 characters")
    private String title;
    @NotEmpty
    @Size(min = 5, message = "Description should not be less than 10 characters")
    private String description;
    @NotEmpty
    private String content;
    private Set<CommentDto> commentDto;
}
