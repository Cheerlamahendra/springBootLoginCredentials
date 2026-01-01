package com.springboot.mahitech99.DTOClasses;

import lombok.Data;

@Data
public class UserSignUpData
{
    private String username;
    private long mobile;
    private String email;
    private String password;

}
