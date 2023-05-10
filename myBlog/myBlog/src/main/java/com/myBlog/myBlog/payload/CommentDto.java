package com.myBlog.myBlog.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CommentDto {

    private Long id;
    @NotEmpty
    @Size(min = 6, message = "Name should not be less than 6 characters")
    private String name;
    @NotEmpty
    @Email(message = "Please provide a valid email address")
    @Pattern(regexp=".+@.+\\.com", message="Email should be of the form user@domain.com")
    private String email;
    @NotEmpty
    private String body;
}
