package com.myBlog.myBlog.payload;

import lombok.Data;

@Data
public class LogInDto {
    private String usernameOrEmail;
    private String password;
}
