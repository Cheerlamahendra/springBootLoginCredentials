package com.springboot.mahitech99.controller;


import com.springboot.mahitech99.DTOClasses.UserSignUpData;
import com.springboot.mahitech99.DTOClasses.UserSignUpResponse;
import com.springboot.mahitech99.service.userSignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class SignUpController
{

    @Autowired
    userSignUpService userSignUpService;
    @PostMapping(path = "/user/signUp")
    public UserSignUpResponse signupUser(@RequestBody UserSignUpData userSignUpData)
    {
        System.out.println(userSignUpData);
        UserSignUpResponse exist =userSignUpService.suerSignUpData(userSignUpData);
        return exist;


    }
}
